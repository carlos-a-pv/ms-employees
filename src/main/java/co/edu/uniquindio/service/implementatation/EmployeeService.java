package co.edu.uniquindio.service.implementatation;

import co.edu.uniquindio.dto.employee.CreateEmployeeDTO;
import co.edu.uniquindio.dto.employee.EmployeeDTO;
import co.edu.uniquindio.exception.EmailAlreadyExistException;
import co.edu.uniquindio.exception.UserNotFoundException;
import co.edu.uniquindio.mapper.Mapper;
import co.edu.uniquindio.model.Employee;
import co.edu.uniquindio.repository.EmployeeRepository;
import co.edu.uniquindio.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll().stream().map(Mapper::toDTO).toList();
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeDTO employeeDTO) {

        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new EmailAlreadyExistException(employeeDTO.getEmail(), "/api/employees");
        }

        Employee newEmployee = Employee.builder()
                .name(employeeDTO.getName())
                .position(employeeDTO.getPosition())
                .email(employeeDTO.getEmail())
                .departmentId(employeeDTO.getDepartmentId())
                .hiringDate(employeeDTO.getHiringDate())
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
    public EmployeeDTO getEmployeeById(Long id) {
        Optional<Employee> emp = Optional.of(employeeRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id, "api/employees")));
        return Mapper.toDTO(emp.get());
    }
}
