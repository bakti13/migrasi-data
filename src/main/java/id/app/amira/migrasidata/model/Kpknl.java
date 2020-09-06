package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_kpknl")
@Data
public class Kpknl {
    @Id
    @Setter
    @Getter
    @Column(name = "kdkpknl")
    private String kdkpknl;

    @Setter
    @Getter
    @Column(name = "urkpknl")
    private String urkpknl;

    @Setter
    @Getter
    @Column(name = "kdlokasi")
    private String kdlokasi;

    @Setter
    @Getter
    @Column(name = "alamat")
    private String alamat;
}
