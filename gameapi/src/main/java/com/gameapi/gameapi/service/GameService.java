package com.gameapi.gameapi.service;
import com.gameapi.gameapi.model.Game;
import com.gameapi.gameapi.repository.GameRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional; // OPTIONAL REVISA: SI EXISTE LO DEVUELVE SI NO ENVIA UN NULL

@Service // DECLARA QUE TRABAJARA COMO SERVICE
public class GameService {
    private final GameRepository gameRepository; // VARIABLE PA USAR EL REPO

    //CONSTRUCTOR
    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    // METODO PA OBTENER TODOS LOS JUEGOS
    public List<Game> obtenerGames(){
        return gameRepository.findAll();
    }

    // METODO PA OBTENER UN JUEGO POR SU ID
    public Game buscarPorId(Integer id){
        Optional<Game> game = gameRepository.findById(id);
        return game.orElse(null);
    }

    // METODO PA GUARDAR UN JUEGO
    public Game guardarGame(Game game){
        return gameRepository.save(game);
    }

    // METODO PA ACTUALIZAR UN JUEGO CON SU ID USANDO PUT
    public Game actualizarGame(Game game){
        return gameRepository.save(game);
    }

    // METODO PA VER SI UN JUEGO EXISTE POR SU ID
    public boolean existePorId(Integer id){
        return gameRepository.existsById(id);
    }

    // METODO PA ELIMINAR UN JUEGO
    public void eliminarGame(Integer id){
        gameRepository.deleteById(id);
    }
}