package com.example.ms_inventario.service;
import com.example.ms_inventario.exception.StockInsuficienteException;
import com.example.ms_inventario.model.Producto;
import com.example.ms_inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    // El Service depende del repository. Lo recibe por constructor:
    // así, en el test, podemos inyectarle un mock en su lugar.
    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    // Descuenta 'cantidad' unidades del producto 'id'.
    // Reglas: si el producto no existe o no hay stock suficiente, lanza excepción.
    public Producto descontarStock(Long id, int cantidad) {
        // 1. Buscamos el producto. Si no existe, no hay nada que descontar.
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new StockInsuficienteException(
                        "Producto " + id + " no existe"));

        // 2. Validamos la regla de negocio: no se puede descontar más de lo que hay.
        if (cantidad > producto.getStock()) {
            throw new StockInsuficienteException(
                    "Stock insuficiente para producto " + id +
                            ": disponible " + producto.getStock() + ", solicitado " + cantidad);
        }

        // 3. Descontamos y persistimos el cambio devolviendo el producto guardado.
        producto.setStock(producto.getStock() - cantidad);
        return repository.save(producto);
    }
}