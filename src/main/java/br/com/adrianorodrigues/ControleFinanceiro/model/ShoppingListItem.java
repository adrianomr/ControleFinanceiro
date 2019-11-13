package br.com.adrianorodrigues.ControleFinanceiro.model;

import javax.persistence.*;

@Entity
@Table(name = "shopping_list_item")
public class ShoppingListItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shoppingListId")
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "producId")
    private Product product;

}
