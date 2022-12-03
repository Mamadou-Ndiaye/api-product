package com.ucad.sn.web;


import com.ucad.sn.domain.Product;
import com.ucad.sn.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products" ,  produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@Slf4j
public class ProductResource {
    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProduct = productService.findAll();
        allProduct.stream().forEach(product -> {log.info("ProductController::getProducts response {}", product.getName());});
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Product> getProduct(@PathVariable final Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }


    /*
          { "name": "vvvvvv", "prix": 1230000, "dateCreation":"2022-11-12",
            "category": {"id": 1, "nom": "Téléphone", "description": "Category des Téléphones"}
          }
     */
    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<Product> createProduct(@RequestBody final Product product) {
        log.info("ProductResource:createProduct request body {} ", product);
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable final Long id,
                                              @RequestBody  final Product productDTO) {
        productService.update(id, productDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable final Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/prodcat/{id}")
    public  ResponseEntity<List<Product>> findByCategory_Id(@PathVariable final Long id){
          return   ResponseEntity.ok(productService.findByCategory_Id(id));
    }


    @GetMapping("/prodsByName/{name}")
    public  ResponseEntity<List<Product>> findByNomProduitContains(@PathVariable(name = "name") final String name){
        return   ResponseEntity.ok(productService.findByNameContainsIgnoreCase(name));
    }




}
