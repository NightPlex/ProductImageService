package com.example.productimage.strategy;

import com.example.productimage.dto.colour.ColorsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    public ColorsResponse fetchColorsForImage(final String imageUri) {
        final ResponseEntity<ColorsResponse> resultResponseEntity = restTemplate.getForEntity(buildUrlWithImageUri(imageUri), ColorsResponse.class);
        return resultResponseEntity.getBody();
    }

    private String buildUrlWithImageUri(final String imageUri) {
        return imageUri.replace(BASE_DOMAIN, REPLACE_DOMAIN) + PALETTE_PARAMETER;
    }

}
