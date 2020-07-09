package id.app.amira.migrasidata.service;

import id.app.amira.migrasidata.model.DatatablesResponse;
import id.app.amira.migrasidata.model.MasterU;

import java.util.List;


public interface IMigrasiDataService {
    void migrasiData(String parameter);
    List<String> selectTahunAnggaran();
    DatatablesResponse getDataTable(int draw, int start, int length, String search, String thnAng);
}
