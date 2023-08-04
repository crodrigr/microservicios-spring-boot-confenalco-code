package com.demo.confenalco.demo.services;

import java.util.List;

import com.comfenalco.microservicios.commons.producto.models.entities.Producto;



public interface ProductoService {

    public List<Producto> findAll();

    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void delete(Long id);
   
}
