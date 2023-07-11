package com.demo.confenalco.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
     @GetMapping("/saludos")
     public String saludo(){
        return "saludo";
     }


     @GetMapping("/saludos/{nombre}")
     public String saludo1(@PathVariable String nombre){
        return "saludo:"+nombre;
     }

     

}


