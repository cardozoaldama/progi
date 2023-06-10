<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<title>Editar Articulos</title>
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
 <!-- Incluye la cabecera -->
    <%@ include file="header.jsp"%>
	<p></p>
	<p></p>
	<p></p>
	<p></p>
	<p></p>
	<h1>La clase columna</h1>
	<input type="button" onclick="history.back()" name="volver atrás" value="Atrás">
     <p></p>
	<h1>Editar Artículo</h1>
	<form action="articulo?action=editar" method="post" >
		<table>
			<tr>
				<td><label></label></td>
				<td><input type="hidden" name="id" value="<c:out value="${articulo.idarticulo}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Código</label></td>
				<td><input type="text" name="codigo" value='<c:out value="${articulo.codigo}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre" value='<c:out value="${articulo.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Descripción</label></td>
				<td><input type="text" name="descripcion" value='<c:out value="${articulo.descripcion}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Existencia</label></td>
				<td><input type="text" name="existencia" value='<c:out value="${articulo.existencia }"></c:out>' ></td>
			</tr>
			
			<tr>
				<td><label>Precio</label></td>
				<td><input type="text" name="precio" value='<c:out value="${articulo.precio }"></c:out>' ></td>
			</tr>
		</table>
		<tr>
		<td><input type="submit" value="Actualizar" name="agregar" onclick="limpiarCampos()"></td>	
		<td><input type="button" onclick="redirigirPrincipal()" value="Cancelar" name="cancelar" /></td>	
		</tr>
	</form>
	
	<%-- Verificar si hay un mensaje en la solicitud y mostrarlo --%>
	<c:if test="${not empty requestScope.mensaje}">
	    <div class="alert alert-success" role="alert">
	        ${requestScope.mensaje}
	    </div>
	</c:if>

</body>

<script>
function limpiarCampos() {
	document.getElementById("codigo").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("descripcion").value = "";
    document.getElementById("cantidad").value = "";
    document.getElementById("precio").value = "";
    // Resto de los campos de texto
}
</script>

<script>
function redirigirPrincipal() {
    window.location.href = "principal.jsp";
}
</script>

</html>