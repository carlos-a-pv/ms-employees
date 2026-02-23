package co.edu.uniquindio.repository;

import co.edu.uniquindio.model.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    boolean existsByEmail(@NotBlank @Email String email);
}
