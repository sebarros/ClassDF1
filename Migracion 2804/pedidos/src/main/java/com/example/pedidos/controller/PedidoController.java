package com.example.pedidos.controller;
import com.example.pedidos.model.Pedido;
import com.example.pedidos.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PedidoController {
    private final PedidoService service;
    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Pedido get(@PathVariable Long id) {
        return service.crear(id);
    }
}