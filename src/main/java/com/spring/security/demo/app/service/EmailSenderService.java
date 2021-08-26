package com.spring.security.demo.app.service;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.Session;
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
        mimeMessageHelper.setText("Click this verification link to activate your account : "+" http://localhost:8095/register/activate-account?key1="+toEmail+"&key2="+hashcode);
        mimeMessageHelper.setSubject("Congratulations! You registered succesfully.");

        mailSender.send(mimeMessage);

        System.out.println("Email sent...");
    }
}
