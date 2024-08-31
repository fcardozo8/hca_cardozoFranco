package com.andinos.hca.model.service;

import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface IUsuarioService {

    public Iterable<Usuario> findAll();

//    public Page<Usuario> findAll(Pageable pageable);
    public Usuario findOne(Long id);
    public Usuario save(Usuario Usuario);

    public void deleteById(Long id);
}
