package com.zr.security.config.security.filter;

import com.zr.security.config.security.user.UserDetail;
import com.zr.security.config.utils.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * 认证过滤器
 */
@Slf4j
@Configuration
public class AuthTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("进行认证");
        String accessToken = TokenUtils.getAccessToken(request);
        // 未登录
        if (StringUtils.isBlank(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        //从redis中获取到用户信息
        // redis.get(":"+accessToken) 并转换成userDetail对象,以下为模拟
        // 获取用户信息 模拟
        UserDetail userDetail = new UserDetail();
        userDetail.setUsername("1");
        userDetail.setPassword("$2a$10$Zrhw8X5mQuhl6DX.F872/e3F9IxnOujJ/I.COkv6gTD6ZJjXbYVGG");
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetail, null, null);
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);

        filterChain.doFilter(request, response);
    }
}
