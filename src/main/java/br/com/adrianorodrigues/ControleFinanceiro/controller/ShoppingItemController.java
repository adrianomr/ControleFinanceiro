package br.com.adrianorodrigues.ControleFinanceiro.controller;

import br.com.adrianorodrigues.ControleFinanceiro.exceptions.ResourceNotFoundException;
import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingItem;
import br.com.adrianorodrigues.ControleFinanceiro.repository.ShoppingItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("shopping-item")
public class ShoppingItemController {
    @Autowired
    private ShoppingItemRepository shoppingItemRepository;

    @GetMapping
    public Page<ShoppingItem> getShoppingItems(Pageable pageable) {
        return shoppingItemRepository.findAll(pageable);
    }


    @PostMapping
    public ShoppingItem createShoppingItem(@Valid @RequestBody ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    @PutMapping("/{shoppingItemId}")
    public ShoppingItem updateShoppingItem(@PathVariable Long shoppingItemId,
                                           @Valid @RequestBody ShoppingItem shoppingItemRequest) {
        return shoppingItemRepository.findById(shoppingItemId)
                .map(shoppingItem -> {
                    shoppingItem.setDescricao(shoppingItemRequest.getDescricao());
                    shoppingItem.setValor(shoppingItemRequest.getValor());
                    return shoppingItemRepository.save(shoppingItem);
                }).orElseThrow(() -> new ResourceNotFoundException("ShoppingItem not found with id " + shoppingItemId));
    }


    @DeleteMapping("/{shoppingItemId}")
    public ResponseEntity<?> deleteShoppingItem(@PathVariable Long shoppingItemId) {
        return shoppingItemRepository.findById(shoppingItemId)
                .map(shoppingItem -> {
                    shoppingItemRepository.delete(shoppingItem);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ShoppingItem not found with id " + shoppingItemId));
    }
}
