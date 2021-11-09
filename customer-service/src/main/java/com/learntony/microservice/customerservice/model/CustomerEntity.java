package com.learntony.microservice.customerservice.model;

import com.learntony.microservice.customerservice.constant.CustomerType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid" , strategy = "uuid")
    private String id;
    private Date created;
    private Date updated;

    private CustomerType type;
    private String name;

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
