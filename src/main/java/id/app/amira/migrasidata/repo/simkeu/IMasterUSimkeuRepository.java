package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.Lokasi;
import id.app.amira.migrasidata.model.MasterU;
import id.app.amira.migrasidata.model.MasterUCompositeId;
import id.app.amira.migrasidata.model.MasterUDatatables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IMasterUSimkeuRepository extends JpaRepository<MasterU, MasterUCompositeId> {

    @Query(value = "SELECT * FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn) AND IF(:lok = '', TRUE, kd_lokasi = :lok) LIMIT :start, :length",
            nativeQuery = true)
    List<MasterU> getDataByParameter(@Param("start") int start, @Param("length") int length,
                                     @Param("thn") String tahun, @Param("lok") String lokasi);

    @Query(value = "SELECT t.thn_ang, l.nama, t.no_sppa, t.kd_brg, t.no_aset, t.tgl_perlh, t.kondisi  FROM t_masteru t " +
            "INNER JOIN login l ON (l.kdlok = t.kd_lokasi) WHERE IF(:thn = '', TRUE, thn_ang = :thn) AND IF(:lok = '', TRUE, kd_lokasi = :lok) " +
            "AND IF(:cari = '', TRUE, (t.thn_ang LIKE %:cari% OR l.nama LIKE %:cari% OR t.no_sppa LIKE %:cari% OR t.kd_brg LIKE %:cari%)) LIMIT :start, :length",
            nativeQuery = true)
    List<MasterUDatatables> getDataTableByParameter(@Param("start") int start, @Param("length") int length,
                                                    @Param("thn") String tahun, @Param("lok") String lokasi,
                                                    @Param("cari") String search);

    @Query(value = "select distinct thn_ang from t_masteru order by thn_ang", nativeQuery = true)
    List<String> getAllThnAng();

    //    @Query(value = "select distinct kd_lokasi from t_masteru order by kd_lokasi", nativeQuery = true)
    @Query(value = "SELECT l.nama, t.kd_lokasi as kode FROM login l INNER JOIN t_masteru t ON (l.kdlok = t.kd_lokasi) GROUP BY l.nama ORDER BY l.nama", nativeQuery = true)
    List<Lokasi> getAllLokasi();

    @Query(value = "SELECT count(*) FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn) AND IF(:lok = '', TRUE, kd_lokasi = :lok)",
            nativeQuery = true)
    int getTotalData(@Param("thn") String tahun, @Param("lok") String lokasi);

}
