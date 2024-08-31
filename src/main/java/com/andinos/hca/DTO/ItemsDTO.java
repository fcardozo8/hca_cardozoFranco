package com.andinos.hca.DTO;

import com.andinos.hca.model.entity.Carrito;
import com.andinos.hca.model.entity.ItemProducto;
import com.andinos.hca.model.entity.Usuario;

public class ItemsDTO {

    public ItemProducto itemProducto;
    public Long idUsuario;

    public ItemsDTO(ItemProducto itemProducto, Long idUsuario) {
        this.itemProducto = itemProducto;
        this.idUsuario = idUsuario;
    }

    public ItemProducto getItemProducto() {
        return itemProducto;
    }

    public void setItemProducto(ItemProducto itemProducto) {
        this.itemProducto = itemProducto;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
