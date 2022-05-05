package com.capgemini.ccsw.tutorial_server.client;
import com.capgemini.ccsw.tutorial_server.category.model.Category;
import com.capgemini.ccsw.tutorial_server.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;
import com.capgemini.ccsw.tutorial_server.load.model.LoadDto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ClientIT {

	  public static final String LOCALHOST = "http://localhost:";
	  public static final String SERVICE_PATH = "/client/";
	  public static final String CLIENT_ID = "idClient";
	  public static final Long CLIENT_PARAM = 1L;
	  @LocalServerPort
	    private int port;

	   

	    private String getUrlWithParams(){
	        return UriComponentsBuilder.fromHttpUrl(LOCALHOST + port + SERVICE_PATH)
	        .queryParam(CLIENT_ID, "{" + CLIENT_PARAM +"}")
	        .encode()
	        .toUriString();
	    }
	    @Autowired
	    private TestRestTemplate restTemplate;
	    
	    ParameterizedTypeReference<List<ClientDto>> responseType = new ParameterizedTypeReference<List<ClientDto>>(){};

	    @Test
	    public void findAllShouldReturnAllClients() {

	          ResponseEntity<List<ClientDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);

	          assertNotNull(response);
	          assertEquals(3, response.getBody().size());
	    }
	    
	    public static final Long NEW_CLIENT_ID = 3L;
	    public static final String NEW_CLIENT_NAME = "Carla";
	    public static final String CLIENT_NAME = "Sara";
	    private static final Integer CLIENT_ID_PARAM = 1;
	    public static final Long MODIFY_CLIENT_ID = 2L;
	    public static final String MODIFY_CLIENT_NAME = "Teresa";

	    @Test
	    public void saveWithoutIdShouldCreateNewClient() {

	          ClientDto dto = new ClientDto();
	          dto.setName(NEW_CLIENT_NAME);

	          restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

	          ResponseEntity<List<ClientDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
	          assertNotNull(response);
	          assertEquals(3, response.getBody().size());

	          ClientDto clientSearch = response.getBody().stream().filter(item -> item.getId().equals(NEW_CLIENT_ID)).findFirst().orElse(null);
	          assertNotNull(clientSearch);
	          assertEquals(NEW_CLIENT_NAME, clientSearch.getName());
	    }
	    
	  

	    @Test
	    public void modifyWithExistIdShouldModifyClient() {

	          ClientDto dto = new ClientDto();
	          dto.setName("Raúl");

	          restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + MODIFY_CLIENT_ID, HttpMethod.PUT, new HttpEntity<>(dto), Void.class);

	          ResponseEntity<List<ClientDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
	          assertNotNull(response);
	          assertEquals(3, response.getBody().size());

	          ClientDto clientSearch = response.getBody().stream().filter(item -> item.getId().equals(MODIFY_CLIENT_ID)).findFirst().orElse(null);
	          assertNotNull(clientSearch);
	          assertEquals("Raúl", clientSearch.getName());
	    }
	  

	   
	    public static final Long DELETE_CLIENT_ID = 2L;
	    @Test
	    public void deleteWithExistsIdShouldDeleteClient() {

	          restTemplate.exchange(LOCALHOST + port + SERVICE_PATH + DELETE_CLIENT_ID, HttpMethod.DELETE, null, Void.class);

	          ResponseEntity<List<ClientDto>> response = restTemplate.exchange(LOCALHOST + port + SERVICE_PATH, HttpMethod.GET, null, responseType);
	          assertNotNull(response);
	          assertEquals(3, response.getBody().size());
	    }

	   
	    @Test
	    public void countClientExist() {
	    	  Map<Integer, Object> params = new HashMap<>();
	          params.put(CLIENT_ID_PARAM, CLIENT_NAME);
	          ResponseEntity<List<ClientDto>> response = restTemplate.exchange(getUrlWithParams(), HttpMethod.GET, null, responseType, params);
	          assertNotNull(response);
	          assertEquals(1, 1);

	          
	         
	    }
}
