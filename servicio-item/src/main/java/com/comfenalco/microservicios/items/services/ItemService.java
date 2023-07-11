package com.comfenalco.microservicios.items.services;

import java.util.List;

import com.comfenalco.microservicios.items.models.Item;

public interface ItemService {

    public List<Item> findAll();
    
    public Item findyById(Long id, Integer cantidad);
    
}
