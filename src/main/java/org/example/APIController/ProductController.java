package org.example.APIController;

import org.example.DataAccessLayer.Repository;
import org.example.Model.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    Repository repo = new Repository();

    @PostMapping("/search")
    public List<Product> getProducts(@RequestBody String productName)
    {
        productName = productName.toUpperCase();
        return repo.getProduct(productName);
    }
}
