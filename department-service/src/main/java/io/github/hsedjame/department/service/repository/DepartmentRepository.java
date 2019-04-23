package io.github.hsedjame.department.service.repository;

import io.github.hsedjame.department.service.model.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
public interface DepartmentRepository extends CrudRepository<Department, String> {

    List<Department> findByOrganizationId(Long organizationId);
}
