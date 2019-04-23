package io.github.hsedjame.organization.service.controller;

import io.github.hsedjame.organization.service.client.DepartmentClient;
import io.github.hsedjame.organization.service.client.EmployeeClient;
import io.github.hsedjame.organization.service.model.Organization;
import io.github.hsedjame.organization.service.repository.OrganizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@RestController
@Slf4j
public class OrganizationController {

    @Autowired
    OrganizationRepository repository;
    @Autowired
    DepartmentClient departmentClient;
    @Autowired
    EmployeeClient employeeClient;

    @PostMapping
    public Organization add(@RequestBody Organization organization) {
        log.info("Organization add: {}", organization);
        return repository.save(organization);
    }

    @GetMapping
    public Iterable<Organization> findAll() {
        log.info("Organization find");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        return repository.findById(id).get();
    }

    @GetMapping("/{id}/with-departments")
    public Organization findByIdWithDepartments(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        if (organization.isPresent()) {
            Organization o = organization.get();
            o.setDepartments(departmentClient.findByOrganization(o.getId()));
            return o;
        } else {
            return null;
        }
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        if (organization.isPresent()) {
            Organization o = organization.get();
            o.setDepartments(departmentClient.findByOrganizationWithEmployees(o.getId()));
            return o;
        } else {
            return null;
        }
    }

    @GetMapping("/{id}/with-employees")
    public Organization findByIdWithEmployees(@PathVariable("id") String id) {
        log.info("Organization find: id={}", id);
        Optional<Organization> organization = repository.findById(id);
        if (organization.isPresent()) {
            Organization o = organization.get();
            o.setEmployees(employeeClient.findByOrganization(o.getId()));
            return o;
        } else {
            return null;
        }
    }
}
