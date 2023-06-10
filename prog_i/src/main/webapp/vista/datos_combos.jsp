<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<title>Listas</title>
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
	<h1>Datos Combos</h1>
        <form style="margin: auto; display: table" method="GET" id="form">
        <input type="hidden" name="idDepartamento" id="idDepartamento" /> 
            <fieldset>
                <br/>
				<label>Seleccione el departamento</label>
				<select name="departamentos" id="idDepartamento">
				    <option value="" selected>Seleccionar</option>
				    <c:forEach var="departamento" items="${listaDepartamentos}">
				        <option value="${departamento.id_departamento}">${departamento.nombre}</option>
				    </c:forEach>
				</select>
				
				<label>Seleccione la ciudad</label>
				<select name="ciudades" id="ciudades">
				    <option value="" selected>Seleccionar</option>
				    <c:forEach var="ciudad" items="${listaCiudades}">
				        <option value="${ciudad.id_ciudad}" data-departamento="${ciudad.id_departamento}">${ciudad.nombre}</option>
				    </c:forEach>
				</select>
                <br/>    
                <br/><p style="text-align: center;">
                    <button type="submit">Agregar</button>
                </p>               
            </fieldset>
        </form>
    </body>

<script>
  document.getElementById("idDepartamento").addEventListener("change", function() {
    var selectedDepartment = this.value;
    document.getElementById("idDepartamento").value = selectedDepartment;
  });
</script>    

<script>
	$(document).ready(function() {
	    $('#idDepartamento').on('change', function() {
	        $('#form').submit();
	
	        // Realizar una solicitud AJAX para obtener la lista de ciudades
	        $.ajax({
	            url: '/obtenerCiudades', // Ruta de tu servlet que obtiene las ciudades por departamento
	            method: 'POST',
	            data: { idDepartamento: this.value },
	            success: function(response) {
	                // Limpiar el combo de ciudades
	                $('#ciudades').empty();
	
	                // Agregar las opciones de ciudades al combo
	                $.each(response, function(index, ciudad) {
	                    $('#ciudades').append('<option value="' + ciudad.id_ciudad + '">' + ciudad.nombre + '</option>');
	                });
	            },
	            error: function(xhr, status, error) {
	                console.log(error); // Verificar el error en la consola
	                // Manejar los errores de la solicitud AJAX si es necesario
	            }
	        });
	    });
	});
</script>

</html>