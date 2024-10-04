package org.thiagovb62.microsservices.Producers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.thiagovb62.microsservices.Model.DTO.EmailDTO;
import org.thiagovb62.microsservices.Model.User;

@Component
public class UserProducer {

    final  RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}") // Exchange do tipo: chave routing key
    private String routingKey;


    public void publishMessageEmail(User user){
        var emailDto = new EmailDTO();
        emailDto.setUserid(user.getId());
        emailDto.setSubject("Você foi cadastrado com sucesso");
        emailDto.setEmailTo(user.getEmail());
        emailDto.setText(user.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro em nossa plataforma.");

        rabbitTemplate.convertAndSend("",routingKey, emailDto);
    }
}
