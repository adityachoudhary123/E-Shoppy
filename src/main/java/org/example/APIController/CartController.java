package org.example.APIController;

import org.example.DataAccessLayer.Repository;
import org.example.Model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    Repository repo = new Repository();

    @PostMapping("/cart")
    public HttpStatus addCart(@RequestParam int product_Id, String username, int quantity)
    {
        boolean res = repo.addCart(product_Id, username, quantity);
        if(res)
           return HttpStatus.ACCEPTED;
        return HttpStatus.BAD_REQUEST;
    }

    @GetMapping("/cart")
    public List<Product> getCart(@RequestParam String username)
    {
        return repo.getCart(username);
    }
}
