package io.github.hsedjame.organization.service.repository;

import io.github.hsedjame.organization.service.model.Organization;
import org.springframework.data.repository.CrudRepository;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
public interface OrganizationRepository extends CrudRepository<Organization, String> {
}
