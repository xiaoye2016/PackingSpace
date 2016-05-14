package com.xiaoye.controller.login;

import com.xiaoye.controller.common.result.MobileBody;
import com.xiaoye.controller.common.result.MobileHead;
import com.xiaoye.controller.common.result.Result;
import com.xiaoye.domain.VenderUser;
import com.xiaoye.service.VenderUserService;
import com.xiaoye.utils.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by 郭彦君 on 2016/4/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private VenderUserService venderUserService;

    @RequestMapping("/test")
    public String testInterface(){
        return "testInterface";
    }
    @RequestMapping("/validTest")
    public @ResponseBody Result loginValidTest(HttpServletRequest request) throws IOException {
        VenderUser venderUser = parseRequestToVenderUser(request);
        Result result = new Result();
        MobileHead mobileHead = new MobileHead();
        mobileHead.setCode("PS-001");
        mobileHead.setMessage("校验通过");
        result.setMobileHead(mobileHead);
        MobileBody mobileBody = new MobileBody<VenderUser>();
        mobileBody.setUserInfo(venderUser);
        result.setMobileBody(mobileBody);
        return result;
    }

    private VenderUser parseRequestToVenderUser(HttpServletRequest request) throws IOException {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        return JSONUtil.jsonToBean(sb.toString(), VenderUser.class);
    }

    @RequestMapping(value = "/valid")
    public @ResponseBody Result loginValid(HttpServletRequest request)throws IOException {
        VenderUser user = parseRequestToVenderUser(request);
        Result result = new Result();
        MobileHead mobileHead = new MobileHead();
        try{
            Boolean exist = venderUserService.validVenderUserNameAndPassword(user.getAccount(), user.getPassword());
            if (!exist){
                mobileHead.setCode("PS-002");
                mobileHead.setMessage("用户名或密码错误");
                result.setMobileHead(mobileHead);
                return result;
            }

            VenderUser venderUser = venderUserService.getVenderUserByAccount(user.getAccount());
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
            }catch (Exception e){
                //todo 增加日志记录
                e.printStackTrace();
                mobileHead.setCode("PS-100");
                mobileHead.setMessage("系统异常,请联系管理员");
                result.setMobileHead(mobileHead);
                return result;
            }
        return result;
    }

    @RequestMapping("/register")
    public @ResponseBody Result register(HttpServletRequest request)throws IOException{
        VenderUser venderUser = parseRequestToVenderUser(request);
        Result result = new Result();
        MobileHead mobileHead = new MobileHead();
        try {
            //校验账号是否存在
            if (venderUserService.existAccount(venderUser.getAccount())) {
                mobileHead.setCode("PS-004");
                mobileHead.setMessage("账号已存在");
                result.setMobileHead(mobileHead);
                return result;
            }

            venderUserService.register(venderUser);
            mobileHead.setCode("PS-005");
            mobileHead.setMessage("注册成功");
            result.setMobileHead(mobileHead);
            MobileBody mobileBody = new MobileBody();
            mobileBody.setUserInfo(venderUser);
            result.setMobileBody(mobileBody);
        }catch (Exception e){
            //todo 增加日志记录
            e.printStackTrace();
            mobileHead.setCode("PS-100");
            mobileHead.setMessage("系统异常，请联系管理员");
            result.setMobileHead(mobileHead);
            return result;
        }
        return result;
    }
}
