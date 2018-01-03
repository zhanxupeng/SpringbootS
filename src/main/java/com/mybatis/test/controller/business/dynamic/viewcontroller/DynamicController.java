package com.mybatis.test.controller.business.dynamic.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.common.enumeration.DynamicTypeEnum;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.dynamic.paramsmodel.CurrentTitlePM;
import com.mybatis.test.controller.business.dynamic.paramsmodel.DynamicPM;
import com.mybatis.test.controller.business.dynamic.paramsmodel.DynamicPagePM;
import com.mybatis.test.controller.business.dynamic.paramsmodel.ReplyDynamicPM;
import com.mybatis.test.controller.business.dynamic.viewmodel.CommentsDetailVM;
import com.mybatis.test.controller.business.dynamic.viewmodel.CurrentTitleVM;
import com.mybatis.test.controller.business.dynamic.viewmodel.DynamicDetailVM;
import com.mybatis.test.controller.business.dynamic.viewmodel.DynamicIntroductionVM;
import com.mybatis.test.domain.DynamicIntroduction;
import com.mybatis.test.model.Comments;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Dictionary;
import com.mybatis.test.model.Dynamic;
import com.mybatis.test.service.api.comments.ICommentsService;
import com.mybatis.test.service.api.customer.ICustomerService;
import com.mybatis.test.service.api.dictionary.IDictionaryService;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dynamic")
public class DynamicController extends BaseController {

    @Resource
    private IDynamicService dynamicService;

    @Resource
    private ICustomerService customerService;

    @Resource
    private IDictionaryService dictionaryService;

    @Resource
    private ICommentsService commentsService;

    /**
     * 查看动态
     */
    @GetMapping("index")
    public String index(CurrentTitlePM currentTitlePM, Model model) {
        if (DynamicTypeEnum.isNeedLogin(currentTitlePM.getFirstTitle(), currentTitlePM.getSecondTitle())
                && StringUtils.isBlank(CustomerUtils.getCustomer().getId())) {
            return "redirect:/user/login";
        }
        List<Dictionary> moodList = dictionaryService.getDynamicSecondTitle(DynamicTypeEnum.DYNAMIC_MOOD.getValue());
        List<Dictionary> topicList = dictionaryService.getDynamicSecondTitle(DynamicTypeEnum.DYNAMIC_TOPIC.getValue());
        currentTitlePM.setCount(dynamicService.getCountByAppointCategory(currentTitlePM.getFirstTitle(),
                currentTitlePM.getSecondTitle()));
        model.addAttribute("moodList", moodList);
        model.addAttribute("topicList", topicList);
        model.addAttribute("category", currentTitlePM);
        return "jie/index";
    }

    /**
     * 分页查询
     */
    @PostMapping("page")
    @ResponseBody
    public Response page(DynamicPagePM dynamicPagePM) {
        List<DynamicIntroduction> list = dynamicService.findDynamicIntroductionList(dynamicPagePM.getDynamicPage());
        List<DynamicIntroductionVM> dynamicIntroductionVMList = list.stream().map(DynamicIntroductionVM::new)
                .collect(Collectors.toList());
        return result(dynamicIntroductionVMList);
    }

    @GetMapping("addView")
    public String addView() {
        return "jie/add";
    }

    @PostMapping("add")
    @ResponseBody
    public Map add(DynamicPM dynamicPM) {
        String dynamicId = save(dynamicPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "/dynamic/detailView?dynamicId=" + dynamicId);
        map.put("msg", "发布成功，去看一看吧");
        return map;
    }

    @GetMapping("detailView")
    public String detailView(String dynamicId, Model model) {
        if (StringUtils.isBlank(dynamicId)) {
            dynamicId = "7fc4f86bb4164591b9cbabaaa5693b2b";
        }
        Dynamic dynamic = dynamicService.selectById(dynamicId);
        Customer customer = customerService.selectById(dynamic.getCustomerId());
        String label = dictionaryService.getLabel(DynamicTypeEnum.getLabelByValue(dynamic.getFirstTitle()),
                dynamic.getSecondTitle());
        //这里还要加上评论
        List<Comments> commentsList = commentsService.getDynamicComments(dynamicId);
        List<CommentsDetailVM> list = getCommentsDetailVMList(commentsList);
        DynamicDetailVM dynamicDetailVM = new DynamicDetailVM(customer, dynamic, label, list);
        //用户查看，需要把人气加1
        dynamic.setPopularity(dynamic.getPopularity() + 1);
        dynamicService.update(dynamic);
        model.addAttribute("dynamic", dynamicDetailVM);

        List<Dictionary> moodList = dictionaryService.getDynamicSecondTitle(DynamicTypeEnum.DYNAMIC_MOOD.getValue());
        List<Dictionary> topicList = dictionaryService.getDynamicSecondTitle(DynamicTypeEnum.DYNAMIC_TOPIC.getValue());
        model.addAttribute("moodList", moodList);
        model.addAttribute("topicList", topicList);
        //还有当前分类，用于正确显示导航栏目
        model.addAttribute("category", new CurrentTitleVM(dynamic.getFirstTitle(), dynamic.getSecondTitle()));
        return "jie/detail";
    }

    /**
     * 评论接口，这个接口需要登录
     */
    @PostMapping("reply")
    @ResponseBody
    public Map reply(ReplyDynamicPM replyDynamicPM) {
        saveComments(replyDynamicPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "/dynamic/detailView?dynamicId=" + replyDynamicPM.getComments().getDynamicId());
        map.put("msg", "评论成功~");
        return map;
    }

    private List<CommentsDetailVM> getCommentsDetailVMList(List<Comments> commentsList) {
        return commentsList.stream().map(x -> {
            Customer customer = customerService.selectById(x.getCustomerId());
            return new CommentsDetailVM(x, customer);
        }).collect(Collectors.toList());
    }

    private void saveComments(ReplyDynamicPM replyDynamicPM) {
        Comments comments = replyDynamicPM.getComments();
        comments.init();
        comments.setCustomerId(CustomerUtils.getCustomer().getId());
        comments.setPraise(0);
        commentsService.insert(comments);

        //更新动态，人气加5，评论加1
        Dynamic dynamic = dynamicService.selectById(comments.getDynamicId());
        dynamic.preUpdate();
        dynamic.setPopularity(dynamic.getPopularity() + 5);
        dynamic.setCommentsNumber(dynamic.getCommentsNumber() + 1);
        dynamicService.update(dynamic);

        //这里还要考虑给用户发消息，暂时未写
    }

    private String save(DynamicPM dynamicPM) {
        Customer customer = CustomerUtils.getCustomer();
        Dynamic dynamic = dynamicPM.getDynamic();
        dynamic.init();
        dynamic.setCustomerId(customer.getId());
        dynamic.setPopularity(1);
        dynamic.setPraise(0);
        dynamic.setCommentsNumber(0);
        dynamicService.insert(dynamic);
        return dynamic.getId();
    }
}
