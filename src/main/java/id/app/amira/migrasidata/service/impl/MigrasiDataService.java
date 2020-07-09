package id.app.amira.migrasidata.service.impl;

import id.app.amira.migrasidata.model.DatatablesResponse;
import id.app.amira.migrasidata.model.MasterU;
import id.app.amira.migrasidata.repo.amira.IAmiraRepository;
import id.app.amira.migrasidata.repo.simkeu.ISimkeuRepository;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrasiDataService implements IMigrasiDataService {

    private final static int LENGTH = 500;

    @Autowired
    ISimkeuRepository simkeuRepository;

    @Autowired
    IAmiraRepository amiraRepository;

    @Override
    public void migrasiData(String parameter) {
        int start = 0;
        int total = simkeuRepository.getTotalData(parameter);
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH) + 1;
            }
            List<MasterU> item = simkeuRepository.getDataByParameter(start, LENGTH, parameter);
            for (MasterU master : item) {
                amiraRepository.save(master);
            }
        }
    }

    @Override
    public List<String> selectTahunAnggaran() {
        return simkeuRepository.getAllThnAng();
    }

    @Override
    public DatatablesResponse getDataTable(int draw, int start, int length, String search, String thnAng) {
        List<MasterU> list = simkeuRepository.getDataByParameter(start, length, thnAng);
        int total = simkeuRepository.getTotalData(thnAng);
        return DatatablesResponse.builder().draw(draw).data(list).recordsFiltered(total)
                .recordsTotal(total).build();
    }
}
