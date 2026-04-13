package com.example.demoinsforge.service;
import com.example.demoinsforge.model.Producto;
import com.example.demoinsforge.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    // REPO
    private final ProductoRepository productoRepository;

    // Constructor para poder consumir el repo
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Get
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    // Post
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    // Obtener todos los activos
    public List<Producto> listarActivos() {
        return productoRepository.findByEstado(true);
    }

    // Buscar por nombre
    public List<Producto> buscarPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
