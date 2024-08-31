<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Solicitacao"%>
<%@ page import="br.com.fiap.bean.Paciente"%>
<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Solicitações</title>
<link rel="stylesheet" href="./estilo/back.css">
<link rel="stylesheet" href="./estilo/menu.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link
	href="https://db.onlinewebfonts.com/c/b1030670fe2c54b8736af23bcf6bd166?family=Gotham+HTF+Light"
	rel="stylesheet">
<link
	href="https://db.onlinewebfonts.com/c/1af7207b68ef04bc4e453e0aa814e986?family=Gotham+HTF+Book"
	rel="stylesheet">
<link
	href="https://db.onlinewebfonts.com/c/7660bb62fdc3548ba51b96d0fba2705b?family=Gotham+HTF+Medium"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

</head>

<body>
	<header class="l-header containerColor h-25">

		<div class="l-header-menu">
			<div class="l-header-menu-wrapper">

				<nav class="navbar">
					<div class="container-fluid">
						<a href="/Aluno/Home" class="l-header-logo"> <img
							src="./imagens/logoMed.png" alt="">
						</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar"
							aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="offcanvas offcanvas-end" tabindex="-1"
							id="offcanvasNavbar" aria-labelledby="offcanvasNavbarLabel">
							<div class="offcanvas-header">
								<h5 class="offcanvas-title" id="offcanvasNavbarLabel">${sessionScope.dadosMedico.getNome()}</h5>
								<button type="button" class="btn-close"
									data-bs-dismiss="offcanvas" aria-label="Close"></button>
							</div>
							<div class="offcanvas-body">
								<ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="menu-medico.jsp">Menu</a></li>
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="medico?acao=solicitacoes">Solicitações</a>
									</li>
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="medico?acao=solicitacoes&cod_medico=${sessionScope.codMedico}">Dados
											cadastrais</a></li>
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="GraficosMed.jsp">Infográficos</a></li>
									<li class="nav-item"><a class="nav-link active"
										aria-current="page" href="login?acaoLogout=medicoLogout">SAIR</a>
									</li>

								</ul>
							</div>
						</div>
					</div>
				</nav>
			</div>
		</div>

		<div class="l-header-wrapper ">
			<div class="l-header-box">

				<h1 class="l-header-title">Solicitações</h1>
			</div>
		</div>
	</header>

	<nav id="menu" class="l-menu">
		<div class="d-flex text-light font">
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>
			<p>
				HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2">
			</p>

		</div>
	</nav>
	<div class="l-content">
		<div class="l-content-wrapper">
			<div class="l-content-left">
				<div id='aulas' class='l-content-tab d-flex flex-wrap'>
					<div></div>
					<div class="w-50">
						<c:forEach var="s" items="${solicitacoes}">
							<div class="card text-center mt-3 shadown-lg">
								<div class="card-header">
									<h4>Solicitação ${s.cod_solicitacao}</h4>
								</div>
								<div class="card-body">
									<h5 class="card-title">Paciente ${s.cod_paciente}:</h5>
									<h5 class="card-text">Nome: ${s.nome}</h5>
									<h5 class="card-text">Data: ${s.data_solicitacao}</h5>
									<c:if test="${s.status eq 'P'}">
										<h5 class="alert alert-warning">Solicitação não
											respondida: Pendente!</h5>
										<form action="medico" method="post">
											<input type="hidden" name="acao" value="resposta-solicitacao">
											<input type="hidden" name="cod_solicitacao"
												value="${s.cod_solicitacao}"> <select
												class="form-select form-select-sm"
												aria-label="Small select example" name="status" id="status"
												required>
												<option selected>Respoder</option>
												<option value="A">ACEITAR</option>
												<option value="N">NEGAR</option>
											</select>
											<button class="btn btn-primary mt-2" type="submit">RESPONDER</button>
										</form>
									</c:if>
									<c:if test="${s.status eq 'A' or s.status eq 'N'}">
										<c:if test="${s.status eq 'A'}">
											<h5 class="alert alert-success">Solicitação respondida:
												Aceita!</h5>
										</c:if>
										<c:if test="${s.status eq 'N'}">
											<h5 class="alert alert-danger">Solicitação respondida:
												Negada!</h5>
										</c:if>
									</c:if>
								</div>
								<div class="card-footer text-body-secondary">2 days ago</div>
							</div>
						</c:forEach>
					</div>

				</div>
			</div>

		</div>

	</div>



	<script>
		history.pushState(null, null, "./medico?acao=solicitacoes");
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
		
	</script>
</body>

</html>