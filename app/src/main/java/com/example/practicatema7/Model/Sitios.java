package com.example.practicatema7.Model;

public class Sitios
{
    private Long id;
    private String nombre;
    private String comentarios;
    private Integer categoria;
    private Float valoracion;
    private Float longitud;
    private Float latitud;

    public Sitios() {
        this.id = null;
        this.nombre = "";
        this.comentarios="";
        this.categoria=0;
        this.valoracion=null;
        this.longitud = null;
        this.latitud = null;

    }

    public Sitios(String nombre, String comentarios, Integer categoria, Float valoracion, Float longitud, Float latitud) {
        this.id = null;
        this.nombre = nombre;
        this.comentarios=comentarios;
        this.categoria=categoria;
        this.valoracion=valoracion;
        this.longitud=longitud;
        this.latitud=latitud;
    }

    public Sitios(Long id, String nombre, String comentarios, Integer categoria, Float valoracion, Float longitud,  Float latitud) {
        this.id = id;
        this.nombre = nombre;
        this.comentarios=comentarios;
        this.categoria=categoria;
        this.valoracion=valoracion;
        this.longitud=longitud;
        this.latitud=latitud;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComentarios() {
        return comentarios;
    }
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public Integer getCategoria() {
        return categoria;
    }
    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }
    public Float getValoracion() {
        return valoracion;
    }
    public void setValoracion(Float valoracion) {
        this.valoracion = valoracion;
    }
    public Float getLongitud() {
        return longitud;
    }
    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }
    public Float getLatitud() {
        return latitud;
    }
    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }
    @Override
    public String toString() {
        return "Producto {" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", comentarios=" + comentarios +
                ", categoria=" + categoria+
                ", valoracio=" + valoracion+
                ", longitud=" + longitud+
                ", latitud='" + latitud+ '\'' +
                '}';
    }
}
