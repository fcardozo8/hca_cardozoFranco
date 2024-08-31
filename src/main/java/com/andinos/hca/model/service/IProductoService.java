package com.andinos.hca.model.service;

import com.andinos.hca.model.entity.Categoria;
import com.andinos.hca.model.entity.Producto;
import com.andinos.hca.model.entity.Usuario;
import com.andinos.hca.model.exceptions.ProductoNotFoundException;

import java.util.List;
import java.util.Set;

public interface IProductoService {
    public List<Producto> findAll();

    public Producto save(Producto producto);

    public Producto findById(Long id) throws ProductoNotFoundException;

    public void delete(Long id);

    public Set<Producto> buscarPorNombre(String parteNombre);

    public Set<Producto> filtrarPorCategoria(Categoria categoria);
}
