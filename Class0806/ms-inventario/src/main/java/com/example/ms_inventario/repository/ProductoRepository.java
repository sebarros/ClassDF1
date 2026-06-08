package com.example.ms_inventario.repository;


import com.example.ms_inventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

// Spring Data genera la implementación en tiempo de ejecución.
// En el test NO usamos la real: la reemplazamos por un mock.
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
