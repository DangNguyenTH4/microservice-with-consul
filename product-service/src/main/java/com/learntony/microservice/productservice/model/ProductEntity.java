package com.learntony.microservice.productservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid" , strategy = "uuid")
    private String id;

    private String name;
    private BigDecimal price;
    private Date created;
    private Date updated;

    public ProductEntity(String name, BigDecimal price){
        this.name = name;
        this.price = price;
    }

    @PrePersist
    void onCreate(){
        this.setCreated(new Date());
        this.setUpdated(new Date());
    }
    @PreUpdate
    void onUpdate() {
        this.setUpdated(new Date());
    }
}
