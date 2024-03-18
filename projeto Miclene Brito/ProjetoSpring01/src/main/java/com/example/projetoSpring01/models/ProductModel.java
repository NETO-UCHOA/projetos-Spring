package com.example.projetoSpring01.models;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "PROJETO01")

public class ProductModel {
private static final long serialVersionUID = 1l;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID idproduct;
private String name;
private BigDecimal value;
public static long getSerialversionuid() {
    return serialVersionUID;
}
public UUID getIdproduct() {
    return idproduct;
}
public void setIdproduct(UUID idproduct) {
    this.idproduct = idproduct;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public BigDecimal getValue() {
    return value;
}
public void setValue(BigDecimal value) {
    this.value = value;
}




}
