package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.CompositeId;
import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ISimkeuRepository extends JpaRepository<MasterU, CompositeId> {

    @Query(value = "SELECT * FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn) LIMIT :start, :length",
            nativeQuery = true)
    List<MasterU> getDataByParameter(@Param("start") int start, @Param("length") int length,
                                     @Param("thn") String parameter);

    @Query(value = "select distinct thn_ang from t_masteru order by thn_ang", nativeQuery = true)
    List<String> getAllThnAng();

    @Query(value = "SELECT count(*) FROM t_masteru WHERE IF(:thn = '', TRUE, thn_ang = :thn)",
            nativeQuery = true)
    int getTotalData(@Param("thn") String parameter);

}
