package com.example.demo.controller;

import com.example.demo.dao.ClientDao;
import com.example.demo.entity.Client;
import com.example.demo.entity.QueryEntity;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @nAuthor: yh
 * @Date: 11/18/2020 11:32 AM
 * @Description:
 **/
@RestController
@RequestMapping("client")
@CrossOrigin
public class ClientController {
    @Autowired
    ClientService clientService;

    @RequestMapping("getAllClients")
    public List<Client>   getAllClients(){
        return clientService.getAllClients();
    }


    @RequestMapping("deleteClientById")
    public void  deleteClientById(Integer id){
         clientService.deleteClientById(id);
    }

    @RequestMapping("saveClient")
    public void  saveClient(@RequestBody Client client){
        System.out.println(client);
        clientService.saveClient(client);
    }

    @RequestMapping("updateClient")
    public void  updateClient(@RequestBody Client client){
        System.out.println(client);
        clientService.updateClient(client);
    }

    @RequestMapping("getAllCreatePerson")
    List<String> getAllCreatePerson(){
        List<String> stringListA = clientService.getAllCreatePerson();
        return stringListA;
    }


    @RequestMapping("getAllClientType")
    List<String> getAllClientType(){
        List<String> stringListB = clientService.getAllClientType();
        return stringListB;
    }

    @RequestMapping("getClientsByConditions")
    List<Client> getClientsByConditions(@RequestBody QueryEntity queryEntity){
        System.out.println(queryEntity.toString());
        return clientService.GetClientsByConditions(queryEntity);
    }
}
