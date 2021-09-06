package com.spring.security.demo.app.web;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.service.EmailSenderService;
import com.spring.security.demo.app.service.UserService;
import com.spring.security.demo.app.web.dto.UserRegistrationDto;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    @InitBinder
    protected void initBinder(WebDataBinder initBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        initBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto(){
        return new UserRegistrationDto();
    }

    @GetMapping
    public String registerPage(Model model){

       model.addAttribute("user", new UserRegistrationDto());

        return "new-register-form";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
                                      BindingResult result, ModelMap modelMap){

        if (result.hasErrors()){
            return "new-register-form";
        }

        User user = userService.getUserByEmail(userRegistrationDto.getEmail());
        if(user != null){
            modelMap.put("emailIsNotValidErrorMessage", "Such email has already registered");
            return "new-register-form";
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


        return "register-success-page";
    }

    @GetMapping("/activate-account")
    public String activateAccount(HttpServletRequest request) {

        String email = request.getParameter("key1");
        String hashcode = request.getParameter("key2");
        userService.activateAccount(email, hashcode);


        return "redirect:/show-login-page";
    }



}
