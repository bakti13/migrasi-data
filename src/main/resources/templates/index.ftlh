<!DOCTYPE html>
<html lang="">
<head>
    <title>MIGRASI DATA</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#--  import css  -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="sweetalert2/dist/sweetalert2.min.css" rel="stylesheet">
    <link href="datatables.net-bs4/css/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body style="background-color: #6c757d">
<div class="container" style="padding-top: 5%">
    <div class="card">
        <div class="card-body">
            <div class="row">
                <div class="col-md">
                    <div class="row">
                        <label for="ThnAng" class="col-sm-2 col-form-label font-weight-bold">Tahun Anggaran:</label>
                        <select class="custom-select col-sm-3" id="ThnAng"></select>
                        <label for="Lokasi" class="col-sm-2 col-form-label font-weight-bold">Lokasi:</label>
                        <select class="custom-select col-sm-3" id="Lokasi"></select>
                        <button id="Load" type="button" class="float-left btn btn-info" onclick="LoadData()">Load
                        </button>
                        <button id="btnMigrasiData" type="button" class="float-right btn btn-success"
                                onclick="migrasiData()">
                            Migrasi Data
                        </button>
                    </div>
                    <hr class="col-sm-12">
                </div>
            </div>
            <br>
            <div class="table-responsive m-t-40" style="font-size: 11px;">
                <table id="MasterTable" class="table table-bordered table-striped">
                    <thead>
                    <tr class="bg-success text-white">
                        <th class="text-center">Tahun Anggaran</th>
                        <#--                        <th class="text-center">Periode</th>-->
                        <th class="text-center">Lokasi</th>
                        <th class="text-center">No Sppa</th>
                        <th class="text-center">Kode Barang</th>
                        <th class="text-center">No Aset</th>
                        <th class="text-center">Tanggal Perolehan</th>
                        <#--                        <th class="text-center">Tercatat</th>-->
                        <th class="text-center">Kondisi</th>
                        <#--                        <th class="text-center">Tangal Buku</th>
                                                <th class="text-center">Jenis Trn</th>
                                                <th class="text-center">Dsr Hrg</th>
                                                <th class="text-center">Kode Data</th>
                                                <th class="text-center">Flag Sap</th>
                                                <th class="text-center">Kuantitas</th>
                                                <th class="text-center">Rph Sat</th>
                                                <th class="text-center">Rph Aset</th>
                                                <th class="text-center">Flag Kor</th>
                                                <th class="text-center">Keterangan</th>
                                                <th class="text-center">Merk Type</th>
                                                <th class="text-center">Asal Perlh</th>
                                                <th class="text-center">No Bukti</th>
                                                <th class="text-center">No Dsr Mts</th>
                                                <th class="text-center">Tanggal Dsr Mts</th>
                                                <th class="text-center">Flag Ttp</th>
                                                <th class="text-center">Flag Krm</th>
                                                <th class="text-center">KdBlu</th>
                                                <th class="text-center">Status</th>
                                                <th class="text-center">Noreg</th>
                                                <th class="text-center">KdBapel</th>
                                                <th class="text-center">KdKpknl</th>
                                                <th class="text-center">Umeko</th>
                                                <th class="text-center">Rph Res</th>
                                                <th class="text-center">Kdkppn</th>
                                                <th class="text-center">Versi</th>
                                                <th class="text-center">KdPerKd</th>
                                                <th class="text-center">KdPerKK</th>
                                                <th class="text-center">no Aset2</th>-->
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
<script src="jquery/jquery.min.js"></script>
<script src="datatables.net/js/jquery.dataTables.min.js"></script>
<script src="datatables.net-bs4/js/dataTables.responsive.min.js"></script>
<!-- Sweet-Alert  -->
<script src="sweetalert2/dist/sweetalert2.all.min.js"></script>

