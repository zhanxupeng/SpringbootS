package com.mybatis.test.model;

import com.mybatis.test.common.base.BaseModel;

public class Dictionary extends BaseModel{
    private String type;

    private String key;

    private String label;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}