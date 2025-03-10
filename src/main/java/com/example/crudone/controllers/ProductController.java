package com.example.crudone.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudone.domain.Product;
import com.example.crudone.dto.RequestProductDTO;
import com.example.crudone.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //consultar
    @GetMapping()
    public ResponseEntity getAllProduct(){
        var allProduct = productRepository.findAll();
        return ResponseEntity.ok(allProduct);
    }

    //inserir
    @PostMapping()
    public ResponseEntity resgisterProduct(@RequestBody @Valid RequestProductDTO data) {
        Product newProduct = new Product(data);
        productRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    //atualizar
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid RequestProductDTO data) {
        Optional <Product> optionalProduct = productRepository.findById(data.id());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice(data.price());
            return ResponseEntity.ok(product);
        } else{
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteProduct(@PathVariable String id){
        Optional <Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
            return ResponseEntity.noContent().build();
        } else{
            throw new EntityNotFoundException();
        }
    }
}