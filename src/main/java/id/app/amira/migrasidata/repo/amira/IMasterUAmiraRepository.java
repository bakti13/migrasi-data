package id.app.amira.migrasidata.repo.amira;

import id.app.amira.migrasidata.model.MasterUCompositeId;
import id.app.amira.migrasidata.model.MasterU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMasterUAmiraRepository extends JpaRepository<MasterU, MasterUCompositeId> {
    @Query(value = "SELECT * from t_masteru ", nativeQuery = true)
    List<MasterU> getAllData();

    @Procedure(procedureName = "GenerateViewMasterU")
    int createViewMasterU();

    /*@Query(value = "SELECT COUNT(thn_ang) FROM t_masteru WHERE " +
            " thn_ang = :#{#data.thnAng} AND periode = :#{#data.periode} AND kd_lokasi = :#{#data.kdLokasi} AND " +
            " no_sppa = :#{#data.noSppa} AND kd_brg = :#{#data.kdBrg} AND no_aset = :#{#data.noAset} AND " +
            " tgl_perlh = :#{#data.tglPerlh} AND tercatat = :#{#data.tercatat} AND  kondisi = :#{#data.kondisi} AND " +
            " tgl_buku = :#{#data.tglBuku} AND jns_trn = :#{#data.jnsTrn} AND dsr_hrg = :#{#data.dsrHrg} AND " +
            " kd_data = :#{#data.kdData} AND flag_sap = :#{#data.flagSap} AND kuantitas = :#{#data.kuantitas} AND " +
            " rph_sat = :#{#data.rphSat} AND rph_aset = :#{#data.rphAset} AND flag_kor = :#{#data.flagKor} AND " +
            " keterangan = :#{#data.keterangan} AND merk_type = :#{#data.merkType} AND asal_perlh = :#{#data.asalPerlh} AND " +
            " no_bukti = :#{#data.noBukti} AND no_dsr_mts = :#{#data.noDsrMts} AND tgl_dsr_mts = :#{#data.tglDsrMts} AND " +
            " flag_ttp = :#{#data.flagTtp} AND flag_krm = :#{#data.flagKrm} AND kdblu = :#{#data.kdBlu} AND " +
            " setatus = :#{#data.status} AND noreg = :#{#data.noReg} AND kdbapel = :#{#data.kdBapel} AND " +
            " kdkpknl = :#{#data.kdKpknl} AND umeko = :#{#data.umeko} AND rph_res = :#{#data.rphRes} AND " +
            " kdkppn = :#{#data.kdKppn} AND versi = :#{#data.versi} AND kdperkd = :#{#data.kdPerKd} AND " +
            " kdperkk = :#{#data.kdPerKk} AND no_aset2 = :#{#data.noAset2} ", nativeQuery = true)
    int isFound(@Param("data") MasterU data);*/
}
