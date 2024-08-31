package com.andinos.hca.model.dao;

import com.andinos.hca.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IProductoDAO extends JpaRepository<Producto, Long> {
    Set<Producto> findByNombre(String parteNombre);

    Set<Producto> findByCategoria(Categoria categoria);

//    void addItem(Long idProducto, Usuario Usuario);
}
