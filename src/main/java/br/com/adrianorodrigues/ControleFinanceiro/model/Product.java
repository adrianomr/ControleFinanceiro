package br.com.adrianorodrigues.ControleFinanceiro.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "varchar(100)")
    private String description;

    @Column(columnDefinition = "numeric(20,4)")
    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
