package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.service.EmailSenderService;
import com.spring.security.demo.app.service.ForgotPasswordService;
import com.spring.security.demo.app.service.UserService;
import com.spring.security.demo.app.web.dto.PasswordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;
import java.util.Locale;
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
    public String sendForgotPasswordEmail(HttpServletRequest request, ModelMap modelMap){

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
            modelMap.put("successMessageHeader","Verification Email");
            modelMap.put("successMessageBody","Please check your email. We sent you a message with password reset link.");
            return "success-page";
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
            PasswordDto passwordDto = new PasswordDto();
            passwordDto.setToken(token);
            model.addAttribute("passwordDto", passwordDto);

            return "update-password-form";
        }
    }

    @PostMapping("/changePassword")
    public String saveNewPassword(@Valid @ModelAttribute("passwordDto") PasswordDto passwordDto, BindingResult result,
                                  ModelMap modelMap){

        if(result.hasErrors()){
            return "update-password-form";
        }

        User user = userService.getUserByToken(passwordDto.getToken());
        if(user != null){
            userService.changeUserPassword(user, passwordDto.getPassword());
            modelMap.put("successMessageHeader", "Password changed successfully!");
            modelMap.put("successMessageBody", "Your new password has been saved succesfully. Click button below to go login page.");
            return "success-page";
        }
        else {
            return "redirect:/show-login-page";
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
