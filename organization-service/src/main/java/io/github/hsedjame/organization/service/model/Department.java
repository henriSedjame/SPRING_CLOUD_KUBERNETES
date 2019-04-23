package io.github.hsedjame.organization.service.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@Data
@Builder
public class Department {
    private Long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
}
