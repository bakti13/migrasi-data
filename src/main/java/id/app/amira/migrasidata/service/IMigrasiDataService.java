package id.app.amira.migrasidata.service;

import id.app.amira.migrasidata.model.DatatablesResponse;
import id.app.amira.migrasidata.model.Lokasi;

import java.util.List;


public interface IMigrasiDataService {
    void migrasiData(String tahun, String lokasi);

    void migrasiJenisTransaksi();
    void migrasiKpknl();
    void migrasiKppn();
    void migrasiUpb();
    void migrasiSskel();

    int createViewMasterU();

    List<String> selectTahunAnggaran();
    List<Lokasi> selectLokasi();
    DatatablesResponse getDataTable(int draw, int start, int length, String search, String thnAng, String lokasi);
}
