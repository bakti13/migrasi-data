package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.MasterUCompositeId;
import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISimkeuRepository extends JpaRepository<MasterU, MasterUCompositeId> {

    @Query(value = "SELECT * FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn) AND IF(:lok = '', TRUE, kd_lokasi = :lok) LIMIT :start, :length",
            nativeQuery = true)
    List<MasterU> getDataByParameter(@Param("start") int start, @Param("length") int length,
                                     @Param("thn") String tahun, @Param("lok") String lokasi);

    @Query(value = "select distinct thn_ang from t_masteru order by thn_ang", nativeQuery = true)
    List<String> getAllThnAng();

    @Query(value = "select distinct kd_lokasi from t_masteru order by kd_lokasi", nativeQuery = true)
    List<String> getAllLokasi();

    @Query(value = "SELECT count(*) FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn) AND IF(:lok = '', TRUE, kd_lokasi = :lok)",
            nativeQuery = true)
    int getTotalData(@Param("thn") String tahun, @Param("lok") String lokasi);

}
