package co.edu.uniquindio.dto;

import co.edu.uniquindio.model.Employee;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ResponseDTO {
    private String message;
    private Employee employee;
}
