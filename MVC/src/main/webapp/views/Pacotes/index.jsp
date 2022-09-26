<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.PacotesViagem"
	import="java.util.List" import="model.Destinos" import="model.Hoteis"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<PacotesViagem> listaPacotes = (List<PacotesViagem>) request.getAttribute("pacotes");
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
					<a href="./views/Pacotes/create.jsp" class="btn mb-2 botao1"
						style="background-color: #FFA500"> Novo Pacote de Viagem </a>
				</div>

				<table class="table table-responsive table-hover">
					<thead class="table-light">
						<tr>
							<th scope="col">ID Pacote</th>
							<th scope="col">ID Destino</th>
							<th scope="col">ID Hotel</th>
							<th scope="col">Valor do pacote</th>
							<th scope="col">Valor promocional</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>

						<%
						for (PacotesViagem p : listaPacotes) {
						%>
						<tr>
							<td><%=p.getId_pacote()%></td>
							<td><%=p.getDestino()%></td>
							<td><%=p.getHotel()%></td>
							<td><%=p.getValor_pacote()%></td>
							<td><%=p.getPromo()%>
							<td>
								<div class="d-flex">
									<a href="./update-pacote?id_pacote=<%=p.getId_pacote()%>" class="mx-1"
										title="Editar"> <i class="ri-file-edit-line"></i>
									</a> <a href="delete-pacote?id_pacote=<%=p.getId_pacote()%>" class="mx-1"
										title="Cancelar"
										onclick="return confirm('Deseja excluir o Pacote <%=p.getId_pacote()%>?')">
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