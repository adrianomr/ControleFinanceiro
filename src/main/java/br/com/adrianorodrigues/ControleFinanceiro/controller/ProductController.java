package br.com.adrianorodrigues.ControleFinanceiro.controller;

import br.com.adrianorodrigues.ControleFinanceiro.model.Product;
import br.com.adrianorodrigues.ControleFinanceiro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable) {
        return productService.getProductList(pageable);
    }


    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId,
                                 @Valid @RequestBody Product productRequest) {
        return productService.updateProduct(productId, productRequest);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }
}
