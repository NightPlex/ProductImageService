package com.example.productimage.strategy;

import com.example.productimage.dto.product.ProductSearchResult;
import com.example.productimage.exceptions.GenericDataMissingException;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
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

    @Resource
    private RestTemplate restTemplate;

    public ProductSearchResult fetchProductsForQuery(final String query) {
        try {
            final ResponseEntity<ProductSearchResult> resultResponseEntity = restTemplate.getForEntity(buildUrlWithQuery(query), ProductSearchResult.class);
            if (resultResponseEntity.getStatusCode().is2xxSuccessful()) {
                return resultResponseEntity.getBody();
            } else {
                throw new GenericDataMissingException("Response from product service was not 2xx, instead: " + resultResponseEntity.getStatusCode() + "query: " + query);
            }
        } catch (final ResourceAccessException e) {
            throw new GenericDataMissingException("There was an error connecting to the product with query" + query, e);
        }
    }

    private String buildUrlWithQuery(final String query) {
        final String baseUrl = env.getProperty("product.search.api", "http://www.mec.ca/api/v1/products/search?keywords=");
        return baseUrl + query;
    }

}
