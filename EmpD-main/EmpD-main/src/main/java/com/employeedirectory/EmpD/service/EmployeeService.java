package com.employeedirectory.EmpD.service;





import com.employeedirectory.EmpD.model.Employee;
import com.employeedirectory.EmpD.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getAll() { return repository.findAll(); }

    public Employee getById(Long id) { return repository.findById(id).orElse(null); }

    public List<Employee> getByDepartment(String dept) { return repository.findByDepartment(dept); }

    public Employee create(Employee emp) { return repository.save(emp); }

    public Employee update(Long id, Employee emp) {
        Employee existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(emp.getName());
            existing.setEmail(emp.getEmail());
            existing.setDepartment(emp.getDepartment());
            existing.setDesignation(emp.getDesignation());
            return repository.save(existing);
        }
        return null;
    }

    public void delete(Long id) { repository.deleteById(id); }
}
