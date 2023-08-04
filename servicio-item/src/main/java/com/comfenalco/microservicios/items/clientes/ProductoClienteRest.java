package com.comfenalco.microservicios.items.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.comfenalco.microservicios.commons.producto.models.entities.Producto;



@FeignClient(name="servicio-productos")
public interface ProductoClienteRest {

     @GetMapping("/api/listar")
    public List<Producto> listar();
        
    
    @GetMapping("/api/ver/{id}")
    public Producto detalle(@PathVariable Long id);

    @PostMapping("/api/crear")
    public Producto crear(@RequestBody Producto producto);

    @PutMapping("/api/editar/{id}")
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id);
                  
    @DeleteMapping("/api/elminar/{id}")
    public void eliminar(Long id);

       
    
}
