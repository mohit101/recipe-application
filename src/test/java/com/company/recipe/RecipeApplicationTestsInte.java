package com.company.recipe;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RecipeApplication.class)
public class RecipeApplicationTestsInte {

	    private int port=8082;

	    TestRestTemplate restTemplate = new TestRestTemplate();

	    HttpHeaders headers = new HttpHeaders();

	    @Test
	    public void testRetrieveRecipe() throws JSONException {

	        HttpEntity<String> entity = new HttpEntity<>(null, headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	                createURLWithPort("/api/recipe/getRecipe/10"),
	                HttpMethod.GET, entity, String.class);

	        String expected = "{\"id\":\"10\",\"name\":\"Pizza\",\"serving_count\":\"5\"}";

	        JSONAssert.assertEquals(expected, response.getBody(), false);
	    }

	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	}

