package com.andinos.hca.model.service;

import com.andinos.hca.model.dao.ICarritoDAO;
import com.andinos.hca.model.dao.IItemProductoDAO;
import com.andinos.hca.model.dao.IProductoDAO;
import com.andinos.hca.model.dao.IUsuarioDAO;
import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.ItemProducto;
import com.andinos.hca.model.entity.Producto;
import com.andinos.hca.model.exceptions.YaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
public class ItemProductoImpl implements IItemProductoService {
    @Autowired
    private IItemProductoDAO itemProductoDAO;
    @Autowired
    private IProductoDAO productoDao;

    @Autowired
    private ICarritoDAO carritoDao;
    @Autowired
    private IUsuarioDAO usuarioDao;


    @Override
    @Transactional(readOnly = true)
    public Page<ItemProducto> findAll(Pageable pageable) {
        return itemProductoDAO.findAll(pageable);
    }


    @Override
    @Transactional
    public ItemProducto save(ItemProducto itemProducto) {
        itemProductoDAO.save(itemProducto);
        return itemProducto;
    }

    @Override
    public boolean delete(Long id) {
        itemProductoDAO.deleteById(id);
        return true;
    }

//    @Override
//    public List<Item> addCartItemsByCustomerId(String customerId, @Valid Item item) {
//    CartEntity entity = getCartByCustomerId(customerId);
//    long count = entity.getItems().stream()
//            .filter(i -> i.getProduct().getId().equals(UUID.fromString(item.getId()))).count();
//    if (count > 0) {
//        throw new GenericAlreadyExistsException(
//                String.format("Item with Id (%s) already exists. You can update it.", item.getId()));
//    }
//    entity.getItems().add(itemService.toEntity(item));
//    return itemService.toModelList(repository.save(entity).getItems());
//}
    @Override
    public Carrito addItemProductoByUsuarioId(Long idProducto, Long idUsuario) throws YaExisteException {
        Carrito carrito = getCarritoByUsuarioId(idUsuario);
        long lista = carrito.getItemProductos().stream()
                .filter(i -> i.getProducto().getIdproducto().equals(idProducto)).count();
        if (lista > 0){
            throw new YaExisteException("Ya existe el item en el carrito");
        }
        ItemProducto item = new ItemProducto();
        item.setCantidad(1);
        Producto producto = productoDao.findById(idProducto).orElseThrow();
        item.setProducto(producto);
        itemProductoDAO.save(item);
        carrito.addItemProducto(item);
        return carritoDao.save(carrito);
    }

//    public void sumarMismoItem(ItemProducto itemProducto){
////        implementar logica para sumar cantidades de productos iguales en el carrito
////        buena suerte!!
//    }

    @Override
    public Carrito getCarritoByUsuarioId(Long IdUsuario) {
        Carrito carrito = carritoDao.findCarritoByUsuarioId(IdUsuario)
                .orElse(new Carrito());
        if (Objects.isNull(carrito.getUsuario())) {
            carrito.setUsuario(usuarioDao.findById(IdUsuario)
                    .orElseThrow());
        }
        return carrito;
    }
//    public ItemProducto toEntity(ItemProducto m) {
//        ItemProducto e = new ItemProducto();
//        e.setProducto(new Producto().setIdproducto(m.getId()));
//        e.setCantidad(m.getCantidad());
//        return e;
//    }
}