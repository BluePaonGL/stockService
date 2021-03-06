package fr.isep.stockservice.application.controller;

import fr.isep.stockservice.application.DTO.ProductDTO;
import fr.isep.stockservice.application.port.ProductServicePort;
import fr.isep.stockservice.domain.criteria.ProductCriteria;
import fr.isep.stockservice.domain.model.Product;
import fr.isep.stockservice.domain.model.ProductType;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController

@Validated
@RequiredArgsConstructor

public class ProductController {
    @Autowired
    private ProductServicePort productServicePort;
    private ModelMapper modelMapper;
    private Product product;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> pageProductName(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(required = false) String name
    ) {
        ProductCriteria productCriteria = ProductCriteria.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .name(name)
                .build();

        return new ResponseEntity<>(this.productServicePort.pageProductName(productCriteria), HttpStatus.OK);
    }

    @GetMapping("/products/type")
    public ResponseEntity<Page<Product>> pageProductType(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(required = false) ProductType type
    ) {
        ProductCriteria productCriteria = ProductCriteria.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .type(type)
                .build();

        return new ResponseEntity<>(this.productServicePort.pageProductType(productCriteria), HttpStatus.OK);
    }


    @GetMapping("/products/peremptionDate")
    public ResponseEntity<Page<Product>> pageProductPeremptionDate(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "20") Integer pageSize,
            @RequestParam(defaultValue = "2") Integer noOfWeek
    ) {

        //final String date = new Date().toString();
        Date peremptionDate = new Date();
        ProductCriteria productCriteria = ProductCriteria.builder()
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .peremptionDate(peremptionDate)
                .build();

        return new ResponseEntity<>(this.productServicePort.pageProductPeremptionDate(productCriteria, noOfWeek), HttpStatus.OK);
    }

    @RequestMapping(value="/products/addProduct", method= RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody ProductDTO productDTO){
        return ResponseEntity.ok(this.productServicePort.saveProduct(productDTO));
    }

    @PostMapping(value="/products/addImage", consumes = {"multipart/form-data"})
    public ResponseEntity<Product> addImage(@RequestPart("product") ProductDTO productDTO, @RequestPart("file") MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productServicePort.saveProductWithImage(productDTO, image));
    }

    @PutMapping("/products/editProduct/{id}")
        public ResponseEntity<Product> editProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id){
            return ResponseEntity.ok(this.productServicePort.editProduct(productDTO,id));
    }

    @RequestMapping(value="/products/editImage/{id}", method= RequestMethod.PUT, consumes = {"multipart/form-data", "application/octet-stream"})
    public ResponseEntity<Product> editImage(@RequestPart("product") ProductDTO productDTO, @RequestPart("id") Long id, @RequestPart("file") MultipartFile image) throws IOException {
        return ResponseEntity.ok(this.productServicePort.editProductWithImage(productDTO, id, image));
    }

    @RequestMapping(value="/products/all", method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(this.productServicePort.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/findProductById/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(this.productServicePort.getProductById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/findProductByName/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable String name) {
        return new ResponseEntity<>(this.productServicePort.getProductByName(name), HttpStatus.OK);
    }


    @DeleteMapping("/products/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productServicePort.deleteProduct(id);
    }


}
