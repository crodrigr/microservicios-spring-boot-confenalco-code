package com.comfenalco.microservicios.items.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.comfenalco.microservicios.items.models.Item;
import com.comfenalco.microservicios.items.services.ItemService;
import com.comfenalco.microservicios.commons.producto.models.entities.Producto;

@RefreshScope
@RestController
public class ItemController {

    private static Logger log= LoggerFactory.getLogger(ItemController.class);

    @Autowired
    @Qualifier("serviceFeing")
    private ItemService itemService;

    @Autowired
    private Environment env;

    @Value("${configuracion.texto}")
    private String texto;

 
    @Value("${configuracion.msg}")
    private String msg;

    @GetMapping("/listar")
    public List<Item> listar(){
        return itemService.findAll();
    }
    
    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad){
        return itemService.findyById(id,cantidad);
    }

    @GetMapping("/obtener-config")
    public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String port){

        log.info(texto);
        log.info("msg::::"+msg);

        Map<String,String> json= new HashMap<>();

        json.put("texto",texto);
        json.put("puerto",port);
        json.put("msg",msg);

        if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")){
            json.put("autor.nombre",env.getProperty("configuracion.autor.nombre"));
            json.put("autor.email",env.getProperty("configuracion.autor.email"));
        }

        return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);

    }
    
    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto){
        return itemService.save(producto);

    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id){
        return itemService.update(producto,id);

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable Long id){
         itemService.delete(id);

    }

}
