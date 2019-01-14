package com.xx.mallserverzuul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

@EnableSwagger2Doc
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class MallServerZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallServerZuulApplication.class, args);
    }

    /**
     * 动态刷新zuul参数
     *
     * @return
     */
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

    @Component
    @Primary
    public class GatewaySwaggerResourcesProvider implements SwaggerResourcesProvider {
        private final RouteLocator routeLocator;

        public GatewaySwaggerResourcesProvider(RouteLocator routeLocator) {
            this.routeLocator = routeLocator;
        }

        @Override
        public List<SwaggerResource> get() {
            List<SwaggerResource> resources = new ArrayList<>();
            List<Route> routes = routeLocator.getRoutes();
            for (Route route : routes) {
                resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs")));
            }
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion("1.0");
            return swaggerResource;
        }
    }
}

