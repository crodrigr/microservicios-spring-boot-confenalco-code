package com.comfenalco.microservicios.items;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigure {

    @Bean("clienteRest")
    public RestTemplate registrarRestTempleate(){
        return new RestTemplate();
    }


    
}
