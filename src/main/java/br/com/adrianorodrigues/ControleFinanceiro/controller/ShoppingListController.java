package br.com.adrianorodrigues.ControleFinanceiro.controller;

import br.com.adrianorodrigues.ControleFinanceiro.model.ShoppingList;
import br.com.adrianorodrigues.ControleFinanceiro.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("shopping-list")
public class ShoppingListController {
    @Autowired
    private ShoppingListService shoppingListService;

    @GetMapping
    public Page<ShoppingList> getShoppingLists(Pageable pageable) {
        return shoppingListService.getShoppingListList(pageable);
    }


    @PostMapping
    public ShoppingList createShoppingList(@Valid @RequestBody ShoppingList shoppingList) {
        return shoppingListService.insertShoppingList(shoppingList);
    }

    @PutMapping("/{shoppingListId}")
    public ShoppingList updateShoppingList(@PathVariable Long shoppingListId,
                                           @Valid @RequestBody ShoppingList shoppingListRequest) {
        return shoppingListService.updateShoppingList(shoppingListId, shoppingListRequest);
    }


    @DeleteMapping("/{shoppingListId}")
    public ResponseEntity<?> deleteShoppingList(@PathVariable Long shoppingListId) {
        return shoppingListService.deleteShoppingList(shoppingListId);
    }
}
