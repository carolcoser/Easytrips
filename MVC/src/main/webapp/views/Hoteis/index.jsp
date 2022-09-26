<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.Hoteis" import="java.util.List"
	import="model.Login" import="dao.LoginDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<Hoteis> listaHoteis = (List<Hoteis>) request.getAttribute("hoteis");
%>

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
<title>Easytrips | Agência de viagens</title>
</head>
<body>
	<main>
		<header class="header">
			<h1 class="text-center" style="background-color: #FFA500">
				<img
					src="https://img.icons8.com/external-flaticons-lineal-color-flat-icons/64/000000/external-trip-vacation-planning-flaticons-lineal-color-flat-icons.png" />Easytrips
			</h1>
		</header>

		<ul class="nav justify-content-center mb-5">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="./index.html">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="./clientes">Clientes</a></li>
			<li class="nav-item"><a class="nav-link" href="./compra">Compras</a></li>
			<li class="nav-item"><a class="nav-link" href="./destinos">Destinos</a></li>
			<li class="nav-item"><a class="nav-link" href="./hoteis">Hotéis</a></li>
			<li class="nav-item"><a class="nav-link" href="./login">Permissões/Login</a></li>
			<li class="nav-item"><a class="nav-link" href="./pacotes">Pacotes
					de Viagem</a></li>
		</ul>

		<section class="container">
			<div class="p-4">
				<div class="row justify-content-center">
					<a href="./views/Hoteis/create.jsp" class="btn mb-2 botao1"
						style="background-color: #FFA500"> Novo Hotel </a>
				</div>

				<table class="table table-responsive table-hover">
					<thead class="table-light">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Nome</th>
							<th scope="col">Café da manhã</th>
							<th scope="col">Valor da diária: R$</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>

						<%
						for (Hoteis h : listaHoteis) {
						%>
						<tr>
							<td><%=h.getId_hotel()%></td>
							<td><%=h.getNome_hotel()%></td>
							<td><%=h.getCafeDaManha()%></td>
							<td><%=h.getValor_diaria()%></td>
							<td>
								<div class="d-flex">
									<a href="./update-hotel?id_hotel=<%=h.getId_hotel()%>" class="mx-1"
										title="Editar"> <i class="ri-file-edit-line"></i>
									</a> <a href="delete-hotel?id_hotel=<%=h.getId_hotel()%>" class="mx-1"
										title="Cancelar"
										onclick="return confirm('Deseja excluir o Hotel <%=h.getNome_hotel()%>?')">
										<i class="ri-delete-bin-2-line"></i>
									</a>
								</div>
							</td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>

			</div>
		</section>

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