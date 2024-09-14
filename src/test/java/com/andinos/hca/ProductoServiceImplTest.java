package com.andinos.hca;

import com.andinos.hca.model.dao.IProductoDAO;
import com.andinos.hca.model.entity.Categoria;
import com.andinos.hca.model.entity.Producto;
import com.andinos.hca.model.exceptions.ProductoNotFoundException;
import com.andinos.hca.model.service.ProductoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductoServiceImplTest {

    @Mock
    private IProductoDAO productoDao;

    @InjectMocks
    private ProductoServiceImpl productoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {

        List<Producto> productos = mock(List.class);
        when(productoDao.findAll()).thenReturn(productos);


        List<Producto> result = productoService.findAll();


        assertNotNull(result);
        verify(productoDao, times(1)).findAll();
    }

    @Test
    public void testSave() {
        Producto producto = new Producto();
        when(productoDao.save(producto)).thenReturn(producto);

        Producto result = productoService.save(producto);

        assertNotNull(result);
        verify(productoDao, times(1)).save(producto);
    }

    @Test
    public void testFindByIdFound() throws ProductoNotFoundException {
        Long id = 1L;
        Producto producto = new Producto();
        producto.setIdproducto(id);

        when(productoDao.findById(id)).thenReturn(Optional.of(producto));

        Producto result = productoService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getIdproducto());
        verify(productoDao, times(1)).findById(id);
    }

    @Test
    public void testFindByIdNotFound() {
        /*Long id = 1L;*/
        Long id = new Random().nextLong();

        when(productoDao.findById(id)).thenReturn(Optional.empty());

        assertThrows(ProductoNotFoundException.class, () -> {
            productoService.findById(id);
        });

        verify(productoDao, times(1)).findById(id);
    }

    @Test
    public void testDelete() {
        Long id = 1L;


        productoService.delete(id);


        verify(productoDao, times(1)).deleteById(id);
    }

    @Test
    public void testBuscarPorNombre() {
        String parteNombre = "Producto";
        Set<Producto> productos = new HashSet<>();
        when(productoDao.findByNombre(parteNombre)).thenReturn(productos);

        Set<Producto> result = productoService.buscarPorNombre(parteNombre);

        assertNotNull(result);
        verify(productoDao, times(1)).findByNombre(parteNombre);
    }

    @Test
    public void testFiltrarPorCategoria() {
        Categoria categoria = new Categoria();
        Set<Producto> productos = new HashSet<>();
        when(productoDao.findByCategoria(categoria)).thenReturn(productos);

        Set<Producto> result = productoService.filtrarPorCategoria(categoria);

        assertNotNull(result);
        verify(productoDao, times(1)).findByCategoria(categoria);
    }
}
