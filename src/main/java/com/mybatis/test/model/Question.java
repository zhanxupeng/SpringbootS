package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class Question extends BaseModel{
    private String question;

    private String answer;

    private String customerId;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}