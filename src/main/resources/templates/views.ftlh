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

<table>
    <tr>
        <th>Tahun Anggaran</th>
        <th>Periode</th>
        <th>lokasi</th>
        <th>No Sppa</th>
    </tr>

    <#list masters as master>
        <tr>
            <td>${master.thnAng}</td>
            <td>${master.periode}</td>
            <td>${master.kdLokasi}</td>
            <td>${master.noSppa}</td>
        </tr>
    </#list>
</table>

</body>
</html>