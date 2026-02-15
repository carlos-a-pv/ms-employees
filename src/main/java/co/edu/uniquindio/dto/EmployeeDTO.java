package co.edu.uniquindio.dto;

import lombok.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    private String nombre;
    private String cargo;
}
