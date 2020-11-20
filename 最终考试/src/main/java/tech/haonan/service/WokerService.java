package tech.haonan.service;

import tech.haonan.entity.Worker;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/12/2020 7:15 PM
 * @Description:
 **/
public interface WokerService {
    public List<Worker> searchWorker(Worker worker);
    public List<Worker> findAll();


}
