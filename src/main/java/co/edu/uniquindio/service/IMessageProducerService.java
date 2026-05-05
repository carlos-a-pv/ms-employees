package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.EmployeeCreatedEventDTO;
import co.edu.uniquindio.dto.EmployeeDeletedEventDTO;
import co.edu.uniquindio.dto.MessageNotificationDTO;
import co.edu.uniquindio.dto.MessageProfileDTO;

public interface IMessageProducerService {

    void sendMessage(EmployeeCreatedEventDTO message);

    void sendMessage(EmployeeDeletedEventDTO message);

    //void sendMessageProfileQueue(EmployeeCreatedEventDTO message);
}
