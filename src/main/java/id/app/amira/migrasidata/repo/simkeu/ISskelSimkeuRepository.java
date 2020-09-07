package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.Sskel;
import id.app.amira.migrasidata.model.Upb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISskelSimkeuRepository extends JpaRepository<Sskel, String> {
    @Query(value = "SELECT * FROM t_sskel LIMIT :start, :length",
            nativeQuery = true)
    List<Sskel> getDataByParameter(@Param("start") int start, @Param("length") int length);

    @Query(value = "SELECT count(*) FROM t_sskel",
            nativeQuery = true)
    int getTotalData();
}
