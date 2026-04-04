package com.gameapi.gameapi.repository;
import com.gameapi.gameapi.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

// REPO QUE SE CONECTA CON LA DB
// RESCATA METODOS DEL JPA, COMO FINDALL / FINDBYID / WEAS ASI
public interface GameRepository extends JpaRepository<Game, Integer>{
}
