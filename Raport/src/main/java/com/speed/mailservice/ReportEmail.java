package com.speed.mailservice;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

import java.util.Date;
import java.util.List;

/**
 * Created by slawekskel on 7/12/16.
 */
public class ReportEmail {


    private String attachment;
    private List<String> adresee;


    public ReportEmail() {
    }

        public void sendReport(String attachment, List<String> adresee) throws EmailException {

        MultiPartEmail email = new MultiPartEmail();

        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("reportspeedteam", "NowyMan2016"));
        email.setSSLOnConnect(true);

        email.setFrom("reportspeedteam@gmail.com");
        email.setSubject("Report");
        email.setMsg("This is a Report");


        for (String thisEmail:adresee) {

            email.addTo(thisEmail);
        }


        // Create the attachment
        EmailAttachment emailAttachment = new EmailAttachment();
        emailAttachment.setPath(attachment);
        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
        emailAttachment.setDescription("Current report");
        emailAttachment.setName("Report " + new Date() + ".txt");

        email.attach(emailAttachment);


        email.send();

    }



}
