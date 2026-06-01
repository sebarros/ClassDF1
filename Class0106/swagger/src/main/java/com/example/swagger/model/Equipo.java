package com.example.swagger.model;
import io.swagger.v3.oas.annotations.media.Schema;

//-------1-acá comienza con el schema general del modelo
@Schema(
        name = "Equipo",
        description = "Representa un activo tecnologico registrado en la empresa"
)


public class Equipo {
  //------2-acá comienza con el id
    @Schema(
            title = "Identificador unico para cada equipo",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            title = "Nombre del equipo",
            description = "Nombre comercial del dispositivo",
            example = "Notebook Lenovo Thinkpad"
    )
    private String nombre;

    @Schema(
            description = "Marca del fabricante",
            example = "Lenovo",
            allowableValues = {"Lenovo", "HP", "Mac", "Dell", "Asus"}
    )
    private String marca;

    @Schema(
            description = "Numero de serie del producto",
            example = "LEN-2025-0001",
            minLength = 5,
            maxLength = 30
    )
    private String serie;

    @Schema(
            description = "Precio del equipo",
            example = "890000000.0",
            minimum = "0"
    )
    private Double precio;

    @Schema(
            description = "Año de compra",
            example = "2026"
    )
    private Integer anioCompra;

    @Schema(
            description = "Indica si el equipo esta operativo o no",
            example = "true",
            defaultValue = "true"
    )
    private Boolean activo;

    public Equipo() {
    }

    public Equipo(Long id,
                  String nombre,
                  String marca,
                  String serie,
                  Double precio,
                  Integer anioCompra,
                  Boolean activo) {

        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.serie = serie;
        this.precio = precio;
        this.anioCompra = anioCompra;
        this.activo = activo;
    }

    // Getters y Setters

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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAnioCompra() {
        return anioCompra;
    }

    public void setAnioCompra(Integer anioCompra) {
        this.anioCompra = anioCompra;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
