package co.edu.uniquindio.dto.employee;

import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String name;
    private String position;
}
