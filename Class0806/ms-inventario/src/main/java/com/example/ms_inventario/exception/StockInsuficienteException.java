package com.example.ms_inventario.exception;

// Excepción de dominio: se lanza cuando se pide descontar más stock del disponible.
// Extiende RuntimeException para no obligar a try/catch en cada llamada.
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String mensaje) {
        super(mensaje);
    }
}