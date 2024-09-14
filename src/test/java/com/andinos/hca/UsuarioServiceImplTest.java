package com.andinos.hca;

import com.andinos.hca.model.dao.ICarritoDAO;
import com.andinos.hca.model.dao.IUsuarioDAO;
import com.andinos.hca.model.entity.Usuario;
import com.andinos.hca.model.service.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

public class UsuarioServiceImplTest {

    @Mock
    private IUsuarioDAO usuarioDao;

    @Mock
    private ICarritoDAO carritoDao;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario());
        when(usuarioDao.findAll()).thenReturn(usuarios);


        List<Usuario> result = (List<Usuario>) usuarioService.findAll();


        assertNotNull(result);
        assertEquals(1, result.size());
        verify(usuarioDao, times(1)).findAll();
    }

    @Test
    public void testFindOne() {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);

        when(usuarioDao.findById(id)).thenReturn(Optional.of(usuario));

        Usuario result = usuarioService.findOne(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
        verify(usuarioDao, times(1)).findById(id);
    }

    @Test
    public void testSave() {
        Usuario usuario = new Usuario();
        when(usuarioDao.save(usuario)).thenReturn(usuario);

        Usuario result = usuarioService.save(usuario);

        assertNotNull(result);
        verify(usuarioDao, times(1)).save(usuario);
    }

    @Test
    public void testDeleteById() {
        Long id = 1L;


        usuarioService.deleteById(id);


        verify(usuarioDao, times(1)).deleteById(id);
    }
}
