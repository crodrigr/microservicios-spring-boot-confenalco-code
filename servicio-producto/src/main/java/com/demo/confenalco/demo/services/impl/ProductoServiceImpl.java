package com.demo.confenalco.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.confenalco.demo.repositories.RepositoryProducto;
import com.demo.confenalco.demo.repositories.entities.Producto;
import com.demo.confenalco.demo.services.ProductoService;



@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private RepositoryProducto repositoryProducto;

    @Override
    @Transactional(readOnly=true)
    public List<Producto> findAll() {
       return (List<Producto>) repositoryProducto.findAll();        
    }

    @Override
    @Transactional(readOnly=true)
    public Producto findById(Long id) {
        return repositoryProducto.findById(id).orElse(null);        
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return repositoryProducto.save(producto);
    }
        
        
    @Override
    @Transactional
    public void Delete(Producto producto) {
        repositoryProducto.delete(producto);
        
    }
    
}
