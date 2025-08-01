package com.ecommerce.cartmarius.cartmarius_web.product;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ecommerce.cartmarius.cartmarius_web.domain.repository.GameRepository;
import com.ecommerce.cartmarius.cartmarius_web.product.dto.ProductDetailsDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class ProductService {

    private final GameRepository gameRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProductService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public ProductDetailsDTO getProductDetailsById(Integer gameId) {

        Map<String, Object> row = gameRepository.getGameDetailsWithGenresAndRequirements(gameId);
        if (row == null) {
            throw new RuntimeException("Juego no encontrado con ID: " + gameId);
        }

        ProductDetailsDTO dto = new ProductDetailsDTO();
        dto.setGameId((Integer) row.get("game_id"));
        dto.setName((String) row.get("name"));
        dto.setDescription((String) row.get("description"));
        dto.setUrlImg((String) row.get("url_img"));
        dto.setPrice((Integer) row.get("price"));

        Object dateObj = row.get("date");
        if (dateObj instanceof java.sql.Date sqlDate) {
            dto.setDate(sqlDate.toLocalDate());
        }

        try {
            // Parse genres: JSON array de strings
            String genresJson = (String) row.get("genres");
            List<String> genres = objectMapper.readValue(genresJson, new TypeReference<List<String>>() {});
            dto.setGenres(genres);

            // Parse requirements: JSON array de objetos
            String reqJson = (String) row.get("requirements");
            List<ProductDetailsDTO.RequirementDTO> reqList = objectMapper.readValue(reqJson,
                new TypeReference<List<ProductDetailsDTO.RequirementDTO>>() {});
            dto.setRequirements(reqList);
        } catch (Exception e) {
            throw new RuntimeException("Error al parsear JSON: " + e.getMessage());
        }

        return dto;
    }
}
