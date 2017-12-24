package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.Comments;
import com.mybatis.test.model.Customer;

public class CommentsDetailVM {
    private Comments comments = new Comments();
    private Customer customer = new Customer();

    public CommentsDetailVM(Comments comments, Customer customer) {
        this.comments = comments;
        this.customer = customer;
    }

    /**
     * 用户id
     */
    public String getCustomerId() {
        return customer.getId();
    }

    /**
     * 用户头像
     */
    public String getCustomerHead() {
        return customer.getHeadPicture();
    }

    /**
     * 用户昵称
     */
    public String getNickName() {
        return customer.getNickName();
    }

    /**
     * 评论id
     */
    public String getCommentsId() {
        return comments.getId();
    }

    /**
     * 评论创建时间
     */
    public String getCreateDate() {
        return DateUtil.convertDateToString(comments.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    /**
     * 评论内容
     */
    public String getContent() {
        return comments.getContent();
    }

    /**
     * 获赞
     */
    public int getPraise() {
        return comments.getPraise();
    }

}
