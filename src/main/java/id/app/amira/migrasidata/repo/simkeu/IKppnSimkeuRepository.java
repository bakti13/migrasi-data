package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.Kppn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IKppnSimkeuRepository extends JpaRepository<Kppn, String> {
    @Query(value = "SELECT * FROM t_kppn LIMIT :start, :length",
            nativeQuery = true)
    List<Kppn> getDataByParameter(@Param("start") int start, @Param("length") int length);

    @Query(value = "SELECT count(*) FROM t_kppn",
            nativeQuery = true)
    int getTotalData();
}
