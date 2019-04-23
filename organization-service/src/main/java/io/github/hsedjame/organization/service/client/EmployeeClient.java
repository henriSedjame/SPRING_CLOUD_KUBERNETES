package io.github.hsedjame.organization.service.client;

import io.github.hsedjame.organization.service.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@FeignClient(name = "employee")
public interface EmployeeClient {
    @GetMapping("/organization/{organizationId}")
    List<Employee> findByOrganization(@PathVariable("organizationId") String organizationId);
}
