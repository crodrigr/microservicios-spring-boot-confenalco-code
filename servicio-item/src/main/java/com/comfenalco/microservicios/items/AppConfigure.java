package com.comfenalco.microservicios.items;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigure {

    @Bean("clienteRest")
    @LoadBalanced
    public RestTemplate registrarRestTempleate(){
        return new RestTemplate();
    }


    
}
