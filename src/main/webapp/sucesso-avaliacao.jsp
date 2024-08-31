<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Paciente"%>


<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Menu paciente</title>
<link rel="stylesheet" href="./estilo/back.css">
<link rel="stylesheet" href="./estilo/menu.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
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

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style>
<
style>#showPassword {
	display: none;
}
</style>
</head>

<body>
	<header class="l-header containerColor">

		<div class="l-header-menu">
			<div class="l-header-menu-wrapper">

				         <nav class="navbar">
                    <div class="container-fluid">
                        <a href="/Aluno/Home" class="l-header-logo">
                            <img src="./imagens/logoMed.png" alt="">
                        </a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"
                            data-bs-target="#offcanvasNavbar" aria-controls="offcanvasNavbar"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="offcanvas offcanvas-end" tabindex="-1" id="offcanvasNavbar"
                            aria-labelledby="offcanvasNavbarLabel">
                            <div class="offcanvas-header">
                                <h5 class="offcanvas-title" id="offcanvasNavbarLabel">${sessionScope.dadosPaciente.getNome()}</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="offcanvas"
                                    aria-label="Close"></button>
                            </div>
                            <div class="offcanvas-body">
                                <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="menu-paciente.jsp">Menu</a>
                                    </li>
                                     <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="paciente?acao=agendar">Solicitação e agendamento</a>
                                    </li>
                                     <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href='paciente?acao=abrir-form-edicao&cod_paciente=${sessionScope.codPaciente}'>Dados cadastrais</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href='GraficosPac.jsp'>Infográficos]</a>
                                    </li>
                                     <li class="nav-item">
                                        <a class="nav-link active" aria-current="page" href="login?acaoLogout=pacienteLogout">SAIR</a>
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

				<h1 class="l-header-title">ATUALIZAÇÃO CADASTRAL</h1>

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

		<div class="l-content-wrapper ">

			<div class="l-content-left">
				<div id='aulas' class='l-content-tab'>

					<div class="card shadow-lg border border-0 w-50">
						<div class="card-header bg-light">
							<div class="d-flex justify-content-center align-items-center">
								<img class="shadown-lg" src="./imagens/logoMed.png" alt="">
							</div>
						</div>
						
						<div class="card-body">
						<h3 class="text-center alert alert-success">Sua avaliação foi registrada com sucesso!</h3>
						</div>

						
					</div>


				</div>
			</div>

		</div>
	</div>
     
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
        
    </script>

</body>

</html>