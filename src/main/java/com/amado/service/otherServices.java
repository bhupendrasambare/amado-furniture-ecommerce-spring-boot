package com.amado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class otherServices {
    @Autowired
    JavaMailSender mail;

    public void sendEmail(String to,String subject,String message){
        SimpleMailMessage m = new SimpleMailMessage();
        m.setFrom("bhupendrasamips1924@gmail.com");
        m.setText(message);
        m.setSubject(subject);
        m.setTo(to);
        mail.send(m);
    }

    public String getDate(){
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
