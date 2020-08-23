package com.example.productimage.dto.response;

import com.example.productimage.dto.colour.Colours;

import java.util.List;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class ProductImageColour {

    private String productCode;
    private String name;
    private String imageUri;
    private List<Colours> colours;


    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public List<Colours> getColours() {
        return colours;
    }

    public void setColours(List<Colours> colours) {
        this.colours = colours;
    }
}
