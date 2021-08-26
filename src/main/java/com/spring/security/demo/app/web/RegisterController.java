package com.spring.security.demo.app.web;

import com.spring.security.demo.app.service.EmailSenderService;
import com.spring.security.demo.app.service.UserService;
import com.spring.security.demo.app.web.dto.UserRegistrationDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Random;

@Controller
@RequestMapping("/register")
public class RegisterController {


    private UserService userService;
    @Autowired
    private EmailSenderService emailSenderService;

    public RegisterController(UserService userService){
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String registerPage(Model model){

       model.addAttribute("user", new UserRegistrationDto());

        return "register-form";
    }

    @PostMapping
    public String registerUserAccount(@Valid UserRegistrationDto userRegistrationDto,
                                      BindingResult result){

        if (result.hasErrors()){
            return "register-form";
        }

        //Generating registration hashcode for email verification
        Random random = new Random();
        random.nextInt(999999);
        String hashcode = DigestUtils.md2Hex(""+random);
        userService.save(userRegistrationDto, hashcode);
        try {
            emailSenderService.sendMail(userRegistrationDto.getEmail(), hashcode);
        }
        catch (MessagingException e){
            e.printStackTrace();
        }


        return "custom-login-page";
    }

    @GetMapping("/activate-account")
    public String activateAccount(HttpServletRequest request) {

        String email = request.getParameter("key1");
        String hashcode = request.getParameter("key2");
        userService.activateAccount(email, hashcode);


        return "redirect:/show-login-page";
    }



}
