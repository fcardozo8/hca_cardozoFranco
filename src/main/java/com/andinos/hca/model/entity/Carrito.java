package com.andinos.hca.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "carrito")
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarrito", nullable = false)
    private Long id;

    @OneToMany
    private List<ItemProducto> misItemProductos = new ArrayList<>();

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + id +
                ", misItemProductos=" + misItemProductos +
                ", usuario=" + usuario +
                ", venta=" + venta +
                '}';
    }

    //    @ManyToOne
//    @JoinColumn(name = "idCarrito", insertable = false, updatable = false)
    @OneToOne
    @JoinColumn(name = "IdUsuario", referencedColumnName = "id")
    private Usuario usuario;

    public Carrito() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemProducto> getItemProductos() {
        return misItemProductos;
    }

    public void setItemProductos(List<ItemProducto> misItemProductos) {
        this.misItemProductos = misItemProductos;
    }

    public void aniadirItemProducto(ItemProducto itemProducto){
        misItemProductos.add(itemProducto);
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public Carrito setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idVenta")
    private Venta venta;



    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void addItemProducto(ItemProducto itemProducto) {
        misItemProductos.add(itemProducto);
    }
}
