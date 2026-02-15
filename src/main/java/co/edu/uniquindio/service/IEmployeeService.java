package co.edu.uniquindio.service;

import co.edu.uniquindio.dto.EmployeeDTO;
import co.edu.uniquindio.dto.ResponseDTO;

import java.util.List;

public interface IEmployeeService {

    List<EmployeeDTO> getEmployees();

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);

    ResponseDTO getEmployeeById(Long id);

}
