package com.example.productos.controller;
import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoRepository repo;
    public ProductoController(ProductoRepository r) {
        this.repo = r;
    }

    @PostMapping
    public Producto crear(){
        return repo.save(new Producto("Teclado Gamer", 600.000));
    }

    @GetMapping("/{id}")
    public Producto get(@PathVariable long id) {
        return repo.findById(id).orElse(null);
    }
}
