package com.andinos.hca.model.service;

import com.andinos.hca.model.dao.IVentaDAO;
import com.andinos.hca.model.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaServiceImpl implements IVentaService{

    @Autowired
    private IVentaDAO ventaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Venta> findAll() {
        return (List<Venta>) ventaDao.findAll();
    }

    @Override
    @Transactional
    public void save(Venta venta) {
        ventaDao.save(venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Venta findOne(Long id) {
        return ventaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ventaDao.deleteById(id);
    }
}
