package org.ms.email.Service;

import jakarta.transaction.Transactional;
import org.ms.email.Models.EmailModel;
import org.ms.email.Repository.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    final EmailRepository emailRepository;
    final JavaMailSender javaMailSender;

    public EmailService(EmailRepository emailRepository, JavaMailSender javaMailSender) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        try {

            emailModel.setSendDateEmail(LocalDateTime.now());
            emailModel.setStatusEmail(EmailModel.StatusEmail.SENT);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            javaMailSender.send(message);
            emailModel.setStatusEmail(EmailModel.StatusEmail.SENT);
        }
        catch (Exception e) {
            emailModel.setStatusEmail(EmailModel.StatusEmail.ERROR);
        }
        return emailRepository.save(emailModel);
    }
}
