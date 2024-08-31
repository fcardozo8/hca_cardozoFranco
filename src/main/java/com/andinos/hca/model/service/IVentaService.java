package com.andinos.hca.model.service;

import com.andinos.hca.model.entity.Venta;

import java.util.List;

public interface IVentaService {
    public List<Venta> findAll();

    public void save(Venta venta);

    public Venta findOne(Long id);

    public void delete(Long id);
}
