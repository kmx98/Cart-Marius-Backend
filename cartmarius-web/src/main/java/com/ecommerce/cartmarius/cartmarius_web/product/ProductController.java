package com.ecommerce.cartmarius.cartmarius_web.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Game;
import com.ecommerce.cartmarius.cartmarius_web.domain.repository.GameRepository;

@RestController
@RequestMapping("/games")
public class ProductController {

    private GameRepository repository;

    // Constructor con inyeccion
    @Autowired
    public ProductController(GameRepository repository) {
        this.repository = repository;
    }

    // Endpoint para buscar por nombre
    @GetMapping("/by-name")
    public Optional<Game> getGameByName(@RequestParam String name) {
        return repository.buscarPorNombre(name);
    }
    /* Pon esto en POSTMAN: http://localhost:8080/games/by-name?name=Among%20Us
     * Te retornara los campos de la tabla en un json y si no hay errores entonces
     * sabras que estas conectado a la DB satisfactoriamente
     */
}
