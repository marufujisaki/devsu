package com.devsu.client;

import com.devsu.client.controllers.ClientController;
import com.devsu.client.dto.ClientDTO;
import com.devsu.client.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientController.class)
class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        // Setup code if needed
    }

    @Test
    void testCreateClient() throws Exception {
        ClientDTO newClient = new ClientDTO();
        newClient.setName("John Doe");
        newClient.setAddress("123 Main St");
        newClient.setPhone("1234567890");
        newClient.setGenre("Male");
        newClient.setAge(30);
        newClient.setIdentification("ID12345");
        newClient.setPassword("password123");
        newClient.setStatus(true);

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newClient)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John Doe"))
                .andExpect(jsonPath("$.address").value("123 Main St"))
                .andExpect(jsonPath("$.phone").value("1234567890"))
                .andExpect(jsonPath("$.genre").value("Male"))
                .andExpect(jsonPath("$.age").value(30))
                .andExpect(jsonPath("$.identification").value("ID12345"))
                .andExpect(jsonPath("$.status").value(true));
    }
}
