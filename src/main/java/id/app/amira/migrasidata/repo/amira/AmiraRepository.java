package id.app.amira.migrasidata.repo.amira;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AmiraRepository {

    @Autowired
    @Getter
    IMasterUAmiraRepository masterU;

    @Autowired
    @Getter
    IJenisTransaksiAmiraRepository jenisTransaksi;

    @Autowired
    @Getter
    IKpknlAmiraRepository kpknl;
}
