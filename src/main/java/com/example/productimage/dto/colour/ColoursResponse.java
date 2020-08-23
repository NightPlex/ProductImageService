package com.example.productimage.dto.colour;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
public class ColoursResponse {

    @JsonProperty("colors")
    private List<Colours> colours;

    public List<Colours> getColours() {
        return colours;
    }

    public void setColours(List<Colours> colours) {
        this.colours = colours;
    }
}
