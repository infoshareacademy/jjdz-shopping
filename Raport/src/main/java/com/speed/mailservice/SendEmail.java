package com.speed.mailservice;

import javax.ejb.Stateless;

@Stateless
public class SendEmail
{
//    private String login = "speedjava10@gmail.com";
//    private String password = "12zx3456";
//    private String sendToEmail = "damian.grabowicz@gmail.com";  // TU PODAJ ADRES ODBIORCY MAILA
//    private String sendToName = "Damian Grabowicz";  // TU PODAJ IMIE I NAZWISKO ODBIORCY
//
//    public String getSendToEmail() {
//        return sendToEmail;
//    }
//
//    public void setSendToEmail(String sendToEmail) {
//        this.sendToEmail = sendToEmail;
//    }
//
//    public String getSendToName() {
//        return sendToName;
//    }
//
//    public void setSendToName(String sendToName) {
//        this.sendToName = sendToName;
//    }
//
//    public void sendEmail() throws EmailException {
//
//        // Create the attachment
//        EmailAttachment attachment = new EmailAttachment();
//        attachment.setPath("report.txt");
//        attachment.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment.setDescription("Most Popular Products Report");
//        attachment.setName("Popular Products");
//
//        // Create the email message
//        MultiPartEmail email = new MultiPartEmail();
//        email.setHostName("smtp.gmail.com");
//        email.setSmtpPort(587);
//        email.setAuthenticator(new DefaultAuthenticator(login, password));
//        email.setStartTLSEnabled(true);
//        email.setFrom("speedjava10@gmail.com", "Shopping Report Module");
//        email.addTo(sendToEmail, sendToName);
//        email.setSubject("The most popular products report");
//        email.setMsg("The most popular products report");
//
//        // add the attachment
//        email.attach(attachment);
//
//        // send the email
//        email.send();
//    }
}


