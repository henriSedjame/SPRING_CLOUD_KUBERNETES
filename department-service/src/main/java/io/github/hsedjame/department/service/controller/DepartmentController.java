package io.github.hsedjame.department.service.controller;

import io.github.hsedjame.department.service.client.EmployeeClient;
import io.github.hsedjame.department.service.model.Department;
import io.github.hsedjame.department.service.model.Employee;
import io.github.hsedjame.department.service.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentRepository repository;
    @Autowired
    EmployeeClient employeeClient;

    @GetMapping("/feign")
    public List<Employee> listRest() {
        return employeeClient.findByDepartment("1");
    }

    @PostMapping("/")
    public Department add(@RequestBody Department department) {
        log.info("Department add: {}", department);
        return repository.save(department);
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable("id") String id) {
        log.info("Department find: id={}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/")
    public Iterable<Department> findAll() {
        log.info("Department find");
        return repository.findAll();
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findByOrganization(@PathVariable("organizationId") Long organizationId) {
        log.info("Department find: organizationId={}", organizationId);
        return repository.findByOrganizationId(organizationId);
    }

    @GetMapping("/organization/{organizationId}/with-employees")
    public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {
        log.info("Department find: organizationId={}", organizationId);
        List<Department> departments = repository.findByOrganizationId(organizationId);
        departments.forEach(d -> d.setEmployees(employeeClient.findByDepartment(d.getId())));
        return departments;
    }
}
