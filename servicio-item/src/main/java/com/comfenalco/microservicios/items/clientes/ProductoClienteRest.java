package com.comfenalco.microservicios.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comfenalco.microservicios.commons.producto.models.entities.Producto;



@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

     @GetMapping("/api/listar")
    public List<Producto> listar();
        
    
    @GetMapping("/api/ver/{id}")
    public Producto detalle(@PathVariable Long id);
       
    
}
