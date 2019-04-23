package io.github.hsedjame.gateway.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.stream.Collectors;

/**
 * @Project springcloudkubernetes
 * @Author Henri Joel SEDJAME
 * @Date 23/04/2019
 * @Class purposes : .......
 */
@Configuration
public class GatewayApi {

    @Autowired
    ZuulProperties zuulProperties;

    @Primary
    @Bean
    public SwaggerResourcesProvider swaggerResourcesProvider(){
        return ()-> zuulProperties.getRoutes().values()
                .stream()
                .map(route -> createResource(route.getId(), "2.0"))
                .collect(Collectors.toList());
    }

    private SwaggerResource createResource(String location, String version) {
        SwaggerResource resource = new SwaggerResource();
        resource.setName(location);
        resource.setLocation("/" + location + "/v2/api-docs");
        resource.setSwaggerVersion(version);
        return resource;
    }
}
