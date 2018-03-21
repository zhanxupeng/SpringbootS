package com.mybatis.test.common.enumeration;

import java.util.Arrays;

public enum DynamicMoodEnum {
    FRIEND("1","朋友"),
    NEARBY("2","身边"),
    SCHOOL("3","校园");
    private String type;
    private String description;
    DynamicMoodEnum(String type,String description){
        this.type=type;
        this.description=description;
    }

    public static DynamicMoodEnum getByType(String type){
        return Arrays.stream(DynamicMoodEnum.values()).filter(x->x.type.equals(type)).findFirst().orElse(SCHOOL);
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
