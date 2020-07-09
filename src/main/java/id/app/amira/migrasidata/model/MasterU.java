package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "t_masteru")
@IdClass(CompositeId.class)
@Data
public class MasterU {

    @Id
    @Setter
    @Getter
    @Column(name = "thn_ang")
    private String thnAng;

    @Id
    @Setter
    @Getter
    @Column(name = "periode")
    private String periode;

    @Id
    @Setter
    @Getter
    @Column(name = "kd_lokasi")
    private String kdLokasi;

    @Id
    @Setter
    @Getter
    @Column(name = "no_sppa")
    private String noSppa;

    @Id
    @Setter
    @Getter
    @Column(name = "kd_brg")
    private String kdBrg;

    @Id
    @Setter
    @Getter
    @Column(name = "no_aset")
    private String noAset;

    @Id
    @Setter
    @Getter
    @Column(name = "tgl_perlh")
    @Temporal(TemporalType.DATE)
    private Date tglPerlh;

    @Id
    @Setter
    @Getter
    @Column(name = "tercatat")
    private String tercatat;

    @Id
    @Setter
    @Getter
    @Column(name = "kondisi")
    private String kondisi;

    @Id
    @Setter
    @Getter
    @Column(name = "tgl_buku")
    @Temporal(TemporalType.DATE)
    private Date tglBuku;

    @Id
    @Setter
    @Getter
    @Column(name = "jns_trn")
    private String jnsTrn;

    @Id
    @Setter
    @Getter
    @Column(name = "dsr_hrg")
    private String dsrHrg;

    @Id
    @Setter
    @Getter
    @Column(name = "kd_data")
    private String kdData;

    @Id
    @Setter
    @Getter
    @Column(name = "flag_sap")
    private String flagSap;

    @Id
    @Setter
    @Getter
    @Column(name = "kuantitas")
    private Double kuantitas;

    @Id
    @Setter
    @Getter
    @Column(name = "rph_sat")
    private Double rphSat;

    @Id
    @Setter
    @Getter
    @Column(name = "rph_aset")
    private Double rphAset;

    @Id
    @Setter
    @Getter
    @Column(name = "flag_kor")
    private String flagKor;

    @Id
    @Setter
    @Getter
    @Column(name = "Keterangan")
    private String keterangan;

    @Id
    @Setter
    @Getter
    @Column(name = "merk_type")
    private String merkType;

    @Id
    @Setter
    @Getter
    @Column(name = "asal_perlh")
    private String asalPerlh;

    @Id
    @Setter
    @Getter
    @Column(name = "no_bukti")
    private String noBukti;

    @Id
    @Setter
    @Getter
    @Column(name = "no_dsr_mts")
    private String noDsrMts;


    @Setter
    @Getter
    @Column(name = "tgl_dsr_mts")
    @Temporal(TemporalType.DATE)
    private Date tglDsrMts;

    @Id
    @Setter
    @Getter
    @Column(name = "flag_ttp")
    private String flagTtp;

    @Id
    @Setter
    @Getter
    @Column(name = "flag_krm")
    private String flagKrm;

    @Id
    @Setter
    @Getter
    @Column(name = "kdblu")
    private String kdBlu;

    @Id
    @Setter
    @Getter
    @Column(name = "setatus")
    private String status;

    @Id
    @Setter
    @Getter
    @Column(name = "noreg")
    private String noReg;

    @Id
    @Setter
    @Getter
    @Column(name = "kdbapel")
    private String kdBapel;

    @Id
    @Setter
    @Getter
    @Column(name = "kdKpknl")
    private String kdKpknl;

    @Id
    @Setter
    @Getter
    @Column(name = "umeko")
    private Double umeko;

    @Id
    @Setter
    @Getter
    @Column(name = "rph_res")
    private Double rphRes;

    @Id
    @Setter
    @Getter
    @Column(name = "kdkppn")
    private String kdKppn;

    @Setter
    @Getter
    @Column(name = "versi")
    private String versi;

    @Setter
    @Getter
    @Column(name = "kdperkd")
    private String kdPerKd;

    @Setter
    @Getter
    @Column(name = "kdperkk")
    private String kdPerKk;

    @Setter
    @Getter
    @Column(name = "no_aset2")
    private String noAset2;
}
