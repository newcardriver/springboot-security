package com.zr.security.service;

import com.zr.security.entity.LoginEntity;

public interface IAuthService {
    String login(LoginEntity login);
}
