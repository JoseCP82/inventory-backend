package com.company.inventory.controllers;

import com.company.inventory.model.Product;
import com.company.inventory.response.ProductResponseRest;
import com.company.inventory.services.IProductService;
import com.company.inventory.utils.Util;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {

    private IProductService productService;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * Save products
     * @param picture
     * @param name
     * @param price
     * @param account
     * @param categoryId
     * @return
     * @throws IOException
     */
    @PostMapping("/products")
    public ResponseEntity<ProductResponseRest> save (
            @RequestParam("picture") MultipartFile picture,
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("account") int account,
            @RequestParam("id") Long categoryId
            ) throws IOException
    {
        Product product = new Product();
        product.setName(name);
        product.setAccount(account);
        product.setPrice(price);
        product.setPicture(Util.compressZLib(picture.getBytes()));
        ResponseEntity<ProductResponseRest> response = productService.save(product, categoryId);
        return response;
    }

    /**
     * Search by Id
     * @param id
     * @return
     */
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> searchById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.searchById(id);
        return response;
    }

    /**
     * Search by name
     * @param name
     * @return
     */
    @GetMapping("/products/filter/{name}")
    public ResponseEntity<ProductResponseRest> searchByName(@PathVariable String name) {
        ResponseEntity<ProductResponseRest> response = productService.searchByName(name);
        return response;
    }

    /**
     * Delete by Id
     * @param id
     * @return
     */
    @DeleteMapping("/products/{id}")
    public ResponseEntity<ProductResponseRest> deleteById(@PathVariable Long id) {
        ResponseEntity<ProductResponseRest> response = productService.deleteById(id);
        return response;
    }
}
