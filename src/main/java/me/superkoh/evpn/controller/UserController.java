package me.superkoh.evpn.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import me.superkoh.evpn.controller.base.EmptyResponse;
import me.superkoh.evpn.controller.entity.VipUserInfoResponse;
import me.superkoh.evpn.exception.IllegalRequestParamException;
import me.superkoh.evpn.service.UserService;
import me.superkoh.evpn.service.entity.VipUserWithToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by KOH on 16/5/17.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("短信发送用户登录验证码")
    @RequestMapping(path = "/user/send-login-mcode.php", method = RequestMethod.POST, produces = {MediaType
            .APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.ALL_VALUE})
    public EmptyResponse sendMobileCode(@ApiParam(value = "手机号", required = true) @RequestParam String mobile,
                                        @ApiParam(value = "图片验证码", required = true) @RequestParam String captcha,
                                        HttpServletRequest request) throws IOException {
        if (mobile.isEmpty()) {
            throw new IllegalRequestParamException("mobile");
        }
        if (captcha.isEmpty()) {
            throw new IllegalRequestParamException("captcha");
        }
        userService.sendLoginMobileCode(mobile, captcha, (String) request.getAttribute("vd"));
        return new EmptyResponse();
    }

    @ApiOperation("语音发送用户登录验证码")
    @RequestMapping(path = "/user/send-login-pcode.php", method = RequestMethod.POST, produces = {MediaType
            .APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.ALL_VALUE})
    public EmptyResponse sendVoiceCode(@ApiParam(value = "手机号", required = true) @RequestParam String mobile) throws
            IOException {
        if (mobile.isEmpty()) {
            throw new IllegalRequestParamException("mobile");
        }
        userService.sendLoginVoiceCode(mobile);
        return new EmptyResponse();
    }

    @ApiOperation("用户登录")
    @RequestMapping(path = "/user/login.php", method = RequestMethod.POST, produces = {MediaType
            .APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.ALL_VALUE})
    public VipUserInfoResponse loginWithMobile(@ApiParam(value = "手机号", required = true) @RequestParam String mobile,
                                               @ApiParam(value = "验证码", required = true) @RequestParam String code,
                                               HttpServletRequest request) throws Exception {
        if (mobile.isEmpty()) {
            throw new IllegalRequestParamException("mobile");
        }
        if (code.isEmpty()) {
            throw new IllegalRequestParamException("code");
        }
        String vd = (String) request.getAttribute("vd");
        VipUserWithToken userWithToken = userService.loginWithMobile(mobile, code, vd);
        return new VipUserInfoResponse(userWithToken);
    }

}
