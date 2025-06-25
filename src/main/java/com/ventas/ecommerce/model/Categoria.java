package com.ventas.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCategoria;
    private String ordenCategoria;

    @ManyToOne
    private Usuario usuario;

    @OneToMany (mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(Integer id, String nombreCategoria, String ordenCategoria, Usuario usuario, List<Producto> productos) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        this.ordenCategoria = ordenCategoria;
        this.usuario = usuario;
        this.productos = productos;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombreCategoria() {
            return nombreCategoria;
        }

        public void setNombreCategoria(String nombreCategoria) {
            this.nombreCategoria = nombreCategoria;
        }

    public String getOrdenCategoria() {
        return ordenCategoria;
    }

    public void setOrdenCategoria(String ordenCategoria) {
        this.ordenCategoria = ordenCategoria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", ordenCategoria='" + ordenCategoria + '\'' +
                ", usuario=" + usuario +
                ", productos=" + productos +
                '}';
    }
}
