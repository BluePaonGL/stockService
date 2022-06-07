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

    @RequestMapping(value="/products/addProduct", method= RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(this.productServicePort.saveProduct(productDTO));
    }

    @RequestMapping(value="/products/addImage", method= RequestMethod.POST, consumes = {"multipart/form-data"})
    public ResponseEntity<Product> addImage(@RequestPart("product") ProductDTO productDTO, @RequestPart("file") MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productServicePort.saveProductWithImage(productDTO, image));
    }

    @PutMapping("/products/editProduct/{id}")
        public ResponseEntity<Product> editProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
            //à supprimer si jamais on peut récupere tout le form
            //Product toEdit = this.productServicePort.getProductById(id);
            //ProductDTO editedProductDTO = new ProductDTO(productDTO.getName(),productDTO.getDescription(),productDTO.getQuantity(),productDTO.getType(),productDTO.getPeremptionDate(),productDTO.getConsumptionDate(),productDTO.getAllergenSet());
            //return ResponseEntity.ok(this.productServicePort.saveProduct(editedProductDTO));
            return ResponseEntity.ok(this.productServicePort.editProduct(productDTO,id));
    }

    @RequestMapping(value="/products/editImage/{id}", method= RequestMethod.PUT, consumes = {"multipart/form-data"})
    public ResponseEntity<Product> editImage(@RequestPart("product") ProductDTO productDTO, @RequestPart("id") Long id, @RequestPart("file") MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productServicePort.editProductWithImage(productDTO, id, image));
    }

    // Notre Stock ?
    @RequestMapping(value="/products/all", method= RequestMethod.GET)
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
