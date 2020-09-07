package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.Upb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUpbAmiraRepository extends JpaRepository<Upb, String> {
}
