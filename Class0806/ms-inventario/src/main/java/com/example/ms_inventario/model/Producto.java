package com.example.ms_inventario.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity marca esta clase como tabla JPA. Para el test no levantamos BD,
// pero la entidad es el dato que viaja entre el repository y el service.
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int stock; // unidades disponibles; es el campo que la lógica modifica

    // Constructor vacío: JPA lo exige para poder instanciar la entidad.
    public Producto() {
    }

    // Constructor de conveniencia: lo usamos en el test para armar datos rápido.
    public Producto(Long id, String nombre, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}