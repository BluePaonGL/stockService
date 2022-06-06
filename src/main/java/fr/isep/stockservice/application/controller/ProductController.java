package fr.isep.stockservice.application.controller;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping(value="/products/addProduct", method= RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO,  @RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productServicePort.saveProduct(productDTO, image));
    }

    @PutMapping("/products/editProduct/{id}")
        public ResponseEntity<Product> editProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
            //à supprimer si jamais on peut récupere tout le form
            //Product toEdit = this.productServicePort.getProductById(id);
            //ProductDTO editedProductDTO = new ProductDTO(productDTO.getName(),productDTO.getDescription(),productDTO.getQuantity(),productDTO.getType(),productDTO.getPeremptionDate(),productDTO.getConsumptionDate(),productDTO.getAllergenSet());
            //return ResponseEntity.ok(this.productServicePort.saveProduct(editedProductDTO));
            return ResponseEntity.ok(this.productServicePort.editProduct(productDTO,id));
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

    @RequestMapping(value="/products/findProductByName/{name}", method= RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        return new ResponseEntity<>(this.productServicePort.getProductByName(name), HttpStatus.OK);
    }


   @DeleteMapping("/products/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id){
        this.productServicePort.deleteProduct(id);
    }



}
