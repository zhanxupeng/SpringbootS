package com.mybatis.test.common.login;

import com.mybatis.test.common.base.IdGen;
import com.mybatis.test.common.exception.ServiceException;

import java.util.HashMap;
import java.util.Map;

public class AdminCache {
    private static Map<String, String> map = new HashMap<>();

    public static String getIdentify(String id) {
        String uuid = IdGen.uuid();
        map.put(uuid, id);
        return uuid;
    }

    public static String getId(String identify) {
        String id = map.get(identify);
        if (id == null) {
            throw new ServiceException(ServiceException.Info.ILLEGAL_PARAM);
        }
        return id;
    }

    public static void checkAdmin(String identify) {
        String id = map.get(identify);
        if (id == null) {
            throw new ServiceException(ServiceException.Info.ILLEGAL_PARAM);
        }
    }
}
