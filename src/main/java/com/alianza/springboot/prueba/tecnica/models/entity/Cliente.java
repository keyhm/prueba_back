package com.alianza.springboot.prueba.tecnica.models.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    private String shared_key;

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    @Column(nullable = false)
    private String business_id;
    private String email;
    private String phone;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_added", nullable = false, updatable = false)
    private Date data_added;

    @PrePersist
    public void prePersist() {
        data_added = new Date();
        shared_key = generateSharedKey();
    }

    public String getShared_key() {
        return shared_key;
    }

    private String generateSharedKey() {
        if (business_id != null && !business_id.isEmpty()) {
            String[] words = business_id.split("\\s+");
            StringBuilder sharedKeyBuilder = new StringBuilder();

            for (String word : words) {
                if (!word.isEmpty()) {
                    sharedKeyBuilder.append(word.substring(0, 1).toLowerCase());
                }
            }

            if (!sharedKeyBuilder.isEmpty()) {
                return sharedKeyBuilder.toString() + "_" + System.currentTimeMillis();
            } else {
                return "defaultKey_" + System.currentTimeMillis();
            }
        } else {
            return "defaultKey_" + System.currentTimeMillis();
        }
    }

}
