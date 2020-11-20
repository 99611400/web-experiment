package com.example.demo;

import com.example.demo.entity.Client;
import com.example.demo.entity.QueryEntity;
import com.example.demo.entity.RangeTime;
import com.example.demo.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private ClientService clientService;
    @Test
    void testGetAllClient(){
        clientService.getAllClients().forEach(client -> System.out.println(client));
    }


    @Test
    void testdeleteClientById(){
        clientService.deleteClientById(3);
    }

    @Test
    void testsaveClient(){
        Client client = new Client();
        clientService.saveClient(client);
    }

    @Test
    void testUpdateClient(){
        Client client = new Client();
        client.setId(83);
        clientService.updateClient(client);
    }

    @Test
    void testGetAllCreatePerson() {
        System.out.println(clientService.getAllCreatePerson());

    }

    @Test
    void testgetAllClientType() {
        System.out.println(clientService.getAllClientType());
    }

    @Test
    void testGetClientsByConditions() {
        Date dateBegin = new Date();
        Date dateEnd = new Date();
        RangeTime rangeTime = new RangeTime(dateBegin,dateEnd);
        QueryEntity q = new QueryEntity("未跟进","重要客户",rangeTime,"刘星");
        List<Client> clients = clientService.GetClientsByConditions(q);
        System.out.println(clients);
    }

}
