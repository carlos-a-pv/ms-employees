package co.edu.uniquindio.controller;

import co.edu.uniquindio.dto.EmployeeDTO;
import co.edu.uniquindio.dto.ResponseDTO;
import co.edu.uniquindio.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeCreated = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.created(URI.create("/api/employees" + employeeCreated.getId())).body(employeeCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> queryEmployeeById(@PathVariable Long id){
        ResponseDTO employeeFound = employeeService.getEmployeeById(id);

        if (employeeFound.getEmployee() == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(employeeFound);
        }else{
            return ResponseEntity.ok(employeeFound);
        }
    }

    //@PutMapping

    //@DeleteMapping
}
