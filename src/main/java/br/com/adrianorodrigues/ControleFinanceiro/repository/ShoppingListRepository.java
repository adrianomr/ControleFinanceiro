package br.com.adrianorodrigues.ControleFinanceiro.repository;

import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {

}