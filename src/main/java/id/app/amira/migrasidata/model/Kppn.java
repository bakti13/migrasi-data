package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_kppn")
@Data
public class Kppn {
    @Id
    @Setter
    @Getter
    @Column(name = "kdkppn")
    private String kdkppn;

    @Setter
    @Getter
    @Column(name = "urkppn")
    private String urkppn;

    @Setter
    @Getter
    @Column(name = "kdlokasi")
    private String kdlokasi;

    @Setter
    @Getter
    @Column(name = "alamat")
    private String alamat;
}
