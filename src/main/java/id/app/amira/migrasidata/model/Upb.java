package id.app.amira.migrasidata.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "t_upb")
@Data
public class Upb {

    @Id
    @Setter
    @Getter
    @Column(name = "kdlok")
    private String kdlok;

    @Setter
    @Getter
    @Column(name = "kd_pebin")
    private String kdpebin;

    @Setter
    @Getter
    @Column(name = "kd_pbi")
    private String kdpbi;

    @Setter
    @Getter
    @Column(name = "kd_ppbi")
    private String kdppbi;

    @Setter
    @Getter
    @Column(name = "kd_upb")
    private String kdupb;

    @Setter
    @Getter
    @Column(name = "kd_subupb")
    private String kdsubupb;

    @Setter
    @Getter
    @Column(name = "kd_jk")
    private String kdjk;

    @Setter
    @Getter
    @Column(name = "ur_upb")
    private String urupb;

}
