package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.Kpknl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IKpknlSimkeuRepository extends JpaRepository<Kpknl, String> {
    @Query(value = "SELECT * FROM t_kpknl LIMIT :start, :length",
            nativeQuery = true)
    List<Kpknl> getDataByParameter(@Param("start") int start, @Param("length") int length);

    @Query(value = "SELECT count(*) FROM t_kpknl",
            nativeQuery = true)
    int getTotalData();
}
