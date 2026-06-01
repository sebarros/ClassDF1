package com.example.swagger.controller;

import com.example.swagger.model.Equipo;
import com.example.swagger.service.EquipoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")

//1-acá el tag general
@Tag(
        name = "Equipos",
        description = "Operaciones relacionadas con el inventario tecnologico"
)
public class EquipoController {

    private final EquipoService service;

    public EquipoController(EquipoService service) {
        this.service = service;
    }

    //3-Operation
    @Operation(
            summary = "Obtiene todos los equipos del inventario",
            description = "Retorna la lista completa de equipos registrados"
    )

    //4-API Responses
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Consulta exitosa"),
            @ApiResponse(responseCode = "500",
            description = "Error interno")
    })

    // 4.1  Response
    @GetMapping
    public List<Equipo> listar() {
        return service.listar();
    }

    //5-Operation
    @Operation(
            summary = "Registro de un equipo",
            description = "Permite agregar un nuevo activo al inventario"
    )

    //6-API Responses
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Equipo creado"),
            @ApiResponse(responseCode = "400",
                    description = "Datos invalidos")
    })

    // 6.1  Response
    @PostMapping
    public void guardar(@RequestBody Equipo equipo) {
        service.guardar(equipo);
    }
}