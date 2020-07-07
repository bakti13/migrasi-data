<!DOCTYPE html>
<html>
<head>
    <title>View Master</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <#--    <link rel="stylesheet" href="css/style.css">-->
    <style>
        h2 {color: blue}

        td:nth-child(3) {
            text-align: right;
        }
    </style>
</head>
<body>
<h2>List of cities</h2>
<div>
    <a href="migrasi">migrasi data</a>
</div>
<table>
    <tr>
        <th>Tahun Anggaran</th>
        <th>Periode</th>
        <th>lokasi</th>
        <th>No Sppa</th>
    </tr>
    <#if masters?size != 0>
        <#list masters as master>
            <tr>
                <td>${master.thnAng}</td>
                <td>${master.periode}</td>
                <td>${master.kdLokasi}</td>
                <td>${master.noSppa}</td>
            </tr>
        </#list>
    </#if>
</table>

<table>
    <tr>
        <th>Tahun Anggaran</th>
        <th>Periode</th>
        <th>lokasi</th>
        <th>No Sppa</th>
    </tr>

    <#list aMasters as amira>
        <tr>
            <td>${amira.thnAng}</td>
            <td>${amira.periode}</td>
            <td>${amira.kdLokasi}</td>
            <td>${amira.noSppa}</td>
        </tr>
    </#list>
</table>

</body>
</html>