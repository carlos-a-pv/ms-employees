package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.CreateEmployeeDTO;
import co.edu.uniquindio.dto.DepartmentDTO;
import co.edu.uniquindio.dto.EmployeeDTO;
import co.edu.uniquindio.service.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name="Employees", description = "Endpoint for management employees")
public class EmployeeController {


    private final IEmployeeService employeeService;

    public  EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping
    @Operation(
            summary = "Creating a employee",
            description = "Creating a new employee"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EmployeeDTO.class),
                    examples = @ExampleObject(name = "Created", value = "{\"id\": 1, \"name\": \"Carlos\", \"position\": \"Developer.\"}")))
    })
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody CreateEmployeeDTO createEmployeeDTO){
        EmployeeDTO employeeCreated = employeeService.createEmployee(createEmployeeDTO);
        return ResponseEntity.created(URI.create("/api/employees/" + employeeCreated.getId())).body(employeeCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> queryEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeFound);


    }
}
