package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.employee.CreateEmployeeDTO;
import co.edu.uniquindio.dto.employee.EmployeeDTO;
import co.edu.uniquindio.service.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody CreateEmployeeDTO createEmployeeDTO){
        EmployeeDTO employeeCreated = employeeService.createEmployee(createEmployeeDTO);
        return ResponseEntity.created(URI.create("/api/employees/" + employeeCreated.getId())).body(employeeCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> queryEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeFound = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employeeFound);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        List<EmployeeDTO> list = employeeService.getEmployees();
        return ResponseEntity.ok(list);
    }
}
