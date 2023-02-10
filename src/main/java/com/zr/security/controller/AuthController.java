package com.zr.security.controller;

import com.zr.security.Utils.R;
import com.zr.security.entity.LoginEntity;
import com.zr.security.service.IAuthService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {


    @Resource
    IAuthService authService;

    @PostMapping("login")
    public R<String> login(@RequestBody LoginEntity login) {
        String accessToken = authService.login(login);
        return R.ok("登录成功", accessToken);
    }
}