<script>

    let thnAng = "-";
    let lokasi = "-";
    $.get("${baseUrl}simkeu/get-all-thn-ang", function (data) {
        let html = '<option value="">All</option>';
        for (let i = 0; i < data.length; i++) {
            html += '<option value=' + data[i] + '>' + data[i] + '</option>';
        }
        // html += '<option value="all">All</option>';
        $('#ThnAng').html(html);
    });

    $.get("${baseUrl}simkeu/get-all-lokasi", function (data) {
        let html = '<option value="">All</option>';
        for (let i = 0; i < data.length; i++) {
            html += '<option value=' + data[i].kode + '>' + data[i].nama + '</option>';
        }
        // html += '<option value="all">All</option>';
        $('#Lokasi').html(html);
    });

    function LoadData() {
        thnAng = $('#ThnAng').val();
        console.log(thnAng);
        lokasi = $('#Lokasi').val();
        console.log(lokasi);
        masterTable.ajax.reload();
        // if (validation()) {
        // }
    }

    function validation() {
        /*if(! $('#ThnAng').val() )
        {
            valid = false;
            Swal.fire({
                type: 'error',
                title: 'Mandatori',
                text: 'Tahun tidak boleh kosong'
            })
        }
        if(! $('#Lokasi').val() )
        {
            valid = false;
            Swal.fire({
                type: 'error',
                title: 'Mandatori',
                text: 'Lokasi tidak boleh kosong'
            })
        }*/
        return true;
    }


    function migrasiData() {

        const swalWithBootstrapButtons = Swal.mixin({
            customClass: {
                confirmButton: 'btn btn-success',
                cancelButton: 'btn btn-danger'
            },
            buttonsStyling: true
        });

        let text = "Apakah anda yakin ?";

        if (validation()) {
            swalWithBootstrapButtons.fire({
                title: 'Migrasi Data',
                text: text,
                type: 'warning',
                showCancelButton: true,
                confirmButtonText: 'Ya',
                cancelButtonText: 'Tidak, Kembali',
            }).then((result) => {
                if (result.value) {
                    Swal.fire({
                        title: 'Proses migrasi data..',
                        allowEscapeKey: false,
                        allowOutsideClick: false,
                        onOpen: () => {
                            Swal.showLoading();
                        }
                    });
                    $.ajax({
                        url: "${baseUrl}simkeu/migrasi-data?thnAng=" + thnAng + "&lokasi=" + lokasi,
                        type: "POST",
                        contentType: "application/json",
                        dataType: 'json'
                    }).done(function () {
                        swalWithBootstrapButtons.fire({
                            type: 'success',
                            title: 'Migrasi Data',
                            text: 'Migrasi Data Berhasil'
                        });
                        location.reload();
                    }).fail(function () {
                        Swal.fire({
                            type: 'error',
                            title: 'Tambah Data',
                            text: 'Tambah Data Gagal. Silahkan coba kembali.'
                        })
                    });
                } else if (
                    /* Read more about handling dismissals below */
                    result.dismiss === Swal.DismissReason.cancel
                ) {
                    swalWithBootstrapButtons.fire(
                        'Batal',
                        'Batal Migrasi Data',
                        'error'
                    )
                }
            });
        }
    }


    const masterTable = $('#MasterTable').DataTable({
        "Dom": 'RlfrtlipB',
        "processing": true,
        "serverSide": true,
        "lengthMenu": [10, 50, 100, 250, 500, 1000],
        "bFilter": true,
        "scrollX": true,
        "ordering": false,
        "ajax": {
            "url": "${baseUrl}simkeu/all-datatable",
            "type": "POST",
            "data": function (d) {
                d.thnAng = thnAng;
                d.lokasi = lokasi;
            }
        },
        "columns": [
            {"data": "thnAnggaran"},
            // {"data": "periode"},
            {"data": "lokasi"},
            {"data": "noSppa"},
            {"data": "kdBarang"},
            {"data": "noAset"},
            {"data": "tglPeroleh"},
            // {"data": "tercatat"},
            {"data": "kondisi"},
            // {"data": "tglBuku"},
            // {"data": "jnsTrn"},
            // {"data": "dsrHrg"},
            // {"data": "kdData"},
            // {"data": "flagSap"},
            // {"data": "kuantitas"},
            // {"data": "rphSat"},
            // {"data": "rphAset"},
            // {"data": "flagKor"},
            // {"data": "keterangan"},
            // {"data": "merkType"},
            // {"data": "asalPerlh"},
            // {"data": "noBukti"},
            // {"data": "noDsrMts"},
            // {"data": "tglDsrMts"},
            // {"data": "flagTtp"},
            // {"data": "flagKrm"},
            // {"data": "kdBlu"},
            // {"data": "status"},
            // {"data": "noReg"},
            // {"data": "kdBapel"},
            // {"data": "kdKpknl"},
            // {"data": "umeko"},
            // {"data": "rphRes"},
            // {"data": "kdKppn"},
            // {"data": "versi"},
            // {"data": "kdPerKd"},
            // {"data": "kdPerKk"},
            // {"data": "noAset2"}
        ],
        // "columnDefs": [
        //     {
        //         // "searchable": false,
        //         "orderable": false,
        //         "targets": 0
        //     }
        // ],
        language: {
            "decimal": "",
            "emptyTable": "Tidak ada data yang ditemukan",
            "info": "Menampilkan _START_ sd _END_ dari _TOTAL_ Entri",
            "infoEmpty": "Menampilkan 0 sd 0 dari 0 Entri",
            "infoFiltered": "(filtered from _MAX_ total entries)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Tampilkan _MENU_",
            "loadingRecords": "Mengambil data...",
            "processing": "Memproses...",
            "search": "Cari:",
            "zeroRecords": "Tidak ada data yang ditemukan",
            "paginate": {
                "first": "Pertama",
                "last": "Terakhir",
                "next": "Selanjutnya",
                "previous": "Sebelumnya"
            }
        }
    });
</script>

</html>