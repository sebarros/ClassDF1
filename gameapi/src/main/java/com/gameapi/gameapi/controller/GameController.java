package com.gameapi.gameapi.controller;
import com.gameapi.gameapi.model.Game;
import com.gameapi.gameapi.service.GameService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // FUNCIONARA COMO CONTROLADOR QUE MANEJARA LAS PETICIONES
@RequestMapping("/api/v1/games")
public class GameController {
    private final GameService gameService; // VARIABLE PA USAR EL SERVICE

    // CONSTRUCTOR
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // METODO PA LISTAR TODO
    @GetMapping
    public ResponseEntity<?> listarGames(){
        try{
            List<Game> games = gameService.obtenerGames();
            return ResponseEntity.ok(games);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al listar los games");
        }
    }

    // METODO PA BUSCAR UN JUEGO POR SU ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try{
            Game game = gameService.buscarPorId(id);

            // SI NO LO ENCUENTRA DEVUELVE ERROR
            if (game == null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Game no encontrado 404");
            }
            // SI LO ENCUENTRA LO DEVUELVE
            return ResponseEntity.ok(game);
        // SI NO PASA NA TIRA ERROR TAMBIEN
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar el game");
        }
    }

    // METODO PA ACTUALIZAR UN JUEGO
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarGame(@PathVariable Integer id, @RequestBody Game game){
        try {
            // BUSCA SI EL JUEGO EXISTE ANTES QUE TODO
            if (!gameService.existePorId(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No existe un juego con esa ID");
            }
            // SI EXISTE LE ASIGNA LA MISMA ID Y GUARDA LOS DATOS CAMBIADOS
            game.setId(id);
            Game gameActualizado = gameService.actualizarGame(game);
            return ResponseEntity.ok(gameActualizado);
        // SI NO PASA NA Y PA CERRAR EL TRY, TIRA ERROR
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el juego");
        }
    }

    // METODO PA AGREGAR UN JUEGO
    @PostMapping
    public ResponseEntity<?> agregarGame(@Valid @RequestBody Game game){
        try{
            // VERIFICA QUE NO FALTEN ARGUMENTOS, EL USUARIO(POSTMAN) TIENE QUE PASARLE TODOS
            if (game.getId() == null || game.getTitulo() == null || game.getGenero() == null ||
                    game.getPlataforma() == null || game.getPrecio() == null || game.getStock() == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Todos los campos son obligatorios");
            }
            //VERIFICA SI YA EXISTE UN JUEGO CON ESE ID
            if (gameService.existePorId(game.getId())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Ya existe un game con ese ID");
            }
            // SI NO ENTRA A EL IF, GUARDA EL NUEVO JUEGO
            Game nuevoGame = gameService.guardarGame(game);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(nuevoGame);
        // SI NO PASA NADA TIRA ERROR, MAS QUE NADA PARA VALIDAR Y CERRAR EL TRY
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar el game");}
    }

    // METODO PA ELIMINAR UN JUEGO
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarGame(@PathVariable Integer id){
        try{
            // VE SI EXISTE ANTES DE ELIMINAR, SI NO EXISTE TIRA ERROR
            if (!gameService.existePorId(id)){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Game no encontrado 404");
            }
            // SI EXISTE LO ELIMINA
            gameService.eliminarGame(id);
            return ResponseEntity.ok("Game eliminado correctamente");
        // LO MISMO.
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar el game");
        }
    }
}