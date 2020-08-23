package com.example.productimage;

import com.example.productimage.dto.colour.Colours;
import com.example.productimage.dto.colour.ColoursResponse;
import com.example.productimage.dto.product.DefaultImageUrls;
import com.example.productimage.dto.product.Product;
import com.example.productimage.dto.product.ProductSearchResult;
import com.example.productimage.strategy.ImageLookupStrategy;
import com.example.productimage.strategy.ProductSearchStrategy;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/

public abstract class AbstractProductImageTestBase {

    protected void prepareResponses(final ImageLookupStrategy imageLookupStrategy, final ProductSearchStrategy productSearchStrategy) {

        final ColoursResponse coloursResponse = new ColoursResponse();
        Colours colours = new Colours();
        colours.setHex("#0c0b0b");
        coloursResponse.setColours(Collections.singletonList(colours));



        final DefaultImageUrls defaultImageUrls = new DefaultImageUrls();
        defaultImageUrls.setMainImageUrl("https://cdn.google.com/test");

        final Product product = new Product();
        product.setProductCode("123456");
        product.setName("Test product");
        product.setDefaultImageUrls(defaultImageUrls);

        final ProductSearchResult productSearchResult = new ProductSearchResult();
        productSearchResult.setProducts(Collections.singletonList(product));

        when(imageLookupStrategy.fetchColoursForImage(any(String.class))).thenReturn(coloursResponse);
        when(productSearchStrategy.fetchProductsForQuery(any(String.class))).thenReturn(productSearchResult);
    }

}
