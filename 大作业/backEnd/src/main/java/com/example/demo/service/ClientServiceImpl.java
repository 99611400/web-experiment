package com.example.demo.service;

import com.example.demo.dao.ClientDao;
import com.example.demo.entity.Client;
import com.example.demo.entity.QueryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/18/2020 11:34 AM
 * @Description:
 **/
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Override
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    @Override
    public void deleteClientById(Integer id) {
        clientDao.deleteClientById(id);
    }

    @Override
    public void saveClient(Client client) {
        clientDao.saveClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.updateClient(client);
    }

    @Override
    public List<String> getAllCreatePerson() {
        return clientDao.getAllCreatePerson();
    }

    @Override
    public List<String> getAllClientType() {
        return clientDao.getAllClientType();
    }

    @Override
    public List<Client> GetClientsByConditions(QueryEntity queryEntity) {
        return clientDao.GetClientsByConditions(queryEntity);
    }
}
