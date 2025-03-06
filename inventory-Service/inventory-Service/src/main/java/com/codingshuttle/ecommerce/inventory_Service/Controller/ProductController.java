package com.codingshuttle.ecommerce.inventory_Service.Controller;

import com.codingshuttle.ecommerce.inventory_Service.Service.ProductService;
import com.codingshuttle.ecommerce.inventory_Service.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private  final DiscoveryClient discoveryClient;

    private final RestClient restClient;


    @GetMapping("/fetchOrder")
    public String fetchFromOrdersService() {
        List<ServiceInstance> instances = discoveryClient.getInstances("order-service");

        if (instances.isEmpty()) {
            throw new RuntimeException("No instances of order-service found");
        }

        ServiceInstance orderService = instances.stream().findFirst().orElseThrow();

        return restClient.get()
                .uri(orderService.getUri() + "/api/v1/orders/helloOrders")
                .retrieve()
                .body(String.class);
    }


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllInventory() {
        List<ProductDto> inventories = productService.getAllInventory();
        return ResponseEntity.ok(inventories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getInventoryById(@PathVariable Long id) {
        ProductDto inventory = productService.getProductById(id);
        return ResponseEntity.ok(inventory);
    }
}
