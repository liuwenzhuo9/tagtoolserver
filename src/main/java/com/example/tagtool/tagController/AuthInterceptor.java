package com.example.tagtool.tagController;

import com.example.tagtool.tagEntity.Account;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AuthInterceptor implements HandlerInterceptor {
    private MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AuthController auth = method.getAnnotation(AuthController.class);
        if (auth == null) {
            return true;
        } else {
            if (auth.value().equals(AuthLevel.ALL)) {
                return true;
            } else {
                HttpSession session = request.getSession(false);
                if (session == null) {
                    response.sendRedirect("/unlogin");
                    return false;
                } else {
                    Account user = (Account) session.getAttribute("account");
                    if(user == null) {
                        response.sendRedirect("/unlogin");
                        return false;
                    }
                    String userRole = user.getRole();
                    int userRoleID;
                    if(userRole.equals("管理员")){
                        userRoleID = 0;
                    }else if (userRole.equals("实验室用户")){
                        userRoleID = 1;
                    }else{
                        response.sendRedirect("/unlogin");
                        return false;
                    }
                    List<Integer> allowedRoles = new ArrayList<>();
                    for(int role : auth.roles()) {
                        allowedRoles.add(role);
                    }
                    if(allowedRoles.contains(userRoleID)) {
                        return true;
                    }else {
                        response.sendRedirect("/authDenied");
                        return false;
                    }
                }
            }
        }
    }
    //    private void forbidden(HttpServletRequest request, HttpServletResponse response) throws Exception {
////        response.addHeader("Access-Control-Allow-Origin", "*");
//        jsonView.setUpdateContentLength(true);
//        ResponseBean responseBean = new ResponseBean();
//        responseBean.setData(0);
//        responseBean.setMessage("未登录");
//        jsonView.render(null, request, response);
//    }
//    private void accessDenied(HttpServletRequest request, HttpServletResponse response) throws Exception {
////        response.addHeader("Access-Control-Allow-Origin", "*");
//        jsonView.setUpdateContentLength(true);
//        jsonView.render(null, request, response);
//    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
