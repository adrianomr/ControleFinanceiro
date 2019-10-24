package br.com.adrianorodrigues.ControleFinanceiro.model;

import javax.persistence.*;

@Entity
@Table(name = "shopping_item")
public class ShoppingItem {
    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "varchar(100)")
    private String descricao;

    @Column(columnDefinition = "numeric(20,4)")
    private Double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
