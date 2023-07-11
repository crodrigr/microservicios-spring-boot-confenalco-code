package com.demo.confenalco.demo.services;

import java.util.List;

import com.demo.confenalco.demo.repositories.entities.Producto;

public interface ProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void Delete(Producto producto);
   
}
