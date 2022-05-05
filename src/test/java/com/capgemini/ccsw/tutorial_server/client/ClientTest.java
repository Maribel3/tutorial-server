package com.capgemini.ccsw.tutorial_server.client;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capgemini.ccsw.tutorial_server.client.model.Client;
import com.capgemini.ccsw.tutorial_server.client.model.ClientDto;

@ExtendWith(MockitoExtension.class)
public class ClientTest {

	@Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    public void findAllShouldReturnAllClients() {

          List<Client> list = new ArrayList<>();
          list.add(mock(Client.class));

          when(clientRepository.findAll()).thenReturn(list);

          List<Client> categories = clientService.findAll();

          assertNotNull(categories);
          assertEquals(1, categories.size());
    }
    
    public static final String CLIENT_NAME = "CLIENT1";
    @Test
    public void saveNotExistsClientIdShouldInsert() {

          ClientDto clientDto = new ClientDto();
         clientDto.setName(CLIENT_NAME);

          ArgumentCaptor<Client> client = ArgumentCaptor.forClass(Client.class);

          clientService.save(null, clientDto);

          verify(clientRepository).save(client.capture());

          assertEquals(CLIENT_NAME, client.getValue().getName());
    }
    
    public static final long EXISTS_CLIENT_ID = 1L;
    
    @Test
    public void saveExistsClientIdShouldUpdate() {

      ClientDto clientDto = new ClientDto();
      clientDto.setName(CLIENT_NAME);

      Client client = mock(Client.class);
      when(clientRepository.findById(EXISTS_CLIENT_ID)).thenReturn(Optional.of(client));

      clientService.save(EXISTS_CLIENT_ID, clientDto);

      verify(clientRepository).save(client);
    }
    
    @Test
    public void deleteExistsClientIdShouldDelete() {

          clientService.delete(EXISTS_CLIENT_ID);

          verify(clientRepository).deleteById(EXISTS_CLIENT_ID);
    }
}