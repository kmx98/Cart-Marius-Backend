package com.ecommerce.cartmarius.cartmarius_web.domain.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "game") // Nombre exacto de la tabla en la base de datos
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Si gameid es SERIAL o AUTO_INCREMENT
    @Column(name = "game_id") // Nombre exacto del campo en la tabla
    private Integer gameId;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date; // tipo DATE en PostgreSQL se mapea con LocalDate en Java

    @Column(name = "description")
    private String description;

    @Column(name = "url_img")
    private String urlImg;

    @Column(name = "price")
    private Integer price;

    // Getters y setters

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

    @Override
    public String toString() {
        return "Game [gameId=" + gameId + ", name=" + name + ", date=" + date + ", description=" + description
                + ", urlImg=" + urlImg + ", price=" + price + "]";
    }
    
}
