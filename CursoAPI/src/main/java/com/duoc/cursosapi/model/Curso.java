package com.duoc.cursosapi.model;

// Arreglo: Almacenar varios elementos y tiene un tamaño fijo y es inmutable
// String[] nombre_arreglo = {"cadena1", "cadena2"};
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Coleccion: Permite guardar varios elementos y puede crecer dinamicamente
// List = son recomendables para endpoints
// List<Tipodedato String> nombre_lista = new ArrayList<>(); // esto es una lista vacia
public class Curso {
    //id del curso
    //Integer no va a ser nulo
    // @NotNull no va a permitir null
    @NotNull(message = "El id no puede venir nulo")
    private Integer id;

    // Validacion: @NotBlank = mensaje no venga en blanco
    // null, = "" o " "
    @NotBlank(message = "El nombre del curso no puede estar vacio")
    private String nombre;

    // Nombre docente
    @NotBlank(message = "El docente no puede estar vacio")
    private String docente;

    // Cantidad de horas del curso
    @NotNull
    private Integer horas;

    // Constructor vacio
    public Curso() {
    }

    // Constructor con parametros
    public Curso(Integer id, String nombre, String docente, Integer horas) {
        this.id = id;
        this.nombre = nombre;
        this.docente = docente;
        this.horas = horas;
    }

    // Getter y Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }
}
