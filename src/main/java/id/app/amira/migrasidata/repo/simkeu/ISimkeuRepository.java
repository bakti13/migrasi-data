package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISimkeuRepository extends JpaRepository<MasterU, Long> {

    @Query(value = "SELECT * from t_masteru LIMIT 5 ", nativeQuery=true)
    List<MasterU> getAllData();

//    @Query(value = "SELECT thn_ang, periode, kd_lokasi, no_sppa from t_masteru LIMIT 5 ", nativeQuery=true)
//    List<MasterU> getDataByParam();


}
