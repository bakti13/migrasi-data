package id.app.amira.migrasidata.service;

import id.app.amira.migrasidata.model.DatatablesResponse;

import java.util.List;


public interface IMigrasiDataService {
    void migrasiData(String tahun, String lokasi);
    List<String> selectTahunAnggaran();
    List<String> selectLokasi();
    DatatablesResponse getDataTable(int draw, int start, int length, String search, String thnAng, String lokasi);
}
