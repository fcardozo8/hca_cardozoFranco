package com.andinos.hca.controller;


import com.andinos.hca.model.entity.ItemProducto;
import com.andinos.hca.model.entity.Producto;
import com.andinos.hca.model.service.IItemProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
public class ItemProductoController {

    @Autowired
    private IItemProductoService itemProductoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ItemProducto itemProducto) {
//        Preconditions.checkNotNull(producto);
        itemProductoService.save(itemProducto);
    }

    @GetMapping
    public ResponseEntity<?> getProductos(Pageable page) {
        return new ResponseEntity<>(itemProductoService.findAll(page),
                HttpStatus.FOUND);
    }
//
//    @PostMapping
//    @ResponseStatus(HttpStatus.FOUND)
//    public void sumarCantidad(@RequestBody ItemProducto itemProducto){
//        itemProductoService.sumarMismoItem(itemProducto);
//    }
}
