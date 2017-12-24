package com.mybatis.test.controller.business.dynamic.paramsmodel;

import com.mybatis.test.model.Comments;

public class ReplyDynamicPM {
    private Comments comments = new Comments();

    public void setToCustomerId(String toCustomerId) {
        comments.setToCustomerId(toCustomerId);
    }

    public void setDynamicId(String dynamicId) {
        comments.setDynamicId(dynamicId);
    }

    public void setContent(String content) {
        comments.setContent(content);
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }
}
