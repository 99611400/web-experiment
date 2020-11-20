package com.example.demo.dao;

import com.example.demo.entity.Client;
import com.example.demo.entity.QueryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/18/2020 10:40 AM
 * @Description:
 **/
@Mapper
public interface ClientDao {
    List<Client> getAllClients();
    void deleteClientById(@Param("id") Integer id);
    void saveClient( Client client);
    void updateClient(Client client);
    List<String> getAllCreatePerson();
    List<String> getAllClientType();
    List<Client> GetClientsByConditions(QueryEntity queryEntity);
}
