package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_croleh")
@Data
public class JenisTransaksi {

    @Id
    @Setter
    @Getter
    @Column(name = "jns_trn")
    private String jnsTrans;

    @Setter
    @Getter
    @Column(name = "ur_trn")
    private String urTrans;
}
