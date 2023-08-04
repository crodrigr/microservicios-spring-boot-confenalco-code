package com.comfenalco.microservicios.items.services;

import java.util.List;

import com.comfenalco.microservicios.items.models.Item;
import com.comfenalco.microservicios.commons.producto.models.entities.Producto;

public interface ItemService {

    public List<Item> findAll();
    
    public Item findyById(Long id, Integer cantidad);

    public Producto save(Producto producto);

    public Producto update(Producto producto, Long id);

    public void delete(Long id);
    
}
