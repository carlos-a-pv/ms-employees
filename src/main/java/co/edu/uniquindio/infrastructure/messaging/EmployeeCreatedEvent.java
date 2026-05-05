package co.edu.uniquindio.infrastructure.messaging;

import co.edu.uniquindio.model.Employee;
import lombok.Getter;

@Getter
public class EmployeeCreatedEvent {

    private final Employee employee;

    public EmployeeCreatedEvent(Employee employee) {
        this.employee = employee;
    }
}
