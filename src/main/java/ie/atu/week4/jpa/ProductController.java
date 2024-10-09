package ie.atu.week4.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    private ProductService productService;
    public ProductController(ProductService productService)
    {
       this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts()
    {
        return productList;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        productList = productService.add(product);
        return ResponseEntity.ok(productList);
    }

    @PutMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody Product product)
    {
        return productService.update(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id)
    {
        return productService.delete(id);
    }
}
