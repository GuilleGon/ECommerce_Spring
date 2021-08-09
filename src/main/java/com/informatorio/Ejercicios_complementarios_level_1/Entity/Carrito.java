package com.informatorio.Ejercicios_complementarios_level_1.Entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Date fecha_creacion;
    private boolean estado;

    @OneToOne(mappedBy = "carrito")
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Carrito_Producto",
            joinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "carrito_id", referencedColumnName = "id")
    )
    private List<Carrito> producto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
