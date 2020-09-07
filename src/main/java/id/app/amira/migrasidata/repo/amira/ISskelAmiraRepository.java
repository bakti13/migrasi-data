package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.Sskel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISskelAmiraRepository extends JpaRepository<Sskel, String> {
}
