package com.example.productimage.controller;

import com.example.productimage.dto.response.ProductImageResponse;
import com.example.productimage.service.ProductImageColourService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
@RestController
@RequestMapping("/product")
public class ProductImageColourController {

    @Resource
    private ProductImageColourService productImageColourService;

    @ApiOperation(value = "View a list up to 5 products with color palettes", response = ProductImageResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved products with palettes"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Generic connection or data missing issue"),
            @ApiResponse(code = 404, message = "Product with that search term cannot be found")
    }
    )
    @GetMapping("/colours")
    public ResponseEntity<?> fetchProductColours(final @RequestParam String searchQuery) {
        final ProductImageResponse productImageColours = productImageColourService.fetchProductImageColours(searchQuery);
        return ResponseEntity.ok(productImageColours);
    }

}
