package id.app.amira.migrasidata.repo.simkeu;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimkeuRepository {
    @Autowired
    @Getter
    IMasterUSimkeuRepository masterU;

    @Autowired
    @Getter
    IJenisTransaksiSimkeuRepository jenisTrans;

    @Autowired
    @Getter
    IKpknlSimkeuRepository kpknl;

    @Autowired
    @Getter
    IKppnSimkeuRepository kppn;

    @Autowired
    @Getter
    IUpbSimkeuRepository upb;

    @Autowired
    @Getter
    ISskelSimkeuRepository sskel;
}
