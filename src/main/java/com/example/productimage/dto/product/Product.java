package com.example.productimage.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class Product {

    @JsonProperty("default_image_urls")
    private DefaultImageUrls defaultImageUrls;
    private String name;
    @JsonProperty("product_code")
    private String productCode;


    public DefaultImageUrls getDefaultImageUrls() {
        return defaultImageUrls;
    }

    public void setDefaultImageUrls(DefaultImageUrls defaultImageUrls) {
        this.defaultImageUrls = defaultImageUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
