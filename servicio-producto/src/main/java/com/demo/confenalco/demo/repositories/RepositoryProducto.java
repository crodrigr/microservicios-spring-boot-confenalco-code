package com.demo.confenalco.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.comfenalco.microservicios.commons.producto.models.entities.Producto;


public interface RepositoryProducto extends CrudRepository<Producto,Long>{
    
}
