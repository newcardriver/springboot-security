package com.zr.security.service.impl;

import com.zr.security.config.security.user.UserDetail;
import com.zr.security.entity.LoginEntity;
import com.zr.security.exception.ServerException;
import com.zr.security.service.IAuthService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;

    @Resource
    PasswordEncoder passwordEncoder;

    @Override
    public String login(LoginEntity login) {
        System.out.println(passwordEncoder.encode(login.getPassword()));
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new ServerException("账号或密码错误");
        }
        // 拿到用户信息
        UserDetail userDetail = (UserDetail) authentication.getCredentials();
        // 生成accessToken
        String accessToken = UUID.randomUUID().toString().replace("-", "");
        //保存用户信息到缓存
        // redis.set(":"+accessToken,userDetail);
        return accessToken;
    }
}
