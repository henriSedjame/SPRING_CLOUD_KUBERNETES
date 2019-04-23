package io.github.hsedjame.department.service.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@Data
@Builder
public class Employee {
    private Long id;
    private String name;
    private int age;
    private String position;
}
