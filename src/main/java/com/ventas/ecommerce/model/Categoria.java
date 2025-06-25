package com.ventas.ecommerce.model;

public class Categoria {
private Integer id;
private String nombreCategoria;

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
