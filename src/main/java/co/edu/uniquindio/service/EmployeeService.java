package co.edu.uniquindio.service;

import co.edu.uniquindio.client.DepartmentClient;
import co.edu.uniquindio.dto.CreateEmployeeDTO;
import co.edu.uniquindio.dto.DepartmentDTO;
import co.edu.uniquindio.dto.EmployeeDTO;
import co.edu.uniquindio.exception.UserEmailAlreadyExists;
import co.edu.uniquindio.exception.UserNotFoundException;
import co.edu.uniquindio.mapper.Mapper;
import co.edu.uniquindio.model.Employee;
import co.edu.uniquindio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService{
    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    public EmployeeService(EmployeeRepository employeeRepository,  DepartmentClient departmentClient) {
        this.employeeRepository = employeeRepository;
        this.departmentClient = departmentClient;
    }

    @Override
    public List<EmployeeDTO> getEmployees() {
        return List.of();
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeDTO employeeDTO) {

        DepartmentDTO departmentDTO = departmentClient.getDepartmentById(employeeDTO.getDepartmentId());

        if(employeeRepository.existsByEmail(employeeDTO.getEmail())){
            throw new UserEmailAlreadyExists(employeeDTO.getEmail(), "");
        }

        Employee newEmployee = Employee.builder()
                .name(employeeDTO.getName())
                .position(employeeDTO.getPosition())
                .email(employeeDTO.getEmail())
                .departmentId(departmentDTO.getId())
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
