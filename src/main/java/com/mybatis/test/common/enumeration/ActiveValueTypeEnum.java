package com.mybatis.test.common.enumeration;

import java.util.Arrays;

public enum ActiveValueTypeEnum {
    /**
     * ＜5 5, ≥5 10, ≥15 15, ≥30 20
     */
    LESS_FIVE(5, 0, 5, "小于5天"),
    FIVE_FOURTEEN(10, 5, 15, "5到14天"),
    FIFTEEN_TWENTY_NINE(15, 15, 30, "15到29天"),
    THAN_TWENTY_NINE(30, 30, Integer.MAX_VALUE, "大于30天");
    private int value;
    private int minDay;
    private int maxDay;
    private String description;

    ActiveValueTypeEnum(int value, int minDay, int maxDay, String description) {
        this.value = value;
        this.minDay = minDay;
        this.maxDay = maxDay;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static int getValueByDay(int day) {
        return Arrays.stream(ActiveValueTypeEnum.values()).filter(x -> day >= x.minDay && day < x.maxDay).findFirst().orElse(LESS_FIVE).value;
    }
}
