package com.mybatis.test.controller.business.customer.paramsmodel;

/**
 * Created by 占大帅 on 2017/12/2.
 */
public class SecurityQuestionPM {
    private String question;        //密保问题
    private String answer;          //密保答案

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
}
