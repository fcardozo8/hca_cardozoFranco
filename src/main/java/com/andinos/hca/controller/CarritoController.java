package com.andinos.hca.controller;

import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.service.ICarritoService;
import com.andinos.hca.model.service.IItemProductoService;
import com.andinos.hca.model.service.IUsuarioService;
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
    private ICarritoService carritoService;

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> getItems(@RequestParam Long idUsuario) {
        Carrito carrito = carritoService.findCarrito(idUsuario);
        return new ResponseEntity<>(carrito, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carrito> save(@RequestBody Carrito carrito) {
        return new ResponseEntity<>(carritoService.save(carrito), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<?> deleteItem(@PathVariable("idItem") Long id) {
        itemProductoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
