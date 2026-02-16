package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.ResponseDTO;
import co.edu.uniquindio.dto.employee.CreateEmployeeDTO;
import co.edu.uniquindio.dto.employee.EmployeeDTO;
import co.edu.uniquindio.mapper.Mapper;
import co.edu.uniquindio.model.Employee;
import co.edu.uniquindio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeDTO employeeDTO) {
        Employee newEmployee = Employee.builder()
                .name(employeeDTO.getName())
                .position(employeeDTO.getPosition())
                .build();

        return Mapper.toDTO(employeeRepository.save(newEmployee));
    }

    @Override
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {

    }

    @Override
    public ResponseDTO getEmployeeById(Long id) {
        //Employee emp = employeeRepository.findById(id).orElseThrow( ()-> new NotFoundException("Empleado no econtrado en la base de datos del sistema"));
        Optional<Employee> emp = employeeRepository.findById(id);

        if(emp.isPresent()){
            return ResponseDTO.builder()
                    .message("Employee with id: "+id+" found")
                    .employee(Employee.builder()
                            .id(emp.get().getId())
                            .name(emp.get().getName())
                            .position(emp.get().getPosition())
                            .build()).build();
        }

        return ResponseDTO.builder().message("Employee not found with id: "+ id).build();
    }
}
