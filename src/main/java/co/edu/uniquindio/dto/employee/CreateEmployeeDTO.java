package co.edu.uniquindio.dto.employee;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CreateEmployeeDTO {
    private String name;
    private String position;
}
