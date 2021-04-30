package com.zsl.dybkm.utils;

import cn.hutool.core.util.IdUtil;

public class IdGeneratorUtil {

    public static Long nextId(){
        return IdUtil.getSnowflake(1, 1).nextId();
    }
}
