package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.service.EmailSenderService;
import com.spring.security.demo.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping
    public String showForgotPasswordForm(){

        return "forgot-password-form";
    }

    @PostMapping()
    public String sendForgotPasswordEmail(HttpServletRequest request){

        String email = request.getParameter("email");
        if (email.equals("")){
            request.setAttribute("emptyEmailError", "Please, provide email!");

            return "forgot-password-form";
        }

        User user = userService.getUserByEmail(email);
        if (user == null){
            request.setAttribute("suchEmailDoesnotExist", "Such email does not registered!");

            return "forgot-password-form";
        }

        //Generating hash for password reset link
        Random random = new Random();
        random.nextInt(999999);
        String hashcode = DigestUtils.md2Hex(""+random);




        return"forgot-password-form";
    }
}
