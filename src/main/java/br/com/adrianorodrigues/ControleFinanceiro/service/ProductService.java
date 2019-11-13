package br.com.adrianorodrigues.ControleFinanceiro.service;

import br.com.adrianorodrigues.ControleFinanceiro.exceptions.ResourceNotFoundException;
import br.com.adrianorodrigues.ControleFinanceiro.model.Product;
import br.com.adrianorodrigues.ControleFinanceiro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long productId, Product productRequest) {
        return productRepository.findById(productId)
                .map(product -> {
                    productRequest.setId(productId);
                    return productRepository.save(productRequest);
                }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
    }

    public ResponseEntity deleteProduct(Long productId) {
        productRepository.findById(productId)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + productId));
        return null;
    }

    public Page<Product> getProductList(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
