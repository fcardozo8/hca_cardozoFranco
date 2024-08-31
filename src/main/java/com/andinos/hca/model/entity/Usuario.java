package com.andinos.hca.model.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Usuario(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    private String username;

    @Email
    private String email;

    private String password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "create_time")
    private Date createTime;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Venta> ventas;
//    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Carrito> carritos;
    private String foto;

    private static final long serialVersionUID = 1L;

    public Usuario() {
        this.ventas = new ArrayList<Venta>();
    }

    @PrePersist
    public void prePersist() {
        createTime = new Date();
    }

//    @OneToMany
//    @JoinColumn(name = "idCarrito", referencedColumnName = "id")
//    private List<Carrito> carrito;
    @OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY, orphanRemoval = true)
    private Carrito carrito;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreate_time(Date createTime) {
        this.createTime = createTime;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreate_time() {
        return createTime;
    }

    public String getFoto() {
        return foto;
    }

    public Long getId() {
        return id;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void addVenta(Venta venta){
        ventas.add(venta);
    }
//    public void addCarrito(Carrito carrito){
//        carrito.add(carrito);
//    }
}
