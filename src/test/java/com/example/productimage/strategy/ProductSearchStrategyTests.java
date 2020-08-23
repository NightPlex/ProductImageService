package com.example.productimage.strategy;

import com.example.productimage.dto.product.ProductSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/

@SpringBootTest
public class ProductSearchStrategyTests {

    @Resource
    private ProductSearchStrategy productSearchStrategy;

    @MockBean
    private RestTemplate template;

    @Test
    public void fetchProductsForQuery() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ProductSearchResult productSearchResult = mapper.readValue(new File("test_files/product_search.json"), ProductSearchResult.class);
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity<>(productSearchResult, HttpStatus.OK));
        final ProductSearchResult result = productSearchStrategy.fetchProductsForQuery("forest");
        assertThat(result)
                .isNotNull()
                .matches(productSearch -> productSearch.getProducts()
                        .stream()
                        .anyMatch(product -> product.getProductCode().equals("5057-281")));
    }

}
