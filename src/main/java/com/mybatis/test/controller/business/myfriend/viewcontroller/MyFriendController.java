package com.mybatis.test.controller.business.myfriend.viewcontroller;

import com.mybatis.test.common.base.Response;
import com.mybatis.test.controller.base.BaseController;
import com.mybatis.test.controller.business.myfriend.viewmodel.MyFamiliarityFriendVM;
import com.mybatis.test.domain.MyFamiliarityFriendInfo;
import com.mybatis.test.service.api.myfriend.IMyFriendService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("friend")
public class MyFriendController extends BaseController {
    @Resource
    private IMyFriendService myFriendService;

    @GetMapping("familiarityRank")
    public Response familiarityRank() {
        List<MyFamiliarityFriendInfo> myFamiliarityFriendInfoList = myFriendService.getMyFamiliarityFriend();
        List<MyFamiliarityFriendVM> myFamiliarityFriendVMList = myFamiliarityFriendInfoList.stream().map(MyFamiliarityFriendVM::new)
                .collect(Collectors.toList());
        return result(myFamiliarityFriendVMList);
    }
}
