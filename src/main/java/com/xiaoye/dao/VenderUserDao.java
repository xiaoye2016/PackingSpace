package com.xiaoye.dao;

import com.xiaoye.dao.annotation.MyBatisDao;
import com.xiaoye.domain.VenderUser;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 郭彦君 on 2016/4/17.
 */
@MyBatisDao
public interface VenderUserDao {
    Integer validVenderUserNameAndPassword(@Param("account")String account,@Param("password")String password);

    VenderUser getVenderUserByAccount(String account);

    Integer existAccount(String account);

    void insert(VenderUser venderUser);
}
