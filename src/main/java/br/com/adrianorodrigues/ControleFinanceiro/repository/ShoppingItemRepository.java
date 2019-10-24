package br.com.adrianorodrigues.ControleFinanceiro.repository;

import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, Long> {

}