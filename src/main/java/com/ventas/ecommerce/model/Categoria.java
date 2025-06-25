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

    public Categoria(Integer id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
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

        @Override
        public String toString() {
            return "Categoria{" +
                    "id=" + id +
                    ", nombreCategoria='" + nombreCategoria + '\'' +
                    '}';
        }
    }
