package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.JenisTransaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJenisTransaksiAmiraRepository extends JpaRepository<JenisTransaksi, String> {
}
