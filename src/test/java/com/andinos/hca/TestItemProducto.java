package com.andinos.hca;

import com.andinos.hca.model.dao.IItemProductoDAO;
import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.ItemProducto;
import com.andinos.hca.model.entity.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

public class TestItemProducto {

    private TestEntityManager entityManager;
    private IItemProductoDAO itemProductoDAO;

    @Test
    public void testAniadirUnItemProducto(){
        Producto producto = entityManager.find(Producto.class, 1);
        Carrito carrito = entityManager.find(Carrito.class, 1);

        ItemProducto itemProducto = new ItemProducto();
        itemProducto.setProducto(producto);
        itemProducto.setCarrito(carrito);
        itemProducto.setCantidad(1);

        ItemProducto guardado = itemProductoDAO.save(itemProducto);
        assertTrue(guardado.getId() > 0);
    }
}
