package com.andinos.hca.model.service;

import com.andinos.hca.model.entity.Carrito;

import java.util.List;

public interface ICarritoService {
    public List<Carrito> findAll();

    public Carrito save(Carrito carrito);

    Carrito findCarrito(Long id);

    public boolean delete(Long id);


//    public void update(Carrito carrito);
}
