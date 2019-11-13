package br.com.adrianorodrigues.ControleFinanceiro.service;

import br.com.adrianorodrigues.ControleFinanceiro.exceptions.ResourceNotFoundException;
import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingList;
import br.com.adrianorodrigues.ControleFinanceiro.repository.ShoppingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ShoppingListService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingList insertShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList updateShoppingList(Long shoppingListId, ShoppingList shoppingListRequest) {
        return shoppingListRepository.findById(shoppingListId)
                .map(shoppingList -> {
                    shoppingListRequest.setId(shoppingListId);
                    return shoppingListRepository.save(shoppingListRequest);
                }).orElseThrow(() -> new ResourceNotFoundException("ShoppingList not found with id " + shoppingListId));
    }

    public ResponseEntity deleteShoppingList(Long shoppingListId) {
        shoppingListRepository.findById(shoppingListId)
                .map(shoppingList -> {
                    shoppingListRepository.delete(shoppingList);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("ShoppingList not found with id " + shoppingListId));
        return null;
    }

    public Page<ShoppingList> getShoppingListList(Pageable pageable) {
        return shoppingListRepository.findAll(pageable);
    }
}
