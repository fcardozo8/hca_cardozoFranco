package com.andinos.hca.model.service;

import com.andinos.hca.model.dao.IProductoDAO;
import com.andinos.hca.model.entity.Categoria;
import com.andinos.hca.model.entity.Producto;
import com.andinos.hca.model.exceptions.ProductoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoDAO productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findAll() {
        return (List<Producto>) productoDao.findAll();
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        productoDao.save(producto);
        return producto;
    }

    @Override
    @Transactional
    public Producto findById(Long id) throws ProductoNotFoundException {
        return productoDao.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoDao.deleteById(id);
    }

    @Override
    @Transactional
    public Set<Producto> buscarPorNombre(String parteNombre){
        return (Set<Producto>) productoDao.findByNombre(parteNombre);
    }

    @Override
    public Set<Producto> filtrarPorCategoria(Categoria categoria) {
        return (Set<Producto>) productoDao.findByCategoria(categoria);
    }

}
