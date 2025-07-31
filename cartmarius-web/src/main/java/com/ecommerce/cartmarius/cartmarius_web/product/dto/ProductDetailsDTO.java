package com.ecommerce.cartmarius.cartmarius_web.product.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;

public class ProductDetailsDTO {

    // Game
    private Integer gameId;
    private String name;
    private LocalDate date;
    private String description;
    private String urlImg;
    private Integer price;

    // Requirement
    // private Integer requirementId;
    // private Integer gameId;
    // private short requirementTypeId;
    // private short osId;
    // private String processor;
    // private String memory;
    // private String graphics;
    // private String os;

    public Integer getGameId() {
        return gameId;
    }
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrlImg() {
        return urlImg;
    }
    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }

}
