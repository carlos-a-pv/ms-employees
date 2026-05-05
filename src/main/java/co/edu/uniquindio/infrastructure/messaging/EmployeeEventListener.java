package co.edu.uniquindio.infrastructure.messaging;

import co.edu.uniquindio.dto.EmployeeCreatedEventDTO;
import co.edu.uniquindio.dto.EmployeeDeletedEventDTO;
import co.edu.uniquindio.exception.EventPublisingException;
import co.edu.uniquindio.model.Employee;
import co.edu.uniquindio.service.MessageProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class EmployeeEventListener {

    private final MessageProducerService messageProducerService;
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeEventListener.class);

    public EmployeeEventListener(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleEmployeeCreated(EmployeeCreatedEventDTO event){
        try{
            messageProducerService.sendMessage(
                    EmployeeCreatedEventDTO.builder()
                            .id(event.id())
                            .name(event.name())
                            .email(event.email())
                            .departmentId(event.departmentId())
                            .hiringDate(event.hiringDate())
                            .build());
        } catch (EventPublisingException ex){
            LOGGER.error("Error enviando evento a RabbitMQ", ex);
        }
    }
}
