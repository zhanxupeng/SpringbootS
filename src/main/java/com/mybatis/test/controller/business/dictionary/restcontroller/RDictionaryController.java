package com.mybatis.test.controller.business.dictionary.restcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.dictionary.viewmodel.HumanQuestionVM;
import com.mybatis.test.controller.business.dictionary.viewmodel.SecurityQuestionVM;
import com.mybatis.test.model.Dictionary;
import com.mybatis.test.service.api.IDictionaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("rest/dictionary")
public class RDictionaryController extends BaseController {
    @Resource
    private IDictionaryService dictionaryService;

    @GetMapping("securityQuestion")
    public Response getSecurityQuestion() {
        List<Dictionary> dictionaryList = dictionaryService.getSecurityQuestion();
        return result(getSecurityQuestionVMList(dictionaryList));
    }


    @GetMapping("humanQuestion")
    public Response getHumanQuestion() {
        Dictionary dictionary = dictionaryService.getHumanCheckQuestion();
        return result(getHumanQuestionVM(dictionary));
    }

    private HumanQuestionVM getHumanQuestionVM(Dictionary dictionary) {
        HumanQuestionVM humanQuestionVM = new HumanQuestionVM();
        humanQuestionVM.setAnswer(dictionary.getKey());
        humanQuestionVM.setQuestion(dictionary.getLabel());
        return humanQuestionVM;
    }

    private List<SecurityQuestionVM> getSecurityQuestionVMList(List<Dictionary> dictionaryList) {
        return dictionaryList.stream().map(x -> {
            SecurityQuestionVM securityQuestionVM = new SecurityQuestionVM();
            securityQuestionVM.setKey(x.getKey());
            securityQuestionVM.setQuestion(x.getLabel());
            return securityQuestionVM;
        }).collect(Collectors.toList());
    }
}
