package com.xiaoye.controller.login;

import com.xiaoye.controller.common.result.MobileBody;
import com.xiaoye.controller.common.result.MobileHead;
import com.xiaoye.controller.common.result.Result;
import com.xiaoye.domain.VenderUser;
import com.xiaoye.service.VenderUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by 郭彦君 on 2016/4/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private VenderUserService venderUserService;

    @RequestMapping(value = "/valid",method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody Result loginValid(@RequestParam(value = "account",required = true)String account , @RequestParam(value = "password",required = true)String password){
        Boolean exist = venderUserService.validVenderUserNameAndPassword(account, password);
        Result result = new Result();
        MobileHead mobileHead = new MobileHead();
        if (!exist){
            mobileHead.setCode("PS-002");
            mobileHead.setMessage("用户名或密码错误");
            result.setMobileHead(mobileHead);
            return result;
        }

        VenderUser venderUser = venderUserService.getVenderUserByAccount(account);
        if (venderUser == null){
            mobileHead.setCode("PS-003");
            mobileHead.setMessage("账号不存在");
            result.setMobileHead(mobileHead);
            return result;
        }

        mobileHead.setCode("PS-001");
        mobileHead.setMessage("校验通过");
        result.setMobileHead(mobileHead);
        MobileBody mobileBody = new MobileBody<VenderUser>();
        mobileBody.setUserInfo(venderUser);
        result.setMobileBody(mobileBody);
        return result;
    }
}
