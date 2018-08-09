/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.util;

import java.util.*;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *
 * @author luis.carvajal
 */
public final class Util {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        //Initialize reg ex for email.  
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.  
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static synchronized void sendEmail(String to, String from, String host,
            String subject, String text, String user, String password) {
        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", pickSMTPHost(from.toLowerCase()));
        properties.setProperty("mail.user", user);
        properties.setProperty("mail.password", password);
        //gmail port
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(text);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String pickSMTPHost(String email) {
        if (email.contains("hotmail")) {
            return "smtp.gmail.com";
        }
        if (email.contains("hotmail") || email.contains("live") || email.contains("outlook")) {
            return "smtp.live.com";
        }
        return "smtp.gmail.com";
    }
}
