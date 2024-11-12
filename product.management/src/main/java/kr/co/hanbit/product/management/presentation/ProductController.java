package kr.co.hanbit.product.management.presentation;

import kr.co.hanbit.product.management.application.SimpleProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }
    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return simpleProductService.add(productDto);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductDto findProductById(@PathVariable Long id){
        //Product 생성, 리스트에 넣기
        return simpleProductService.findById(id);
    }
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<ProductDto> findProducts(
            @RequestParam(required = false) String name
    ) {
        if (null == name)
            return simpleProductService.findAll();

        return simpleProductService.findByNameContaining(name);
    }
}