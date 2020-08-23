package com.example.productimage.service;

import com.example.productimage.AbstractProductImageTestBase;
import com.example.productimage.dto.response.ProductImageResponse;
import com.example.productimage.strategy.ImageLookupStrategy;
import com.example.productimage.strategy.ProductSearchStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
@SpringBootTest
public class ProductImageColourServiceTests extends AbstractProductImageTestBase {

    @MockBean
    private ImageLookupStrategy imageLookupStrategy;

    @MockBean
    private ProductSearchStrategy productSearchStrategy;

    @Resource
    private ProductImageColourService productImageColourService;

    @Test
    public void fetchProductImageColours() {
        prepareResponses(imageLookupStrategy, productSearchStrategy);
        final ProductImageResponse result = productImageColourService.fetchProductImageColours("forest");
        assertThat(result)
                .isNotNull();
        result.getProductImageColours().stream().findFirst().ifPresent(product -> {
            assertThat(product.getName().equals("Test product"));
            assertThat(product.getProductCode().equals("123456"));
            assertThat(product.getImageUri().equals("https://cdn.google.com/test"));
            assertThat(product.getColours().get(0).getHex().equals("#0c0b0b"));
        });
    }

}
