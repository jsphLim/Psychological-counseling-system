package com.ly.ssm.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;


public class CommonInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger(CommonInterceptor.class);



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String requestName = request.getServletPath();
        logger.debug("拦截器启动 拦截路径为 :"+requestName);
        Object user = request.getSession().getAttribute("user");
        if(user != null){
            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/home.html";
            response.sendRedirect(baseUrl);
            return true;
        }else{
            String baseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/index.html";
            response.sendRedirect(baseUrl);
            return false;
        }
    }
}
