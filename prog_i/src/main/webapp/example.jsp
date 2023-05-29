<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<title>Lista Articulos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> 
</head>
<body>
	<nav class="navbar navbar-dark bg-dark fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Bienvenido ${sessionScope.usuario.nombre} a Programacion I</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="offcanvas" data-bs-target="#offcanvasDarkNavbar"
				aria-controls="offcanvasDarkNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1"
				id="offcanvasDarkNavbar" aria-labelledby="offcanvasDarkNavbarLabel">
				<div class="offcanvas-header">
					<h5 class="offcanvas-title" id="offcanvasDarkNavbarLabel">Administrar</h5>
					<button type="button" class="btn-close btn-close-white"
						data-bs-dismiss="offcanvas" aria-label="Close"></button>
				</div>
				<div class="offcanvas-body">
					<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="#">Inicio</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="articulo?action=mostrar">Mostrar Articulos</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="articulo?action=nuevo">Nuevo Articulo</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="usuario?tipo=cerrarSesion">Cerrar Sesion</a></li>
						<li class="nav-item"><a class="nav-link active" aria-current="page" href="articulo?action=example">Example</a></li>
						
					</ul>
				</div>				
			</div>
		</div>
	</nav>
	<p></p>
	<p></p>
	<p></p>
	<p></p>
	<p></p>
	<div class="container-fluid">
            <h1>La clase columna</h1>
     <input type="button" onclick="history.back()" name="volver atrás" value="Atrás">
     <p></p>
            <p>Lista de Articulos</p>
        </div>
        <div class="container-fluid">
            <h2></h2>
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <!-- <th>Id</th>-->
                            <th>Codigo</th>
							<th>Nombre</th>
							<th>Descripcion</th>
							<th>Existencia</th>
							<th>Precio</th>
							<th colspan=2>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="articulo" items="${lista}">
							<tr>
								<!--<td><c:out value="${articulo.idarticulo}"/></td>-->
								<td><c:out value="${articulo.codigo}"/></td>
								<td><c:out value="${articulo.nombre}"/></td>
								<td><c:out value="${articulo.descripcion}"/></td>
								<td><c:out value="${articulo.existencia}"/></td>
								<td><c:out value="${articulo.precio}"/></td>
								<td><a href="articulo?action=showedit&id=<c:out value="${articulo.idarticulo}" />">Editar</a></td>
								<td><a href="articulo?action=eliminar&id=<c:out value="${articulo.idarticulo}"/>">Eliminar</a> </td>				
							</tr>
						</c:forEach>
                    </tbody>
                </table>
            </div> 
        </div>
		<table>
		<tr>
		</tr>
	</table>
</body>