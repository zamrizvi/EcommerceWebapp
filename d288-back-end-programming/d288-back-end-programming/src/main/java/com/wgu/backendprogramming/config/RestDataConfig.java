package com.wgu.backendprogramming.config;

import com.wgu.backendprogramming.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <h1>RestDataConfig</h1>
 * per course instructions include this code to configure the rest api end-points exposed for the project
 * TODO restrict non-used rest api end points
 * <p>
 *
 * @author WGU Course Materials
 * @version 0.1
 * @since 2023-02-27
 */
@Configuration
public class RestDataConfig implements RepositoryRestConfigurer {

    /**
     * This method exposes standard rest api end points for the following classes:
     * Country
     * Customer
     * Division
     * Excursion
     * Vacation
     * <p>
     * Set page configuration parameters
     *
     * @param config
     * @param cors
     */



    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {



        config.exposeIdsFor(Country.class);
        config.exposeIdsFor(Customer.class);
        config.exposeIdsFor(Division.class);
        config.exposeIdsFor(Excursion.class);
        config.exposeIdsFor(Vacation.class);
        config.setDefaultPageSize(Integer.MAX_VALUE);
        config.setMaxPageSize(Integer.MAX_VALUE);



    }


}

