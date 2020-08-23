package com.example.productimage.controller;

import com.example.productimage.dto.response.ProductImageResponse;
import com.example.productimage.service.ProductImageColourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
@RestController("/product")
public class ProductImageColourController {

    @Resource
    private ProductImageColourService productImageColourService;

    @GetMapping("/colours")
    public ResponseEntity<?> fetchProductColours(final @RequestParam String searchQuery) {
        final ProductImageResponse productImageColours = productImageColourService.fetchProductImageColours(searchQuery);
        return ResponseEntity.ok(productImageColours);
    }

}
