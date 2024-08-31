package com.andinos.hca.model.dao;

import com.andinos.hca.model.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IVentaDAO extends JpaRepository<Venta, Long> {
}
