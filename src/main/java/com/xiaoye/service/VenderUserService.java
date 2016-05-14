package com.xiaoye.service;

import com.xiaoye.domain.VenderUser;

/**
 * Created by 郭彦君 on 2016/4/17.
 */
public interface VenderUserService {
    Boolean validVenderUserNameAndPassword(String name,String password);

    VenderUser getVenderUserByAccount(String account);

    Boolean existAccount(String account);

    void register(VenderUser venderUser);
}
