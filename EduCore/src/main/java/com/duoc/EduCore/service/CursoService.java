package com.duoc.EduCore.service;
import com.duoc.EduCore.model.Curso;
import com.duoc.EduCore.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    // GET CURSOS DESDE LIST
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    // Buscar por id
    public Curso buscarPorId(Integer id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    // Guardar CURSOS EN LIST
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Curso curso){
        return cursoRepository.save(curso);
    }

    // Existe curso
    public boolean existePorId(Integer id) {
        return cursoRepository.existsById(id);
    }

    // Eliminar curso
    public void eliminarCurso(Integer id) {
        cursoRepository.deleteById(id);
    }
}
