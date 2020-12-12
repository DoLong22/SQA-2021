package spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    Page<Employee> findAll(Pageable pageable);

    Employee findByIdEmployee(String idNhanvien);
}