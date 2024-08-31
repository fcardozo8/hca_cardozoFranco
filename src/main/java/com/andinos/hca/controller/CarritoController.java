package com.andinos.hca.controller;

import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.service.CarritoServiceImpl;
import com.andinos.hca.model.service.IItemProductoService;
import com.andinos.hca.model.service.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private IItemProductoService itemProductoService;

    @Autowired
    private CarritoServiceImpl carritoService;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public  ResponseEntity<?> getItems(@RequestParam Long idUsuario){
        Carrito carrito = carritoService.findCarrito(idUsuario);
        return new ResponseEntity<>(carrito, HttpStatus.FOUND);
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carrito> save(@RequestBody Carrito carrito){
        return new ResponseEntity<>(carritoService.save(carrito), HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{idItem}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteItem(@PathVariable("idItem") Long id) {
        itemProductoService.delete(id);
    }


}
