package com.comfenalco.microservicios.items.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.comfenalco.microservicios.commons.producto.models.entities.Producto;
import com.comfenalco.microservicios.items.models.Item;
import com.comfenalco.microservicios.items.services.ItemService;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

    @Autowired
    private RestTemplate clienteRest;


    @Override
    public List<Item> findAll() {
         
     List<Producto> productos=Arrays.asList(clienteRest.getForObject("http://servicio-productos/api/listar",Producto[].class));

     return productos.stream().map(p->new Item(p,1)).collect(Collectors.toList());


    }

    @Override
    public Item findyById(Long id, Integer cantidad) {
       Map<String,String> pathVariables=new HashMap<String,String>();
       pathVariables.put("id",id.toString());
       Producto producto=clienteRest.getForObject("http://servicio-productos/api/ver/{id}",Producto.class,pathVariables);
       return new Item(producto,cantidad);

    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Producto save(Producto producto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producto update(Producto producto, Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
