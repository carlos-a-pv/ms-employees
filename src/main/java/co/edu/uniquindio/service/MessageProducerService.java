package co.edu.uniquindio.service;


import co.edu.uniquindio.config.RabbitMQConfig;
import co.edu.uniquindio.dto.MessageNotificationDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService implements IMessageProducerService {

    private final RabbitTemplate rabbitTemplate;

    public MessageProducerService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void sendMessage(MessageNotificationDTO message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.ONBOARDING_EXCHANGE, "",message);
    }
}
