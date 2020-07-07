package id.app.amira.migrasidata.service;

import id.app.amira.migrasidata.model.MasterU;

import java.util.List;


public interface IMigrasiDataService {
    List<MasterU> selecAllDataSimkeu();
    List<MasterU> selecAllDataAmira();
    List<MasterU> selectDataByParameter();
    void migrasiData(String parameter);
}
