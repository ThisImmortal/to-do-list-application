package com.spring.security.demo.app.web;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@SessionAttributes("email")
public class LoginController {


    @RequestMapping(value = "/show-login-page", method = RequestMethod.GET)
    public String showLoginPage(){


        return "custom-login-page";
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String homePage(){
//
//        return "to-do-list";
//    }


    @RequestMapping(value = "/user-logout", method = RequestMethod.GET)
    public String logoutUser(HttpServletRequest request, HttpServletResponse response){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }

        return "custom-login-page";
    }


}
