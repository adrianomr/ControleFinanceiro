package br.com.adrianorodrigues.ControleFinanceiro.repository;

import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListItemRepository extends JpaRepository<ShoppingListItem, Long> {

}