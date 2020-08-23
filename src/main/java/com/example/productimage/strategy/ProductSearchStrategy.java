package com.example.productimage.strategy;

import com.example.productimage.dto.product.ProductSearchResult;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * Built by Steven
 * Github: "https://github.com/NightPlex"
 **/
@Service
public class ProductSearchStrategy {

    @Resource
    private Environment env;

    public ProductSearchResult fetchProductsForQuery(final String query) {

        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<ProductSearchResult> resultResponseEntity = restTemplate.getForEntity(buildUrlWithQuery(query), ProductSearchResult.class);
        return resultResponseEntity.getBody();
    }

    private String buildUrlWithQuery(final String query) {
        final String baseUrl = env.getProperty("product.search.api", "http://www.mec.ca/api/v1/products/search?keywords=");
        return baseUrl + query;
    }

}
