package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAmiraRepository extends JpaRepository<MasterU,Long> {
    @Query(value = "SELECT * from t_masteru ", nativeQuery=true)
    List<MasterU> getAllData();
}
