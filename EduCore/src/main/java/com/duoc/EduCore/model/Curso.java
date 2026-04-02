package com.duoc.EduCore.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Curso {
    @Id
    @NotNull(message = "El id del curso no puede estar vacio")
    private Integer id;
    @NotBlank(message = "El nombre del curso no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El rut del curso no puede estar vacio")
    private String rut;
    @NotBlank(message = "El curso del curso no puede estar vacio")
    private String curso;
    @NotBlank(message = "El estado del curso no puede estar vacio")
    private String estado;
    private LocalDate fecha;
    @NotBlank(message = "El nivel del curso no puede estar vacio")
    private String nivel;

    public Curso() {
    }

    public Curso(Integer id, String nombre, String rut, String curso, String estado, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.curso = curso;
        this.estado = estado;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
