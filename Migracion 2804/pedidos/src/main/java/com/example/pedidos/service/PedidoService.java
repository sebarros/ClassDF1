package com.example.pedidos.service;
import com.example.pedidos.dto.ProductoDTO;
import com.example.pedidos.model.Pedido;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PedidoService {
    // Aqui definimos la direccion del otro MS
    private final WebClient client = WebClient.create("http://localhost:8081");

    // Metodo que crea un pedido
    public Pedido crear(Long id) {
        // Peticion GET al MS de productos
        ProductoDTO p = client.get() //Tipo de peticion http
                .uri("/productos/"+id) //Endpoint al que se le llama
                .retrieve() //Ejecutar la llamada
                .bodyToMono(ProductoDTO.class) //Parsea de JSON a Class o un objeto
                .block(); //Detiene el flujo hasta recibir una respuesta
        return new Pedido(p.nombre, p.precio);
    }
}
