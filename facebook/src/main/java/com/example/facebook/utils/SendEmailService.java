package com.example.facebook.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendEmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String toEmail, String body, String subject) {
        SimpleMailMessage message = new SimpleMailMessage();

        try {
            message.setFrom("sangaryousmane@gmail.com");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);
            log.info("Mail sent successfully!!!: ");
        } catch (MailSendException e) {
            log.error("Mail can't be sent: " + e.getMessage());
            throw new MailSendException(e.getFailedMessages());
        }
    }

    public void sendEmailWithAttachment(String toEmail, String body,
                                        String subject, String attachment) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        try {
            messageHelper.setFrom("sangaryousmane@gmail.com");
            messageHelper.setText(body);
            messageHelper.setTo(toEmail);
            messageHelper.setSubject(subject);

            FileSystemResource fileSystemResource =
                    new FileSystemResource(new File(attachment));
            messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
            mailSender.send(message);
            log.info("Attachment email sent successfully!!!");

        } catch (MailSendException m) {
            log.error("Ouch!! Email can't be sent. Please check well...." + m.getMessage());
            throw new MailSendException(m.getFailedMessages());
        }

    }
}
