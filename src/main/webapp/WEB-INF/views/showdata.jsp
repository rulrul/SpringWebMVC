<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>RCollection :: SpringWebMVC</title>
		
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css' />" />
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/bootstrap-theme.min.css' />" />
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/jquery.dataTables.min.css' />" />
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/dataTables.bootstrap.min.css' />" />
		<link rel="stylesheet" href="<c:url value='/resources/bootstrap/css/rcollections.css' />" />

	</head>
	<body>
		
		<div class="container">
			<h3 class="text-center header-font">www.heyrul.com</h3>
			
			<div class="row">
				<div class="col-sm-12">
					<div class="panel panel-default">
						<div class="panel-body">
							
							<div class="form-group col-sm-5">
								<!--  <button id="tambah-data" class="btn btn-primary">Tambah Data</button> -->
								<a href="#addkaryawanDialog" class="btn btn-primary" data-toggle="modal">Tambah Data</a>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			
			<table id="maintable" class="display" cellspacing="0" width="100%">
				<thead bgcolor="#fff">
					<tr>
						<th>NIP</th>
						<th>Nama</th>
						<th>Jabatan</th>
						<th>Gaji</th>
						<th>Alamat</th>
						<th>Opsi</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${karyawanData}" var="data">
					<tr>
						<td><c:out value="${data.nip}"/></td>
						<td><c:out value="${data.nama}"/></td>
						<td><c:out value="${data.jabatan}"/></td>
						<td><c:out value="${data.gaji}"/></td>
						<td><c:out value="${data.alamat}"/></td>
						<td align="center"><a href="#" id="ubah" class="btn btn-primary btn-sm">Ubah</a> <a href="/deletekaryawandata?nip=<c:out value='${data.nip}'/>" id="hapus" class="btn btn-danger btn-sm">Hapus</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div><!-- Container:: End -->
		
		<!-- Add-Karyawan-Modal-Dialog -->
		<form id="addkaryawanform" method="POST" action="insertkaryawandata">
		<div id="addkaryawanDialog" class="modal fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    	<h4 class="modal-title">Tambah Data Karyawan</h4>
					</div>
					<div class="modal-body">
							<div class="form-group col-lg-6">
								<input class="form-control" type="text" name="nip" value="" placeholder="Masukkan nomor induk pegawai..">
							</div>
							<div class="form-group col-lg-6">
								<input class="form-control" type="text" name="nama" value="" placeholder="Masukkan nama karyawan..">
							</div>
							<div class="form-group col-lg-6">
								<input class="form-control" type="text" name="jabatan" value="" placeholder="Masukkan jabatan..">
							</div>
							<div class="form-group col-lg-6">
								<input class="form-control" type="password" name="gaji" value="" placeholder="Masukkan gaji..">
							</div>
							<div class="form-group col-lg-12">
								<input class="form-control" type="text" name="alamat" value="" placeholder="Masukkan alamat..">
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Tutup</button>
                    	<button type="submit" class="btn btn-primary">Tambah Data</button>
					</div>
				</div>
			</div>
		</div> <!-- END:: Add-Karyawan-Modal-Dialog -->
		</form>
		
		<!--
		<footer class="footer">
			<div class="container">
				<span class="text-muted pull-right">www.heyrul.com-2017</span>
			</div>
		</footer>
		-->
		
		<!-- Javascript -->
		<script src="<c:url value='/resources/bootstrap/js/jquery.min.js' />"></script>
		<script src="<c:url value='/resources/bootstrap/js/bootstrap.min.js' />"></script>
		<script src="<c:url value='/resources/bootstrap/js/jquery.dataTables.min.js' />"></script>
		<script src="<c:url value='/resources/bootstrap/js/dataTables.bootstrap.min.js' />"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				// $('#maintable').DataTable(); // Default Configuration
				$('#maintable').DataTable( {
					"searching": false,
					"ordering": true,
					"info": false,
					"lengthMenu": [5,10, 25, 50, 75, 100],
					"paging": true,
					"language": {
						// "url": "bootstrap/lang/DataTablesIndo.json"
						"sLengthMenu": "Tampilkan _MENU_ Data",
						"sEmptyTable": "Data Tidak Tersedia",
						"oPaginate": {
							"sFirst":    "First",
							"sLast":     "Last",
							"sNext":     ">>",
							"sPrevious": "<<"
						}
					}
				});
				
			});
			
			// To-give-border-for-the-table
			$('#maintable').removeClass('display').addClass('table table-striped table-bordered');
			
			// Add-User-Submit
			$("#addkaryawanform").submit(function(e) {
				var url = "insertkaryawandata";
				
				$.ajax({
					type: "POST",
					url: url,
					data: $("#addkaryawanform").serialize(), // serialiize the form's elments
					success: function(data) {
						// $("#maintable").ajax.reload(null, false); // reload table buat data json
						$("#adduserDialog").modal("hide"); // close modal
					}
				});
				
				e.preventDefault(); // 
			});
		</script>
	</body>
</html>
