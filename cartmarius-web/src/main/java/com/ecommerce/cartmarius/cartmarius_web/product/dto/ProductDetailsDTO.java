package com.ecommerce.cartmarius.cartmarius_web.product.dto;

import java.time.LocalDate;
import java.util.List;


public class ProductDetailsDTO {

    private Integer gameId;
    private String name;
    private LocalDate date;
    private String description;
    private String urlImg;
    private Integer price;

    private List<String> genres;
    private List<RequirementDTO> requirements;

    public static class RequirementDTO {
        private Integer requirementId;
        private Short osId;
        private String os;
        private Short requirementTypeId;
        private String processor;
        private String memory;
        private String graphics;

        // Getters y setters
        public Integer getRequirementId() { return requirementId; }
        public void setRequirementId(Integer requirementId) { this.requirementId = requirementId; }

        public Short getOsId() { return osId; }
        public void setOsId(Short osId) { this.osId = osId; }

        public String getOs() { return os; }
        public void setOs(String os) { this.os = os; }

        public Short getRequirementTypeId() { return requirementTypeId; }
        public void setRequirementTypeId(Short requirementTypeId) { this.requirementTypeId = requirementTypeId; }

        public String getProcessor() { return processor; }
        public void setProcessor(String processor) { this.processor = processor; }

        public String getMemory() { return memory; }
        public void setMemory(String memory) { this.memory = memory; }

        public String getGraphics() { return graphics; }
        public void setGraphics(String graphics) { this.graphics = graphics; }
    }

    // Getters y setters para el juego
    public Integer getGameId() { return gameId; }
    public void setGameId(Integer gameId) { this.gameId = gameId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrlImg() { return urlImg; }
    public void setUrlImg(String urlImg) { this.urlImg = urlImg; }

    public Integer getPrice() { return price; }
    public void setPrice(Integer price) { this.price = price; }

    public List<String> getGenres() { return genres; }
    public void setGenres(List<String> genres) { this.genres = genres; }

    public List<RequirementDTO> getRequirements() { return requirements; }
    public void setRequirements(List<RequirementDTO> requirements) { this.requirements = requirements; }

}
