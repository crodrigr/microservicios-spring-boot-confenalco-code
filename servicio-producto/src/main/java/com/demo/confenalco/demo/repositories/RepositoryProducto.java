package com.demo.confenalco.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.confenalco.demo.repositories.entities.Producto;


public interface RepositoryProducto extends CrudRepository<Producto,Long>{
    
}
