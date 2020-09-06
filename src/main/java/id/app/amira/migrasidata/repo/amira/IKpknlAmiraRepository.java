package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.Kpknl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKpknlAmiraRepository extends JpaRepository<Kpknl, String> {
}
