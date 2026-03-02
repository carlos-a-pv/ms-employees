package co.edu.uniquindio.service.implementatation;

import co.edu.uniquindio.dto.ResponseDTO;
import co.edu.uniquindio.dto.department.DepartmentDTO;
import co.edu.uniquindio.exception.DepartmentNotFoundException;
import co.edu.uniquindio.service.interfaces.IDepartmentService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class DepartmentService implements IDepartmentService {
    @Override
    public ResponseDTO getDepartmentById(Long id) {
        HttpResponse<String> response = null;
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8081/api/departments/"+id))
                .timeout(Duration.ofMinutes(1))
                .GET()
                .build();

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e ){
            e.printStackTrace();
        }

        assert response != null;
        if(response.statusCode() != 200){
            throw new DepartmentNotFoundException(id, "api/employees");
        }else{
            return ResponseDTO.builder()
                    .statusCode(response.statusCode())
                    .body(response.body())
                    .build();
        }
    }
}
