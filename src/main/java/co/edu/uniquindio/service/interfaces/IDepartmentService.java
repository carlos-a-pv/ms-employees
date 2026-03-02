package co.edu.uniquindio.service.interfaces;

import co.edu.uniquindio.dto.ResponseDTO;
import co.edu.uniquindio.dto.department.DepartmentDTO;

public interface IDepartmentService {

    ResponseDTO getDepartmentById(Long id);
}
