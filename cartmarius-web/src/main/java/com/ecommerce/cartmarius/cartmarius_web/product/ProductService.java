package com.ecommerce.cartmarius.cartmarius_web.product;

import org.springframework.stereotype.Service;

import com.ecommerce.cartmarius.cartmarius_web.domain.model.Game;
import com.ecommerce.cartmarius.cartmarius_web.domain.model.Requirement;
import com.ecommerce.cartmarius.cartmarius_web.domain.repository.GameRepository;
import com.ecommerce.cartmarius.cartmarius_web.domain.repository.RequirementRepository;
import com.ecommerce.cartmarius.cartmarius_web.product.dto.ProductDetailsDTO;

@Service
public class ProductService {

    private final GameRepository gameRepository;
    private final RequirementRepository requirementRepository;

    public ProductService(GameRepository gameRepository, RequirementRepository requirementRepository){
        this.gameRepository = gameRepository;
        this.requirementRepository = requirementRepository;
    }

    public ProductDetailsDTO getProductDetailsById(Integer gameId){

        System.out.println("Mi game ID es: " + gameId);

        // Por favor haz bien la consulta esta es de prueba (optimizala !!ENSERIO!!)
        Game game = gameRepository.findGameById(gameId)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado con ID: " + gameId));

        // Por favor haz bien la consulta esta es de prueba (optimizala !!ENSERIO!!)
        Requirement requirement = requirementRepository.findRequirementById(gameId)
                .orElseThrow(() -> new RuntimeException("Juego no encontrado con ID: " + gameId)); 

        ProductDetailsDTO dto = new ProductDetailsDTO();

        dto.setGameId(game.getGameId());
        dto.setName(game.getName());
        dto.setDate(game.getDate());
        dto.setDescription(game.getDescription());
        dto.setUrlImg(game.getUrlImg());
        dto.setPrice(game.getPrice());



        return dto;
    }
}
