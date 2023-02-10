package com.zr.security.config.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zr.security.Utils.R;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/**
 * token不存在，错误 异常处理器
 */
public class SecurityAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(R.error("未授权"));
        response.getWriter().print(result);
    }
}
