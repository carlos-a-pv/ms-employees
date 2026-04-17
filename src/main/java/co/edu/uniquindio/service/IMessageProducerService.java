package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.MessageNotificationDTO;

public interface IMessageProducerService {

    void sendMessage(MessageNotificationDTO message);
}
