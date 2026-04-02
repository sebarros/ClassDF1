package com.duoc.EduCore.controller;
import com.duoc.EduCore.model.Curso;
import com.duoc.EduCore.service.CursoService;
import jakarta.validation.Valid;
import jdk.jfr.Experimental;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {
    // Variable para usar el service
    private final CursoService cursoService;

    // Constructor
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    // Listar todos los cursos
    @GetMapping
    public ResponseEntity<?> listarCursos() {
        try {
            List<Curso> cursos = cursoService.obtenerCursos();
            return ResponseEntity.ok(cursos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar los cursos");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {
        try{
            Curso producto = cursoService.buscarPorId(id);

            if ( producto == null ) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Curso no encontrado 404");
            }
            return ResponseEntity.ok(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el curso");
        }
    }

    @PutMapping("{id}")
    public Curso actualizarCurso(@PathVariable Integer id, @RequestBody Curso curso){
        return cursoService.updateCurso(curso);
    }

    // Guardar curso
    @PostMapping
    public ResponseEntity agregarCurso(@Valid @RequestBody Curso curso) {
        try {
            if (curso.getId() == null || curso.getNombre() == null || curso.getCurso() == null || curso.getEstado() == null || curso.getNivel() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Todos los campos son obligatorios");
            }

            if (cursoService.existePorId(curso.getId())) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Ya existe un curso con ese id");
            }

            Curso nuevoCurso = cursoService.guardarCurso(curso);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevoCurso);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar el curso");
        }
    }

    // ELiminar curso
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarCurso(@PathVariable Integer id) {
        try{
            if (!cursoService.existePorId(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Curso no encontrado");
            }

            cursoService.eliminarCurso(id);
            return ResponseEntity.ok("Curso eliminado correctamente");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el curso");
        }
    }
}
