package id.app.amira.migrasidata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public interface MasterUDatatables {

//    @Value("#{target.rowNum}")
//    Long getRowNum();

    @Value("#{target.thn_ang}")
    String getThnAnggaran();

    @Value("#{target.nama}")
    String getLokasi();

    @Value("#{target.no_sppa}")
    String getNoSppa();

    @Value("#{target.kd_brg}")
    String getKdBarang();

    @Value("#{target.no_aset}")
    String getNoAset();

    @Value("#{target.tgl_perlh}")
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "dd-MM-yyyy"
    )
    Date getTglPeroleh();

    @Value("#{target.kondisi}")
    String getKondisi();
}
