package com.andinos.hca.model.service;

import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.ItemProducto;
import com.andinos.hca.model.exceptions.YaExisteException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IItemProductoService {

    public Page<ItemProducto> findAll(Pageable pageable);

    public ItemProducto save(ItemProducto ItemProducto);

    public boolean delete(Long id);
    Carrito addItemProductoByUsuarioId(Long idProducto, Long idUsuario) throws YaExisteException;

    Carrito getCarritoByUsuarioId(Long IdUsuario);


//    void sumarMismoItem(ItemProducto itemProducto);
}
