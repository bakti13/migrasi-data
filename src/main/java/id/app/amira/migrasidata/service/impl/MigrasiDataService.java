package id.app.amira.migrasidata.service.impl;

import id.app.amira.migrasidata.model.MasterU;
import id.app.amira.migrasidata.repo.amira.IAmiraRepository;
import id.app.amira.migrasidata.repo.simkeu.ISimkeuRepository;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrasiDataService implements IMigrasiDataService {
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
    public void migrasiData(List<MasterU> data, String parameter) {

        for (MasterU d: data) {
            System.out.println(d.toString());
            amiraRepository.save(d);
        }
//        return 0;
    }
}
