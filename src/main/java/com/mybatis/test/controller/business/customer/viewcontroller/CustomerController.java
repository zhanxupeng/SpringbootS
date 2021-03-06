package com.mybatis.test.controller.business.customer.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.common.config.CustomerUtils;
import com.mybatis.test.common.enumeration.NoticeReceiveStatusEnum;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.customer.paramsmodel.BasicInformationPM;
import com.mybatis.test.controller.business.customer.paramsmodel.PasswordModifyPM;
import com.mybatis.test.controller.business.customer.paramsmodel.RegisterCustomerPM;
import com.mybatis.test.controller.business.customer.paramsmodel.SecurityQuestionPM;
import com.mybatis.test.controller.business.customer.viewmodel.*;
import com.mybatis.test.domain.HomeComments;
import com.mybatis.test.domain.LatestDynamic;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.MyAlbum;
import com.mybatis.test.model.MyNotice;
import com.mybatis.test.model.Question;
import com.mybatis.test.service.api.comments.ICommentsService;
import com.mybatis.test.service.api.customer.ICustomerService;
import com.mybatis.test.service.api.dynamic.IDynamicService;
import com.mybatis.test.service.api.myfriend.IMyFriendService;
import com.mybatis.test.service.api.mynotice.IMyNoticeService;
import com.mybatis.test.service.api.question.IQuestionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("customer")
public class CustomerController extends BaseController {
    @Resource
    private ICustomerService customerService;
    @Resource
    private IQuestionService questionService;
    @Resource
    private IDynamicService dynamicService;
    @Resource
    private ICommentsService commentsService;
    @Resource
    private IMyFriendService myFriendService;
    @Resource
    private IMyNoticeService myNoticeService;

    /**
     * 拒绝好友请求
     */
    @GetMapping("friendRefuse")
    @ResponseBody
    public Response friendRefuse(String friendId) {
        myNoticeService.refuseFriendApply(CustomerUtils.getCustomer().getId(), friendId);
        return success();
    }

    /**
     * 拒绝所有好友请求
     */
    @GetMapping("friendRefuseAll")
    @ResponseBody
    public Response friendRefuseAll() {
        myNoticeService.refuseAllFriendApply(CustomerUtils.getCustomer().getId());
        return success();
    }

    /**
     * 同意好友请求
     */
    @GetMapping("friendAgree")
    @ResponseBody
    public Response friendAgree(String friendId) {
        //添加好友
        myFriendService.addFriend(CustomerUtils.getCustomer().getId(), friendId);
        return success();
    }

    /**
     * 同意所有好友请求
     */
    @GetMapping("friendAgreeAll")
    @ResponseBody
    public Response friendAgreeAll() {
        //添加所有好友
        myFriendService.addAllFriend(CustomerUtils.getCustomer().getId());
        return success();
    }

    /**
     * 我的主页
     */
    @GetMapping("home")
    public String home(String customerId, Model model) {
        //如果customerId为空，则为个人主页，需要登录
        if (StringUtils.isBlank(customerId) && StringUtils.isBlank(CustomerUtils.getCustomer().getId())) {
            return "redirect:/customer/loginView";
        }
        String resultCustomerId = StringUtils.isBlank(customerId) ? CustomerUtils.getCustomer().getId() : customerId;
        //个人信息
        Customer customer = customerService.selectById(resultCustomerId);
        model.addAttribute("customer", new CustomerHomeVM(customer));
        //最近动态
        List<LatestDynamic> latestDynamicList = dynamicService.getLatestDynamic(resultCustomerId);
        List<LatestDynamicVM> latestDynamicVMList = latestDynamicList.stream().map(LatestDynamicVM::new).collect(toList());
        model.addAttribute("dynamicList", latestDynamicVMList);
        //最近评论
        List<HomeComments> homeCommentsList = commentsService.getCustomerLatest(resultCustomerId);
        List<HomeCommentsVM> homeCommentsVMList = homeCommentsList.stream().map(HomeCommentsVM::new).collect(toList());
        model.addAttribute("commentsList", homeCommentsVMList);
        //相册
        List<MyAlbum> myAlbumList = customerService.getCustomerAlbum(resultCustomerId);
        List<MyAlbumVM> myAlbumVMList = myAlbumList.stream().map(MyAlbumVM::new).collect(toList());
        model.addAttribute("myAlbumList", myAlbumVMList);
        return "user/home";
    }

