package io.github.hsedjame.employee.service.repository;

import io.github.hsedjame.employee.service.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
public interface EmployeeRepository  extends CrudRepository<Employee, String> {

    List<Employee> findByDepartmentId(Long departmentId);
    List<Employee> findByOrganizationId(Long organizationId);
}
