package com.example.productimage.service;

import com.example.productimage.dto.colour.Colours;
import com.example.productimage.dto.product.ProductSearchResult;
import com.example.productimage.dto.response.ProductImageColour;
import com.example.productimage.dto.response.ProductImageResponse;
import com.example.productimage.exceptions.ProductNotFoundException;
import com.example.productimage.strategy.ImageLookupStrategy;
import com.example.productimage.strategy.ProductSearchStrategy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/

@Service
public class ProductImageColourService {

    @Resource
    private Environment env;

    @Resource
    private ProductSearchStrategy productSearchStrategy;

    @Resource
    private ImageLookupStrategy imageLookupStrategy;

    public ProductImageResponse fetchProductImageColours(final String query) {
        final ProductSearchResult productSearchResult = productSearchStrategy.fetchProductsForQuery(query);
        final int searchLimit = Integer.parseInt(env.getProperty("product.search.api.limit", "5"));

        if (productSearchResult == null || CollectionUtils.isEmpty(productSearchResult.getProducts())) {
            throw new ProductNotFoundException("No products found for query: " + query);
        }

         final List<ProductImageColour> productImageColours = productSearchResult.getProducts().stream()
                 .limit(searchLimit)
                 .map(product -> {
                     final ProductImageColour productImageColour = new ProductImageColour();
                     productImageColour.setProductCode(product.getProductCode());
                     productImageColour.setName(product.getName());
                     productImageColour.setImageUri(product.getDefaultImageUrls().getMainImageUrl());
                     final List<Colours> colours = imageLookupStrategy.fetchColoursForImage(product.getDefaultImageUrls().getMainImageUrl()).getColours();
                     productImageColour.setColours(colours);
                     return productImageColour;
                 })
                 .collect(Collectors.toList());
        final ProductImageResponse productImageResponse = new ProductImageResponse();
        productImageResponse.setProductImageColours(productImageColours);
        return productImageResponse;
    }

}
