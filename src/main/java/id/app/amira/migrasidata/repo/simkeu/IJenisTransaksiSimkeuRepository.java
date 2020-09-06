package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.JenisTransaksi;
import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IJenisTransaksiSimkeuRepository extends JpaRepository<JenisTransaksi, String> {

    @Query(value = "SELECT * FROM t_croleh LIMIT :start, :length",
            nativeQuery = true)
    List<JenisTransaksi> getDataByParameter(@Param("start") int start, @Param("length") int length);

    @Query(value = "SELECT count(*) FROM t_croleh",
            nativeQuery = true)
    int getTotalData();
}
