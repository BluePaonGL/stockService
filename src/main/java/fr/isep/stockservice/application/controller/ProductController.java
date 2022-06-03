package fr.isep.stockservice.application.controller;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController

@Validated
@RequiredArgsConstructor

public class ProductController {
    @Autowired
    private ProductServicePort productServicePort;
    private ModelMapper modelMapper;
    private Product product;

    @RequestMapping(value="/products/addProduct", method= RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(this.productServicePort.saveProduct(productDTO));
    }

    // Notre Stock ?
    @RequestMapping(value="/products", method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(this.productServicePort.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value="/products/findProductById/{id}", method= RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(this.productServicePort.getProductById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/products/findProductByName/{Name}", method= RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        return new ResponseEntity<>(this.productServicePort.getProduct(name), HttpStatus.OK);
    }

   @RequestMapping(value="/products/deleteProduct/{id}", method= RequestMethod.POST)
    public void deleteProduct(@PathVariable Long id){
        this.productServicePort.deleteProduct(id);
    }



}
