package com.ventas.ecommerce.model;

public class Asesor {
    private Integer id;
    private String nombreAsesor;
    private String dniAsesor;
    private String telefonoAsesor;

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

    @Override
    public String toString() {
        return "Asesor{" +
                "id=" + id +
                ", nombreAsesor='" + nombreAsesor + '\'' +
                ", dniAsesor='" + dniAsesor + '\'' +
                ", telefonoAsesor='" + telefonoAsesor + '\'' +
                '}';
    }
}
