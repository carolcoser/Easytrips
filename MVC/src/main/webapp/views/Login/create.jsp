<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Login" import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css"
	rel="stylesheet">
<title>Easytrips | Cadastrar Login</title>
</head>
<body>

	<main>
		<header class="header">
			<h1 class="text-center" style="background-color: #FFA500">
				<img
					src="https://img.icons8.com/external-flaticons-lineal-color-flat-icons/64/000000/external-trip-vacation-planning-flaticons-lineal-color-flat-icons.png" />Easytrips
			</h1>
		</header>

		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="./index.html">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./views/Clientes/index.jsp">Clientes</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./views/Compras/index.jsp">Compras</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./views/Destinos/index.jsp">Destinos</a></li>
			<li class="nav-item"><a class="nav-link"
				href="./views/Hoteis/index.jsp">Hotéis</a></li>
			<li class="nav-item"><a class="nav-link" href="index.jsp">Permissões/Login</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Pacotes de
					Viagem</a></li>
		</ul>

		<div class="container py-3">
			<form action="../../create-login">
				<h2 class="text-center">Novo Login</h2>

				<div class="form-group mb-3">
					<label for="id_login" class="form-label"> ID </label> <input
						type="number" id="id_login" name="id_login" class="form-control"/>
				</div>

				<div class="form-group mb-3">
					<label for="tipoLogin" class="form-label"> Tipo de login </label> <input
						type="text" id="tipoLogin" name="tipoLogin" class="form-control"/>
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="./login" class="btn btn-danger" style="margin-left: 10px">
					Cancelar </a>
			</form>
		</div>

	</main>

	<footer class="fixed-bottom" id="recodeP">
		<div class="container">
			<img src="./assets/img/recode.svg" alt="recodePro" />
		</div>
	</footer>

	<script src="script.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>