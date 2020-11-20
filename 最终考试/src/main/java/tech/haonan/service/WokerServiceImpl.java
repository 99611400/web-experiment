package tech.haonan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.haonan.dao.WorkerDao;
import tech.haonan.entity.Worker;

import java.util.List;

/**
 * @Author: yhn
 * @Date: 11/12/2020 7:16 PM
 * @Description:
 **/
@Service
public class WokerServiceImpl implements WokerService {
    @Autowired
    private WorkerDao workerDao;

    @Override
    public List<Worker> searchWorker(Worker worker) {
        return workerDao.searchWorker(worker);
    }

    @Override
    public List<Worker> findAll() {
        return workerDao.findAll();
    }
}
