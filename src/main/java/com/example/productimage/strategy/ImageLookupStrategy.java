package com.example.productimage.strategy;

import com.example.productimage.dto.colour.ColoursResponse;
import com.example.productimage.exceptions.GenericDataMissingException;
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
public class ImageLookupStrategy {

    public final static String BASE_DOMAIN = "cdn.mec.ca";
    public final static String REPLACE_DOMAIN = "mec.imgix.net";
    public final static String PALETTE_PARAMETER = "?palette=json";

    @Resource
    private RestTemplate restTemplate;

    public ColoursResponse fetchColoursForImage(final String imageUri) {
        try {

            final ResponseEntity<ColoursResponse> resultResponseEntity = restTemplate.getForEntity(buildUrlWithImageUri(imageUri), ColoursResponse.class);
            if (resultResponseEntity.getStatusCode().is2xxSuccessful()) {
                return resultResponseEntity.getBody();
            } else {
                throw new GenericDataMissingException("Response from colour service was not 2xx, instead: " + resultResponseEntity.getStatusCode() + "image uri: " + imageUri);
            }
        } catch (final ResourceAccessException e) {
            throw new GenericDataMissingException("There was an error connecting to the image with URL" + imageUri, e);
        }
    }

    private String buildUrlWithImageUri(final String imageUri) {
        return imageUri.replace(BASE_DOMAIN, REPLACE_DOMAIN) + PALETTE_PARAMETER;
    }

}
