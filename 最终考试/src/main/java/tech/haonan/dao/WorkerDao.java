package tech.haonan.dao;

import org.springframework.stereotype.Repository;
import tech.haonan.entity.Worker;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/12/2020 7:11 PM
 * @Description:
 **/
@Repository
public interface WorkerDao {
    public List<Worker> searchWorker(Worker worker);
    public List<Worker> findAll();
}
