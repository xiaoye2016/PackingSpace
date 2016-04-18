package com.xiaoye.service.impl;

import com.xiaoye.dao.VenderUserDao;
import com.xiaoye.domain.VenderUser;
import com.xiaoye.service.VenderUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
