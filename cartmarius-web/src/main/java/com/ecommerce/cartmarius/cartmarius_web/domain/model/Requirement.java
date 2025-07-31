package com.ecommerce.cartmarius.cartmarius_web.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "requirement") // Nombre exacto de la tabla en la base de datos
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Si requirementId es SERIAL o AUTO_INCREMENT
    @Column(name = "requirement_id") // Nombre exacto del campo en la tabla
    private Integer requirementId;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "requirement_type_id")
    private short requirementTypeId;

    @Column(name = "os_id")
    private short osId;

    @Column(name = "processor")
    private String processor;

    @Column(name = "memory")
    private String memory;

    @Column(name = "graphics")
    private String graphics;

    @Column(name = "os")
    private String os;

    // Getters y setters

    public Integer getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(Integer requirementId) {
        this.requirementId = requirementId;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public short getRequirementTypeId() {
        return requirementTypeId;
    }

    public void setRequirementTypeId(short requirementTypeId) {
        this.requirementTypeId = requirementTypeId;
    }

    public short getOsId() {
        return osId;
    }

    public void setOsId(short osId) {
        this.osId = osId;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getGraphics() {
        return graphics;
    }

    public void setGraphics(String graphics) {
        this.graphics = graphics;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Requirement [requirementId=" + requirementId + ", gameId=" + gameId + ", requirementTypeId="
                + requirementTypeId + ", osId=" + osId + ", processor=" + processor + ", memory=" + memory
                + ", graphics=" + graphics + ", os=" + os + "]";
    }
}
