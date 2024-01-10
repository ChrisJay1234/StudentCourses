package com.example.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //获取URL请求
        String url = req.getRequestURL().toString();
        log.info("请求的URL：{}",url);
        //判断URL是否包含login
        if (url.contains("login")){
            log.info("登陆操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取请求头中的token
        String jwt = req.getHeader("Token");

        //判断token是否存在
        if (!StringUtils.hasLength(jwt)){
            log.info("token不存在");
            Result error = Result.error("NOT_LOGIN");
            //转Json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //解析token，失败返回错误结果
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析token失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //转Json
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        //放行操作
        log.info("放行");
        filterChain.doFilter(servletRequest,servletResponse);

    }
}
