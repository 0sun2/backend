package kr.co.hanbit.product.management.application;

import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.infrastructure.ListProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties;
import org.springframework.stereotype.Service;
import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.presentation.ProductDto;

import java.util.List;

@Service
public class SimpleProductService {
    private ListProductRepository listProductRepository;
    private ModelMapper modelMapper;

    @Autowired
    SimpleProductService(ListProductRepository listProductRepository, ModelMapper modelMapper) {
        this.listProductRepository = listProductRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDto add(ProductDto productDto) {
        // 1. ProductDto를 Product로 변환하는 부분
        Product product = modelMapper.map(productDto, Product.class);

        // 2.  레퍼지토리 호출
        Product savedProduct = listProductRepository.add(product);

        // 3. Product를 ProductDto로 변환하는 부분
        ProductDto savedProductDto = modelMapper.map(savedProduct, ProductDto.class);

        // 4. Dto를 반환
        return savedProductDto;
    }

    public  ProductDto findById(Long id) {
        Product product = listProductRepository.findById(id);
        ProductDto productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    public List<ProductDto> findAll() {
        List<Product> products = listProductRepository.findAll();
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }
    public List<ProductDto> findByNameContaining(String name) {
        List<Product> products = listProductRepository.findByNameContaining(name);
        List<ProductDto> productDtos = products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
        return productDtos;
    }
}