    /**
     * 获取签到信息
     */
    @GetMapping("signIn")
    @ResponseBody
    public SignInVM getSignIn() {
        return new SignInVM(customerService.getSignIn());
    }

    /**
     * 保存相册图片
     */
    @PostMapping("savePhoto")
    @ResponseBody
    public Map savePhoto(String photoUrl) {
        Map<String, Object> map = new TreeMap<>();
        map.put("msg", "保存到相册成功");
        try {
            customerService.savePhoto(photoUrl, CustomerUtils.getCustomer().getId());
            map.put("status", 0);
        } catch (Exception e) {
            map.put("msg", e.getMessage());
        }
        return map;
    }

    /**
     * 用户签到
     */
    @GetMapping("sign")
    @ResponseBody
    public SignVM sign() {
        return new SignVM(customerService.sign());
    }

    /**
     * 基本设置
     */
    @GetMapping("setView")
    public String setView(Model model) {
        Customer customer = customerService.selectById(CustomerUtils.getCustomer().getId());
        model.addAttribute("customerInformation", new CustomerInformationVM(customer));
        return "user/set";
    }

    /**
     * 修改我的资料
     */
    @PostMapping("setBasic")
    @ResponseBody
    public Map setBasic(BasicInformationPM basicInformationPM) {
        Customer customer = basicInformationPM.getCustomer();
        customer.setId(CustomerUtils.getCustomer().getId());
        customerService.update(customer);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "redirect:/customer/setView");
        map.put("msg", "修改成功");
        return map;
    }

    /**
     * 修改头像
     */
    @PostMapping("modifyHead")
    @ResponseBody
    public void modifyHead(BasicInformationPM basicInformationPM) {
        Customer customer = basicInformationPM.getCustomer();
        customer.setId(CustomerUtils.getCustomer().getId());
        customerService.update(customer);
    }

    /**
     * 修改密码
     */
    @PostMapping("modifyPassword")
    @ResponseBody
    public Map modifyPassword(PasswordModifyPM passwordModifyPM) {
        Customer customer = customerService.selectById(CustomerUtils.getCustomer().getId());
        Map<String, Object> map = new TreeMap<>();
        if (!customer.getPassword().equals(passwordModifyPM.getOldPass())) {
            map.put("msg", "当前密码输入错误，请重新输入");
            return map;
        }
        Customer modifyCustomer = new Customer();
        modifyCustomer.setId(customer.getId());
        modifyCustomer.setPassword(passwordModifyPM.getNewPass());
        customerService.update(modifyCustomer);
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//退出
        map.put("status", 0);
        map.put("action", "/customer/loginView");
        map.put("msg", "修改成功,请重新登录");
        return map;
    }

    /**
     * 我的消息
     */
    @GetMapping("messageView")
    public String messageView() {
        return "user/message";
    }

    /**
     * 好友验证
     */
    @GetMapping("identityView")
    public String identityView(Model model) {
        model.addAttribute("friendIdentityArray", myNoticeService.getWaitDeal(CustomerUtils.getCustomer().getId()).stream().map(FriendIdentityVM::new).toArray());
        return "user/identity";
    }

    /**
     * 添加好友
     */
    @GetMapping("addFriend")
    @ResponseBody
    public AddFriendVM addFriend(String customerId) {
        AddFriendVM addFriendVM = new AddFriendVM();
        addFriendVM.setStatus(true);
        addFriendVM.setMsg("申请已发送，请耐心等待");
        try {
            addFriendValid(customerId);
            //新增好友申请
            addFriendApply(customerId);
        } catch (Exception e) {
            e.printStackTrace();
            addFriendVM.setStatus(false);
            addFriendVM.setMsg(e.getMessage());
        }
        return addFriendVM;
    }

    private void addFriendValid(String customerId) {
        //查询好友表是否已经有该好友
        if (myFriendService.isAlreadyFriend(CustomerUtils.getCustomer().getId(), customerId)) {
            throw new RuntimeException("你已经添加他为好友，不可重复添加");
        }
        //如果已经发送申请，并且是待确认，则不可重复发送
        if (myNoticeService.isAlreadyApply(CustomerUtils.getCustomer().getId(), customerId)) {
            throw new RuntimeException("你已经发送过申请，请耐心等待");
        }
    }

    private void addFriendApply(String customerId) {
        MyNotice myNotice = new MyNotice();
        myNotice.init();
        myNotice.setSendCustomerId(CustomerUtils.getCustomer().getId());
        myNotice.setReceiveCustomerId(customerId);
        myNotice.setReceiveStatus(NoticeReceiveStatusEnum.WAIT.getValue());
        myNoticeService.insert(myNotice);
    }

    /**
     * 用户中心
     */
    @GetMapping("indexView")
    public String indexView(Model model) {
        CustomerIndexVM customerIndexVM = new CustomerIndexVM();
        customerIndexVM.setMyDynamicCount(dynamicService.getMyDynamicCount(CustomerUtils.getCustomer().getId()));
        model.addAttribute("customerIndex", customerIndexVM);
        return "user/index";
    }


    /**
     * 登录页面
     */
    @GetMapping("loginView")
    public String loginView() {
        return "user/login";
    }

    /**
     * 登出页面
     */
    @GetMapping("logout")
    public String logout() {
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//退出原来用户
        return "user/login";
    }

    /**
     * 登录接口
     */
    @PostMapping("login")
    @ResponseBody
    public Map login(String userName, String password) {
        Map<String, Object> map = new TreeMap<>();
        //map.put("status", 1);

        Customer customer = customerService.selectByUserName(userName);
        if (customer == null) {
            map.put("msg", "用户不存在");
            return map;
        }
        if (!customer.getPassword().equals(password)) {
            map.put("msg", "账号密码错误");
            return map;
        }
        SecurityUtils.getSecurityManager().logout(SecurityUtils.getSubject());//如果原来有的话，就退出
        //登录后存放进shiro token
        UsernamePasswordToken token = new UsernamePasswordToken(customer.getUserName(), customer.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);

        map.put("status", 0);
        map.put("action", "/index");
        map.put("msg", "登录成功");
        return map;
    }

    /**
     * 注册页面
     */
    @GetMapping("registerView")
    public String registerView() {
        return "user/reg";
    }

    /**
     * 注册接口
     */
    @PostMapping("register")
    @ResponseBody
    public Map register(RegisterCustomerPM registerCustomerPM) {
        save(registerCustomerPM);
        Map<String, Object> map = new TreeMap<>();
        map.put("status", 0);
        map.put("action", "/customer/loginView");
        map.put("msg", "注册成功，请登录");
        return map;
    }

    /**
     * 验证账号知否已经注册
     */
    @GetMapping("userNameCheck")
    @ResponseBody
    public Response checkUserName(String userName) {
        Customer customer = customerService.selectByUserName(userName);
        return result(getCheckResult(customer));
    }

    /**
     * 获取用户信息的接口
     */
    @GetMapping("information")
    @ResponseBody
    public Customer getCustomer() {
        Customer customer = customerService.selectById(CustomerUtils.getCustomer().getId());
        return customer;
    }


    private BoolVM getCheckResult(Customer customer) {
        BoolVM boolVM = new BoolVM();
        boolVM.setStatus(true);
        boolVM.setInfo("恭喜你，当前用户名可用！");
        if (null != customer) {
            boolVM.setStatus(false);
            boolVM.setInfo("非常抱歉，当前用户名已经被使用！");
        }
        return boolVM;
    }

    private void save(RegisterCustomerPM registerCustomerPM) {
        Customer customer = new Customer();
        customer.init();
        customer.setUserName(registerCustomerPM.getUserName());
        customer.setNickName(registerCustomerPM.getNickName());
        customer.setPassword(registerCustomerPM.getPassword());
        customer.setSex(registerCustomerPM.getSex());
        customer.setHeadPicture("\\image\\show?imagePath=G%3A%5Clunwen%5Cpicture%5C15140023287112.jpg");//默认头像
        customer.setActiveValue(0);
        customer.setPraise(0);
        customer.setContinueActiveCount(0);
        customer.setPopularity(0);
        customer.setIdentify(false);
        customer.setAcademy("未知学院");
        customer.setClassRoom("未知年级");
        customer.setBedroom("未知寝室");
        customer.setRealName("未知");
        customerService.insert(customer);
        if (registerCustomerPM.isSecurity()) {
            for (SecurityQuestionPM securityQuestionPM : registerCustomerPM.getSecurityQuestionPMList()) {
                Question question = new Question();
                question.init();
                question.setQuestion(securityQuestionPM.getQuestion());
                question.setAnswer(securityQuestionPM.getAnswer());
                question.setCustomerId(customer.getId());
                questionService.insert(question);
            }
        }
    }
}
