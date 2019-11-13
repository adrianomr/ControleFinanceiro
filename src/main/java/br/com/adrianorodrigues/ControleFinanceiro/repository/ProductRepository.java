package br.com.adrianorodrigues.ControleFinanceiro.repository;

import br.com.adrianorodrigues.ControleFinanceiro.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}