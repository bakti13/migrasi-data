package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.CompositeId;
import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ISimkeuRepository extends JpaRepository<MasterU, CompositeId> {

    @Query(value = "SELECT * from t_masteru LIMIT 5 ", nativeQuery=true)
    List<MasterU> getAllData();

    @Query(value="SELECT * FROM t_masteru WHERE CASE WHEN :thn = '' THEN 1 = 1 ELSE thn_ang = :thn END LIMIT :start, :length",
             nativeQuery=true)
    List<MasterU> getDataByParameter(@Param("start") int start, @Param("length")int length,
                                     @Param("thn") String parameter);


}
