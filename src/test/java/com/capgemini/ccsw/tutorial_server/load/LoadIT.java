package com.capgemini.ccsw.tutorial_server.load;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorDto;
import com.capgemini.ccsw.tutorial_server.author.model.AuthorSearchDto;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;
import com.capgemini.ccsw.tutorial_server.game.model.Game;
import com.capgemini.ccsw.tutorial_server.game.model.GameDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadSearchDto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LoadIT {


	
	 public static final String LOCALHOST = "http://localhost:";
	    public static final String SERVICE_PATH = "/game/";
	    public static final Long EXISTS_LOAD = 1L;
	    public static final Long EXISTS_GAME = 1L;
	    public static final Long NOT_EXISTS_GAME_ID = 0L;
	    public static final Date DATE_BETWEEN = new Date(2022,04,04);
	    public static final Date DATE_LOAD = new Date(2022,02,02);
	    public static final Date DATE_RETURN = new Date (2022,02,12);
	    private static final Long NOT_EXISTS_CLIENT_ID = 0L;
	    private static final Long EXISTS_CLIENT = 3L;

	    private static final String CLIENT_ID_PARAM = "idClient";
	    private static final String GAME_ID_PARAM = "idGame";
	    private static final String DATE_PARAM = "fecha";
	    
	    @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    ParameterizedTypeReference<List<LoadDto>> responseType = new ParameterizedTypeReference<List<LoadDto>>(){};

	    private String getUrlWithParams(){
	        return UriComponentsBuilder.fromHttpUrl(LOCALHOST + port + SERVICE_PATH)
	        .queryParam(GAME_ID_PARAM, "{" + GAME_ID_PARAM +"}")
	        .queryParam(CLIENT_ID_PARAM, "{" + CLIENT_ID_PARAM +"}")
	        .encode()
	        .toUriString();
	    }

	    @Test
	    public void findWithoutFiltersShouldReturnAllLoadInDB() {

	          int LOAD_WITH_FILTER = 6;

	          Map<String, Object> params = new HashMap<>();
	          params.put(GAME_ID_PARAM, null);
	          params.put(CLIENT_ID_PARAM, null);

	          ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);

	          assertNotNull(response);
	          assertEquals(LOAD_WITH_FILTER, response.getBody().size());
	    }

	    @Test
	    public void findExistsGameShouldReturnLoads() {
	    	
	    	int LOAD_WITH_FILTER = 6;
	    	Map<String, Object> params = new HashMap<>();
	    	params.put(GAME_ID_PARAM, EXISTS_GAME);
	    	params.put(CLIENT_ID_PARAM, null);
	    	ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	    	assertNotNull(response);
	    	assertEquals(LOAD_WITH_FILTER,response.getBody().size());
	    }
	   
	    @Test
	    public void findExistsClientShouldReturnLoads() {
	    	
	    	int LOAD_WITH_FILTER = 6;
	    	Map<String, Object> params = new HashMap<>();
	    	params.put(GAME_ID_PARAM, null);
	    	params.put(CLIENT_ID_PARAM, EXISTS_CLIENT);
	    	ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	    	assertNotNull(response);
	    	assertEquals(LOAD_WITH_FILTER,response.getBody().size());
	    }
	   
	    @Test
	    public void findExistsClientAndGameReturnLoads() {
	    	
	    	int LOAD_WITH_FILTER = 6;
	    	Map<String, Object> params = new HashMap<>();
	    	params.put(GAME_ID_PARAM, EXISTS_GAME);
	    	params.put(CLIENT_ID_PARAM, EXISTS_CLIENT);
	    	ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	    	assertNotNull(response);
	    	assertEquals(LOAD_WITH_FILTER,response.getBody().size());
	    }
	    
	    @Test
	    public void findDateReturnLoads() {
	    	int LOAD_WITH_FILTER = 6;
	    	Map<String, Object> params = new HashMap<>();
	    	params.put(DATE_PARAM, DATE_BETWEEN);
	    	params.put(GAME_ID_PARAM, null);
	    	params.put(CLIENT_ID_PARAM, null);
	    	ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	    	assertNotNull(response);
	    	assertEquals(LOAD_WITH_FILTER,response.getBody().size());
	    }
	    
	    @Test
	    public void findDateAndNotExistGameAndClientReturnLoads() {
	    	int LOAD_WITH_FILTER = 6;
	    	Map<String, Object> params = new HashMap<>();
	    	params.put(DATE_PARAM, DATE_BETWEEN);
	    	params.put(GAME_ID_PARAM, NOT_EXISTS_GAME_ID);
	    	params.put(CLIENT_ID_PARAM, NOT_EXISTS_CLIENT_ID);
	    	ResponseEntity<List<LoadDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	    	assertNotNull(response);
	    	assertEquals(LOAD_WITH_FILTER,response.getBody().size());
	    }
	    
	  
	    
	    
}