package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.ResponseDTO;
import co.edu.uniquindio.dto.employee.CreateEmployeeDTO;
import co.edu.uniquindio.dto.employee.EmployeeDTO;
import co.edu.uniquindio.exception.DepartmentNotFoundException;
import co.edu.uniquindio.service.interfaces.IDepartmentService;
import co.edu.uniquindio.service.interfaces.IEmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employees", description = "Endpoints for manage employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDepartmentService departmentService;

    @PostMapping
    @Operation(summary = "Creating a employee")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody CreateEmployeeDTO createEmployeeDTO){
        departmentService.getDepartmentById(createEmployeeDTO.getDepartmentId());

        EmployeeDTO employeeCreated = employeeService.createEmployee(createEmployeeDTO);
        return ResponseEntity.created(URI.create("/api/employees/" + employeeCreated.getId())).body(employeeCreated);
    }

    @GetMapping("/{id}")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Department found"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    @Operation(summary = "Consulting a employee")
    public ResponseEntity<EmployeeDTO> queryEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeFound);
    }

    @GetMapping
    @Operation(summary = "Consulting the employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> list = employeeService.getEmployees();
        return ResponseEntity.ok(list);
    }
}
