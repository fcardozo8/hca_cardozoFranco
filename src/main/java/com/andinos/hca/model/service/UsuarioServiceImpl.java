package com.andinos.hca.model.service;

import com.andinos.hca.model.dao.ICarritoDAO;
import com.andinos.hca.model.dao.IUsuarioDAO;
import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioDAO usuarioDao;

    @Autowired
    private ICarritoDAO carritoDao;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Usuario> findAll() {
        return usuarioDao.findAll();
    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public Page<Usuario> findAll(Pageable pageable) {
//        return usuarioDao.findAll(pageable);
//    }

    @Override
    public Usuario findOne(Long id) {
        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuarioDao.save(usuario);
        return usuario;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        usuarioDao.deleteById(id);
    }
}
