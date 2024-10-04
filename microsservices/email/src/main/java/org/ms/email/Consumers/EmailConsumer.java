package org.ms.email.Consumers;

import org.ms.email.DTO.EmailRequestDTO;
import org.ms.email.Models.EmailModel;
import org.ms.email.Service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

//This class is responsible for consuming the messages from the email queue.
//The @RabbitListener annotation is used to listen to the email queue.
//The @Payload annotation is used to receive the message from the queue.
@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "default.email")
    public void listenEmailQueue(@Payload EmailRequestDTO email){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(email, emailModel);
        emailService.sendEmail(emailModel);


    }

}
