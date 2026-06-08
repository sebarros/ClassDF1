package com.example.ms_inventario.service;

import com.example.ms_inventario.exception.StockInsuficienteException;
import com.example.ms_inventario.model.Producto;
import com.example.ms_inventario.repository.ProductoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// @ExtendWith activa Mockito dentro de JUnit 5.
// Sin esta línea, los @Mock quedan en null y el test truena con NullPointerException.

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {
    // @Mock crea un "doble" del repository: NO toca la BD,
    // responde únicamente lo que le programemos con when(...).

    @Mock
    private ProductoRepository repository;

    // Inyectar datos falsos al servicio
    @InjectMocks
    private ProductoService service;

    // Test = Nombre-Que-voy-a-probar-ycuales el resultado esperado
    @Test
    @DisplayName("Descuenta stock y guarda el producto con las unidades disponibles")
    void descontarStock_cuandoHayStock_descuentaYGuarda(){
        // Crear un stock inicial = id, nombre, stock
        Producto producto = new Producto(1L,"Pizza Vegetariana", 10);

        // Simulo la busqueda y que el producto existe
        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        // Simulo el guardar el producto exitosamente
        when(repository.save(producto)).thenReturn(producto);

        // Descontar una cantidad x del stock
        Producto resultado = service.descontarStock(1L, 3);

        // Verificar que el metodo de descuento, descuente la cantidad correcta
        assertThat(resultado.getStock()).isEqualTo(7);

        // Verificar que se guarde el nuevo stock
        verify(repository).save(producto);
    }
    @Test
    @DisplayName("Probando el lanzamiento de la excepcion")
    // Crear un producto con stock insuficiente
    void descontarStock_cuandoNoAlcanza_lanzaExcepcionYNoGuarda(){
        Producto producto = new Producto(1L, "Bebida", 2);
        // Simular una busqueda exitosa
        when(repository.findById(1L)).thenReturn(Optional.of(producto));

        // Verificar que se mande el Exception
        assertThatThrownBy(() -> service.descontarStock(1L, 5))
                .isInstanceOf(StockInsuficienteException.class)
                .hasMessageContaining("Stock insuficiente");

        // Verificamos que no se guarde
        verify(repository, never()).save(producto);
    }
}
