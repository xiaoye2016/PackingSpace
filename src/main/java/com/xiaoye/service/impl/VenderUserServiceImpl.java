package com.xiaoye.service.impl;

import com.xiaoye.dao.VenderUserDao;
import com.xiaoye.domain.VenderUser;
import com.xiaoye.service.VenderUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Created by 郭彦君 on 2016/4/17.
 */
@Service
public class VenderUserServiceImpl implements VenderUserService {
    @Resource
    private VenderUserDao venderUserDao;
    @Override
    public Boolean validVenderUserNameAndPassword(String account, String password) {
        return venderUserDao.validVenderUserNameAndPassword(account,password) > 0;
    }

    @Override
    public VenderUser getVenderUserByAccount(String account) {
        return venderUserDao.getVenderUserByAccount(account);
    }

    @Override
    public Boolean existAccount(String account) {
        return venderUserDao.existAccount(account) > 0;
    }

    @Override
    public void register(VenderUser venderUser) {
        //生成唯一编码
        venderUser.setUserId(String.valueOf(UUID.randomUUID()));
        venderUserDao.insert(venderUser);
    }
}
