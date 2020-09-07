package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_sskel")
@Data
public class Sskel {

    @Id
    @Setter
    @Getter
    @Column(name = "kd_brg")
    private String kdbrg;

    @Setter
    @Getter
    @Column(name = "kd_gol")
    private String kdgol;

    @Setter
    @Getter
    @Column(name = "kd_bid")
    private String kdbid;

    @Setter
    @Getter
    @Column(name = "kd_kel")
    private String kdkel;

    @Setter
    @Getter
    @Column(name = "kd_skel")
    private String kdskel;

    @Setter
    @Getter
    @Column(name = "kd_sskel")
    private String kdsskel;

    @Setter
    @Getter
    @Column(name = "satuan")
    private String satuan;

    @Setter
    @Getter
    @Column(name = "ur_sskel")
    private String ursskel;

    @Setter
    @Getter
    @Column(name = "kd_perk")
    private String kdperk;

    @Setter
    @Getter
    @Column(name = "dasar")
    private String dasar;

    @Setter
    @Getter
    @Column(name = "kdperkbr")
    private String kdperkbr;

}
