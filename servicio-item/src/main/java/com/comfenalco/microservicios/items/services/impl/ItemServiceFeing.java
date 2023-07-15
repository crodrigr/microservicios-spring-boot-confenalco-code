package com.comfenalco.microservicios.items.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comfenalco.microservicios.items.clientes.ProductoClienteRest;
import com.comfenalco.microservicios.items.models.Item;
import com.comfenalco.microservicios.items.services.ItemService;

@Service("serviceFeing")
public class ItemServiceFeing implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFeing;

    @Override
    public List<Item> findAll() {

       return clienteFeing.listar().stream().map(producto->new Item(producto,1)).collect(Collectors.toList());
       
       /*List<Item> items=new ArrayList<Item>();

       List<Producto> productos= clienteFeing.listar();
       for(Producto p: productos){
          items.add(new Item(p,1));
       }
       return items;*/
    }

    @Override
    public Item findyById(Long id, Integer cantidad) {
       return new Item(clienteFeing.detalle(id),cantidad);
    }

}
