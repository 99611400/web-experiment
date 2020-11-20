package com.example.demo.service;

import com.example.demo.entity.Client;
import com.example.demo.entity.QueryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/18/2020 11:33 AM
 * @Description:
 **/
public interface ClientService {
    List<Client> getAllClients();
    void deleteClientById(Integer id);
    void saveClient(Client client);
    void updateClient(Client client);
    List<String> getAllCreatePerson();
    List<String> getAllClientType();
    List<Client> GetClientsByConditions(QueryEntity queryEntity);

}
