package co.edu.uniquindio.dto;


import lombok.*;

@Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ResponseDTO {
    private int statusCode;
    private String body;
}
