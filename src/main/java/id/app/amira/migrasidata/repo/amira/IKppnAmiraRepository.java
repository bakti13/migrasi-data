package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.Kppn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IKppnAmiraRepository extends JpaRepository<Kppn, String> {
}
