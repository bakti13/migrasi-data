package id.app.amira.migrasidata.service.impl;

import id.app.amira.migrasidata.model.*;
import id.app.amira.migrasidata.repo.amira.AmiraRepository;
import id.app.amira.migrasidata.repo.simkeu.SimkeuRepository;
import id.app.amira.migrasidata.service.IMigrasiDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrasiDataService implements IMigrasiDataService {

    private final static int LENGTH = 1000;

    @Autowired
    SimkeuRepository simkeuRepo;


    @Autowired
    AmiraRepository amiraRepo;

    @Override
    public void migrasiData(String tahun, String lokasi) {
        int start = 0;
        int total = simkeuRepo.getMasterU().getTotalData(tahun, lokasi);
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<MasterU> item = simkeuRepo.getMasterU().getDataByParameter(start, LENGTH, tahun, lokasi);
            for (MasterU master : item) {
                amiraRepo.getMasterU().save(master);
            }
        }
    }

    @Override
    public void migrasiJenisTransaksi() {
        int start = 0;
        int total = simkeuRepo.getJenisTrans().getTotalData();
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<JenisTransaksi> item = simkeuRepo.getJenisTrans().getDataByParameter(start, LENGTH);
            for (JenisTransaksi jenis : item) {
                amiraRepo.getJenisTransaksi().save(jenis);
            }
        }
    }

    @Override
    public void migrasiKpknl() {
        int start = 0;
        int total = simkeuRepo.getKpknl().getTotalData();
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<Kpknl> item = simkeuRepo.getKpknl().getDataByParameter(start, LENGTH);
            for (Kpknl kpknl : item) {
                amiraRepo.getKpknl().save(kpknl);
            }
        }
    }

    @Override
    public void migrasiKppn() {
        int start = 0;
        int total = simkeuRepo.getKppn().getTotalData();
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<Kppn> item = simkeuRepo.getKppn().getDataByParameter(start, LENGTH);
            for (Kppn kppn : item) {
                amiraRepo.getKppn().save(kppn);
            }
        }
    }

    @Override
    public void migrasiUpb() {
        int start = 0;
        int total = simkeuRepo.getUpb().getTotalData();
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<Upb> item = simkeuRepo.getUpb().getDataByParameter(start, LENGTH);
            for (Upb upb : item) {
                amiraRepo.getUpb().save(upb);
            }
        }
    }

    @Override
    public void migrasiSskel() {
        int start = 0;
        int total = simkeuRepo.getSskel().getTotalData();
        for (int i = 0; i < (total / LENGTH) + 1; i++) {
            if (i > 0) {
                start = (i * LENGTH);
            }
            List<Sskel> item = simkeuRepo.getSskel().getDataByParameter(start, LENGTH);
            for (Sskel sskel : item) {
                amiraRepo.getSskel().save(sskel);
            }
        }
    }

    @Override
    public int createViewMasterU() {
        return amiraRepo.getMasterU().createViewMasterU();
    }

    @Override
    public List<String> selectTahunAnggaran() {
        return simkeuRepo.getMasterU().getAllThnAng();
    }

    @Override
    public List<Lokasi> selectLokasi() {
        return simkeuRepo.getMasterU().getAllLokasi();
    }

    @Override
    public DatatablesResponse getDataTable(int draw, int start, int length, String search, String thnAng, String lokasi) {
        List<MasterU> list = simkeuRepo.getMasterU().getDataByParameter(start, length, thnAng, lokasi);
        int total = simkeuRepo.getMasterU().getTotalData(thnAng,lokasi);
        return DatatablesResponse.builder().draw(draw).data(list).recordsFiltered(total)
                .recordsTotal(total).build();
    }
}
