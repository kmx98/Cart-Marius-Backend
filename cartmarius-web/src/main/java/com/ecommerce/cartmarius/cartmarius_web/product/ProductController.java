package com.ecommerce.cartmarius.cartmarius_web.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Game;
import com.ecommerce.cartmarius.cartmarius_web.domain.repository.GameRepository;
import com.ecommerce.cartmarius.cartmarius_web.product.dto.ProductDetailsDTO;

@RestController
@RequestMapping("/games")
public class ProductController {

    private GameRepository repository;
    
    // Inyecccion sin constructor
    @Autowired
    private ProductService productService;

    // Constructor con inyeccion
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

    /*Recuerda:
     * 1. Hacer otro Endpoint pero este orientado al ID del juego.
     * 2. Esto con el proposito de obtener todos los datos requeridos 
     *    de la tabla game, requeriments y gameGenre.
     * 3. De esta manera podras tener los datos necesarios de la vista
     *    especifica del juego.
     * 4. Piensa en una forma en la que mediante el ID del juego puedas
     *    obtener todos estos datos cuando el usuario de click a un juego
     *    especifico desde el FrontEnd.
     */

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsDTO> getGameDetails(@PathVariable Integer id) {

        ProductDetailsDTO dto = productService.getProductDetailsById(id);
        
        return ResponseEntity.ok(dto);
    }

    
}
