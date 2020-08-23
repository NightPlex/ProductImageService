package com.example.productimage.dto.response;

import java.util.List;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class ProductImageResponse {

    private List<ProductImageColour> productImageColours;

    public List<ProductImageColour> getProductImageColours() {
        return productImageColours;
    }

    public void setProductImageColours(List<ProductImageColour> productImageColours) {
        this.productImageColours = productImageColours;
    }
}
