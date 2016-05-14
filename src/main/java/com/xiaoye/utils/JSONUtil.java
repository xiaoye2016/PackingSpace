package com.xiaoye.utils;

import net.sf.json.JSONObject;

/**
 * Created by 郭彦君 on 2016/5/14.
 */
public class JSONUtil {
    /**
     * 从一个JSON 对象字符格式中得到一个java对象
     *
     * @param jsonString
     * @param beanCalss
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        T bean = (T) JSONObject.toBean(jsonObject, beanCalss);

        return bean;

    }
}
