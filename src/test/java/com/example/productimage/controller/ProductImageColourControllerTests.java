package com.example.productimage.controller;

import com.example.productimage.AbstractProductImageTestBase;
import com.example.productimage.dto.product.ProductSearchResult;
import com.example.productimage.dto.response.ProductImageResponse;
import com.example.productimage.exceptions.ProductNotFoundException;
import com.example.productimage.service.ProductImageColourService;
import com.example.productimage.strategy.ImageLookupStrategy;
import com.example.productimage.strategy.ProductSearchStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
@SpringBootTest
public class ProductImageColourControllerTests extends AbstractProductImageTestBase {

    @MockBean
    private ImageLookupStrategy imageLookupStrategy;

    @MockBean
    private ProductSearchStrategy productSearchStrategy;

    @Resource
    private ProductImageColourService productImageColourService;

    @Resource
    private ProductImageColourController productImageColourController;

    @Test
    public void fetchProductColours() {
        prepareResponses(imageLookupStrategy, productSearchStrategy);
        final ProductImageResponse result = productImageColourService.fetchProductImageColours("test");
        assertThat(result)
                .isNotNull();
        result.getProductImageColours().stream().findFirst().ifPresent(product -> {
            assertThat(product.getName().equals("Test product"));
            assertThat(product.getProductCode().equals("123456"));
            assertThat(product.getImageUri().equals("https://cdn.google.com/test"));
            assertThat(product.getColours().get(0).getHex().equals("#0c0b0b"));
        });
    }

    @Test
    public void noProductFound() {
        final ProductSearchResult productSearchResult = new ProductSearchResult();
        productSearchResult.setProducts(Collections.emptyList());

        when(productSearchStrategy.fetchProductsForQuery(any(String.class))).thenReturn(productSearchResult);
        assertThrows(ProductNotFoundException.class, () -> {
            productImageColourController.fetchProductColours("test");
        });
    }
}
