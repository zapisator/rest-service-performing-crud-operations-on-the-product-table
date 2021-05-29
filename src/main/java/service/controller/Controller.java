package service.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.domain.Product;
import service.repository.ProductRepository;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class Controller {

    private final ProductRepository repository;

    @GetMapping
    public List<Product> getProducts() {
        return (List<Product>) repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product)
            throws URISyntaxException {
        Product savedProduct = repository.save(product);
        return ResponseEntity.created(
                new URI("/product/" + savedProduct.getId())
        ).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Integer id, @RequestBody Product product
    ) {
        Product currentProduct = repository.findById(id).orElseThrow(RuntimeException::new);
        currentProduct.setName(product.getName());
        currentProduct.setAmount(product.getAmount());
        currentProduct = repository.save(product);
        return ResponseEntity.ok(currentProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
