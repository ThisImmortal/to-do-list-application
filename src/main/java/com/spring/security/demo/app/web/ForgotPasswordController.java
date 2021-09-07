package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.service.EmailSenderService;
import com.spring.security.demo.app.service.ForgotPasswordService;
import com.spring.security.demo.app.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private ForgotPasswordService forgotPasswordService;

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
       String token = UUID.randomUUID().toString();
        Date currentDate = new Date();
        userService.createPasswordResetTokenForUser(user, token, currentDate);
        try {
            String baseUrl = getAppUrl(request);
            emailSenderService.send(constructResetTokenEmail(baseUrl, request.getLocale(),token, user));
            return "custom-login-page";
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return"forgot-password-form";
    }

    @GetMapping("/changePassword")
    public String showChangePasswordPage(Locale locale, Model model,
                                         @RequestParam("token") String token) {
        String result = forgotPasswordService.validatePasswordResetToken(token);
        if(result != null) {

            model.addAttribute("invalidOrExpiredToken", "Your password reset link expired or invalid token");
            return "forgot-password-expired-token";
        } else {
            model.addAttribute("token", token);
            return "update-password-form";
        }
    }

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/forgot-password/changePassword?token=" + token;

        return constructEmail("Reset Password", "Please, reset your password by clicking this link"
                + " \r\n" + url, user);
    }

    public SimpleMailMessage constructEmail(String subject, String body,
                                            User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        email.setFrom("socialnetworkalternative@gmail.com");
        return email;
    }

    public String getAppUrl(HttpServletRequest request){

        String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).
                build().toUriString();

        return baseUrl;
    }
}
