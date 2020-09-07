package id.app.amira.migrasidata.repo.simkeu;

import id.app.amira.migrasidata.model.Kppn;
import id.app.amira.migrasidata.model.Upb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUpbSimkeuRepository extends JpaRepository<Upb, String> {
    @Query(value = "SELECT * FROM t_upb LIMIT :start, :length",
            nativeQuery = true)
    List<Upb> getDataByParameter(@Param("start") int start, @Param("length") int length);

    @Query(value = "SELECT count(*) FROM t_upb",
            nativeQuery = true)
    int getTotalData();
}
