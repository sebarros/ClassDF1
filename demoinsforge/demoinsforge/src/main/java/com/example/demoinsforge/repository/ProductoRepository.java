package com.example.demoinsforge.repository;
import com.example.demoinsforge.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Select * from ... activos
    List<Producto> findByEstado(boolean estado);
    List<Producto> findByNombre(String nombre);
}
