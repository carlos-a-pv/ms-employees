package co.edu.uniquindio.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GlobalHandlerDTO {
    private LocalDateTime timestamp;
    private String status;
    private String error;
    private String path;

}
