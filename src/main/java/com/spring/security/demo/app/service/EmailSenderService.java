package com.spring.security.demo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendMail(String toEmail, String hashcode) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("socialnetworkalternative@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText("Click this verification link to activate your account : "+" http://spring-boot-todo-demo.herokuapp.com/register/activate-account?key1="+toEmail+"&key2="+hashcode);
        mimeMessageHelper.setSubject("Congratulations! You registered succesfully.");

        mailSender.send(mimeMessage);

        System.out.println("Email sent...");
    }
}
