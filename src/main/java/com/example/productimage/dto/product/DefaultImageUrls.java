package com.example.productimage.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class DefaultImageUrls {

    @JsonProperty("main_image_url")
    private String main_image_url;

    public String getMainImageUrl() {
        return main_image_url;
    }

    public void setMainImageUrl(String main_image_url) {
        this.main_image_url = main_image_url;
    }
}
