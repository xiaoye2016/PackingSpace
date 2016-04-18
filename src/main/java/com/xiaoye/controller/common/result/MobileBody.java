package com.xiaoye.controller.common.result;

/**
 * Created by 郭彦君 on 2016/4/13.
 */
public class MobileBody<T> {
    private T userInfo;

    public T getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(T userInfo) {
        this.userInfo = userInfo;
    }
}
