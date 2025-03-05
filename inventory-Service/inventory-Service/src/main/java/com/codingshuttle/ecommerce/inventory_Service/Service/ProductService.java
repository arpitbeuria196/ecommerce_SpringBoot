package com.codingshuttle.ecommerce.inventory_Service.Service;


import com.codingshuttle.ecommerce.inventory_Service.Entity.Product;
import com.codingshuttle.ecommerce.inventory_Service.Repository.ProductRepository;
import com.codingshuttle.ecommerce.inventory_Service.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public List<ProductDto> getAllInventory()
    {
        log.info("Fetching all inventory Items");
        List<Product> inventories  = productRepository.findAll();
        return inventories.stream()
                .map((product -> modelMapper.map(product,ProductDto.class)))
                .collect(Collectors.toList());
    }

    public ProductDto getProductById(Long id)
    {
        log.info("fetching Product with ID:{}",id);
        Optional<Product> inventory = productRepository.findById(id);
        return  inventory.map(item ->modelMapper.map(item,ProductDto.class))
                .orElseThrow(()-> new RuntimeException("Inventory Not Found"));


    }

}
