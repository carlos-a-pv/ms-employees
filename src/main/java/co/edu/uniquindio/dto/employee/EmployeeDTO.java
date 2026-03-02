package co.edu.uniquindio.dto.employee;

import lombok.*;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String name;
    private String position;
    private String email;
    private Long deparmentId;
    private Date hiringDate;
}
