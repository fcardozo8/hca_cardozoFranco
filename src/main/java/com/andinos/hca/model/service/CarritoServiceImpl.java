package com.andinos.hca.model.service;


import com.andinos.hca.model.dao.ICarritoDAO;
import com.andinos.hca.model.entity.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarritoServiceImpl implements ICarritoService {

    @Autowired
    private ICarritoDAO carritoDao;


    @Override
    public List<Carrito> findAll() {
        return (List<Carrito>) carritoDao.findAll();
    }

    @Override
    @Transactional
    public Carrito save(Carrito carrito) {
        carritoDao.save(carrito);
        return carrito;
    }

    @Override
    public Carrito findCarrito(Long id) {
        return carritoDao.findCarritoByUsuarioId(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        carritoDao.deleteById(id);
        return true;
    }



}
