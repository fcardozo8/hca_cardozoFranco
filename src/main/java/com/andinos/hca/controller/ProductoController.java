package com.andinos.hca.controller;


import com.andinos.hca.DTO.ItemsDTO;
import com.andinos.hca.model.dao.ICarritoDAO;
import com.andinos.hca.model.dao.IUsuarioDAO;
import com.andinos.hca.model.entity.*;
import com.andinos.hca.model.exceptions.YaExisteException;
import com.andinos.hca.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICarritoService carritoService;

    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Autowired
    private IItemProductoService itemProductoService;

    @GetMapping
    public ResponseEntity<?> getProductos() {
        return new ResponseEntity<>(productoService.findAll(),
                HttpStatus.FOUND);
    }

    @RequestMapping(value = "busqueda/{busqueda}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductoPorNombre(@PathVariable(value = "busqueda") String busqueda) {
        return new ResponseEntity<>(productoService.buscarPorNombre(busqueda), HttpStatus.FOUND);
    }

//    @GetMapping(name = "{categoria}/")
//    public ResponseEntity<?> getProductoPorCategoria(@PathVariable(value = "categoria") Categoria categoria) {
//        return new ResponseEntity<>(productoService.filtrarPorCategoria(categoria), HttpStatus.OK);
//    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
//    public ResponseEntity<Producto> save(@RequestParam Integer idproducto, @RequestBody Integer category_id, @RequestBody String descripcion , @RequestBody Estado estado, @RequestBody Date fechaYhora, @RequestBody String imagen, @RequestBody String nombre, @RequestBody Float precio, @RequestBody Integer stock) {
//        Preconditions.checkNotNull(producto);
//        Producto producto = new Producto(idproducto, nombre, precio, estado, category_id, stock, imagen, fechaYhora, descripcion);
        return new ResponseEntity<>(productoService.save(producto), HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable("id") Long id, @RequestBody Producto producto) {
//        Preconditions.checkNotNull(producto);
//        RestPreconditions.checkNotNull(productoService.getById(producto.getIdproducto()));
        productoService.save(producto);
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        productoService.delete(id);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> aniadirProductoAlCarrito(@PathVariable("id") Long idProducto, @RequestBody Long idUsuario) {
//        Optional<Usuario> usuario = usuarioDAO.findById(idUsuario);
//        Carrito carrito = carritoService.findCarritoByUsuario(usuario.stream());
        try {
            return new ResponseEntity<>(itemProductoService.addItemProductoByUsuarioId(idProducto,  idUsuario), HttpStatus.ACCEPTED);
        } catch (YaExisteException e) {
            throw new RuntimeException(e);
        }
    }

//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> quitarProductoAlCarrito(@PathVariable Long idProducto, @RequestBody Long idCarrito, @RequestBody Integer cantidad) {
//
//        Producto producto;
//        try {
//            producto = productoService.findById(idProducto);
//        } catch (ProductoNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        Carrito carrito = carritoService.findOne(idCarrito);
//
//        ItemProducto itemProducto = new ItemProducto();
//        itemProducto.setProducto(producto);
//        itemProducto.setCarrito(carrito);
//        itemProducto.setCantidad(cantidad);
//
//        return new ResponseEntity<>(carritoService.aniadirItemProducto(itemProducto), HttpStatus.ACCEPTED);
//    }
}
