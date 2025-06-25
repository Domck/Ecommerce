package com.ventas.ecommerce.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "asesores")
public class Asesor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreAsesor;
    private String dniAsesor;
    private String telefonoAsesor;

    @OneToMany (mappedBy = "asesor")
    private List<DetalleOrden> detalleOrdenes;


    public Asesor() {
    }

    public Asesor(Integer id, String nombreAsesor, String dniAsesor, String telefonoAsesor) {
        this.id = id;
        this.nombreAsesor = nombreAsesor;
        this.dniAsesor = dniAsesor;
        this.telefonoAsesor = telefonoAsesor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreAsesor() {
        return nombreAsesor;
    }

    public void setNombreAsesor(String nombreAsesor) {
        this.nombreAsesor = nombreAsesor;
    }

    public String getDniAsesor() {
        return dniAsesor;
    }

    public void setDniAsesor(String dniAsesor) {
        this.dniAsesor = dniAsesor;
    }

    public String getTelefonoAsesor() {
        return telefonoAsesor;
    }

    public void setTelefonoAsesor(String telefonoAsesor) {
        this.telefonoAsesor = telefonoAsesor;
    }

    public List<DetalleOrden> getDetalleOrdenes() {
        return detalleOrdenes;
    }

    public void setDetalleOrdenes(List<DetalleOrden> detalleOrdenes) {
        this.detalleOrdenes = detalleOrdenes;
    }

    @Override
    public String toString() {
        return "Asesor{" +
                "id=" + id +
                ", nombreAsesor='" + nombreAsesor + '\'' +
                ", dniAsesor='" + dniAsesor + '\'' +
                ", telefonoAsesor='" + telefonoAsesor + '\'' +
                ", detalleOrdenes=" + detalleOrdenes +
                '}';
    }
}
