package com.mybatis.test.controller.business.dynamic.viewmodel;

import com.mybatis.test.common.util.DateUtil;
import com.mybatis.test.model.Customer;
import com.mybatis.test.model.Dynamic;

import java.util.List;

public class DynamicDetailVM {
    private Customer customer;
    private Dynamic dynamic;
    private String label;
    List<CommentsDetailVM> commentsList;

    public DynamicDetailVM(Customer customer, Dynamic dynamic, String label, List<CommentsDetailVM> commentsList) {
        this.customer = customer;
        this.dynamic = dynamic;
        this.label = label;
        this.commentsList = commentsList;
    }

    /**
     * 动态id
     */
    public String getDynamicId() {
        return dynamic.getId();
    }

    /**
     * 标题
     */
    public String getTitle() {
        return dynamic.getTitle();
    }

    /**
     * 标签
     */
    public String getLabel() {
        return label;
    }

    /**
     * 评论条数
     */
    public int getCommentsNumber() {
        return dynamic.getCommentsNumber();
    }

    /**
     * 人气
     */
    public int getPopularity() {
        return dynamic.getPopularity();
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
     * 发动态时间
     */
    public String getCreateDate() {
        return DateUtil.convertDateToString(dynamic.getCreateDate(), DateUtil.YYYY_MM_DD);
    }

    /**
     * 获赞
     */
    public int getPraise() {
        return dynamic.getPraise();
    }

    /**
     * 内容
     */
    public String getContent() {
        return dynamic.getContent();
    }

    public List<CommentsDetailVM> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<CommentsDetailVM> commentsList) {
        this.commentsList = commentsList;
    }
}
