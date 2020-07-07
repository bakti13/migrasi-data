package id.app.amira.migrasidata.service.impl;

import id.app.amira.migrasidata.model.MasterU;
import id.app.amira.migrasidata.repo.amira.IAmiraRepository;
import id.app.amira.migrasidata.repo.simkeu.ISimkeuRepository;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MigrasiDataService implements IMigrasiDataService {

    private final static int LENGTH = 500;

    @Autowired
    ISimkeuRepository simkeuRepository;

    @Autowired
    IAmiraRepository amiraRepository;

    @Override
    public List<MasterU> selecAllDataSimkeu() {
        return simkeuRepository.getAllData();
    }

    @Override
    public List<MasterU> selecAllDataAmira() {
        return amiraRepository.getAllData();
    }

    @Override
    public List<MasterU> selectDataByParameter() {
//        return simkeuRepository.getDataByParam();

        return null;
    }

    @Override
    public void migrasiData(String parameter) {

//        long count = simkeuRepository.countByParameter(parameter);
        int start = 0;

        for (int i = 0; i < 1; i++) {
            if (i > 0) {
                start = (i * LENGTH) + 1;
            }
            List<MasterU> item = simkeuRepository.getDataByParameter(start, LENGTH, parameter);
//            System.out.println("size item? "+item.size());
            for (int j = 0; j < item.size(); j++) {
                System.out.println("loop ke-"+ j);
                amiraRepository.save(item.get(j));
            }
//            amiraRepository.saveAll(item);
        }
    }

    private int updateAmira(MasterU data) {
        return 0;
    }
}
