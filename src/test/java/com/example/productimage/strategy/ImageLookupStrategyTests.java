package com.example.productimage.strategy;

import com.example.productimage.dto.colour.ColoursResponse;
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
public class ImageLookupStrategyTests {

    @Resource
    private ImageLookupStrategy imageLookupStrategy;

    @MockBean
    private RestTemplate template;

    @Test
    public void testFetchColoursForImage() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final ColoursResponse coloursResponse = mapper.readValue(new File("test_files/image_lookup.json"), ColoursResponse.class);
        when(template.getForEntity(any(String.class), any(Class.class))).thenReturn(new ResponseEntity<>(coloursResponse, HttpStatus.OK));
        final ColoursResponse result = imageLookupStrategy.fetchColoursForImage("https://test.com");
        assertThat(result)
                .isNotNull()
                .matches(colours -> colours.getColours()
                        .stream()
                        .anyMatch(colour -> colour.getHex().equals("#030202")));
    }

}
