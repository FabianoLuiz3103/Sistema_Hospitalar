<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Especialidade"%>
<%@ page import="br.com.fiap.bean.Medico"%>
<%@ page import="br.com.fiap.bean.Paciente"%>
<%@ page import="br.com.fiap.bean.Solicitacao"%>
<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Solicitação agendamento</title>
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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/css/bootstrap-datepicker.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/js/bootstrap-datepicker.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-datepicker@1.9.0/dist/locales/bootstrap-datepicker.pt-BR.min.js">
	
</script>


<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js">
	
</script>




<style>
#showPassword {
	display: none;
}
</style>
</head>

<body>
	<header class="l-header containerColor h-25">

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

				<h1 class="l-header-title">Solicitação e agendamento</h1>
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
					<div class="d-flex flex-column">


						<div class="shadow-lg card l-agendamento">
							<h5 class="card-header">Solicitação</h5>
							<div class="card-body">

								<form id="formSelect" action="paciente" method="get">
									<input type="hidden" value="agendar" name="acao">
									<div class="mb-3">
										<div class="d-flex flex-column">
											<h6 class="card-text fw-light" style="text-align: left;">Especialidade:</h6>
											<select name="especialidade" id="especialidadeSelect"
												class="shadow form-select"
												aria-label="Default select example"
												<c:if test="${status eq 'P'}">
            										disabled
        										</c:if>
												required>
												<option selected disabled>Especialidade</option>
												<c:forEach items="${especialidades}" var="e">
													<option value="${e.cod_especialidade}">${e.nome}</option>
												</c:forEach>
												<c:if test="${codSelecionado ne null}">
													<option value="${codSelecionado}" selected>${nomeEsp}</option>
												</c:if>
											</select>
										</div>
									</div>
								</form>

								<form id="formSolic" action="paciente" method="post">
									<input type="hidden" value="criar-solicitacao" name="acao">
									<input type="hidden" value="${sessionScope.codPaciente}"
										name="cod_paciente"> <input type="hidden" value="P"
										name="status">

									<div class="mb-3">
										<div class="d-flex flex-column">
											<h6 class="card-text fw-light" style="text-align: left;">Médico:</h6>
											<select name="cod_medico" id="medicosSelect"
												class="shadow form-select"
												aria-label="Default select example"
												<c:if test="${status eq 'P'}">
            										disabled
        										</c:if>
												required>
												<option selected disabled>Médicos</option>
												<c:forEach items="${especialidades}" var="e">
													<c:forEach items="${e.medicos}" var="m">
														<c:if test="${m.cod_especialidade eq codSelecionado}">
															<div class="bg-info"></div>
															<option value="${m.cod_medico}">${m.nome}</option>
														</c:if>
													</c:forEach>
												</c:forEach>
												<c:if test="${codSelecionado eq null}">
													<option value="" selected disabled>Escolha uma
														especialidade</option>
												</c:if>

											</select>
										</div>
									</div>

									<div class="mb-3">
										<div class="d-flex justify-content-center">
											<c:if test="${status eq 'P'}">
												<h5 class="shadow alert alert-warning">STATUS:PENDENTE</h5>
											</c:if>
											<c:if test="${status eq 'N'}">
												<h5 class="shadow alert alert-danger">STATUS:NEGADA</h5>
											</c:if>
											<c:if test="${status eq 'A'}">
												<h5 class="shadow alert alert-success">STATUS:ACEITA</h5>
											</c:if>
											<c:if test="${status eq null}">
												<h5 class="shadow alert alert-success" style="display: none"></h5>
											</c:if>

										</div>
									</div>

									<c:if test="${status ne 'A' or status ne 'N'}">
										<button type="submit"
											class="shadow btn btn-success btn-registrar fw-bold m-auto"
											style="display: none;">Registrar-se</button>
									</c:if>
									<c:if test="${status eq 'A' or status eq 'N'}">
										<button type="submit"
											class="shadow btn btn-success btn-registrar fw-bold m-auto"
											style="display: block;">Fazer nova solicitação</button>
									</c:if>

									<c:if test="${status eq null}">
										<button type="submit"
											class="shadow btn btn-success btn-registrar fw-bold m-auto"
											style="display: block;">Fazer solicitação</button>
									</c:if>

								</form>
							</div>
						</div>



						<c:if test="${status eq 'A'}">

							<form action="paciente" method="post">
								<input type="hidden" value="fazer-agendamento" name="acao">



								<div class="shadow-lg card l-agendamento">
									<h5 class="card-header">Agendamento</h5>
									<div class="card-body">

										<div class="mb-3">
											<h6>Data:</h6>
											<div class="d-flex">
												<input type="text" class="shadow form-control p-1" id="data"
													name="data" data-provide="datepicker"
													data-date-language="pt-BR" placeholder="dd/mm/aaaa"
													required>
											</div>
										</div>

										<div class="mb-3">
											<h6>Horário:</h6>
											<div class="d-flex">
												<select class="shadow form-select" id="horario"
													name="horario" disabled required>
													<option value="" disabled selected>Selecione um
														dia primeiro</option>

												</select>

											</div>
										</div>
										<button type="submit"
											class="shadow btn btn-success btn-registrar fw-bold m-auto">
											Registrar-se</button>
									</div>

								</div>
							</form>


						</c:if>

					</div>
				</div>
			</div>
		</div>

	</div>

	<script>
		history.pushState(null, null, "./paciente?acao=agendar");
	</script>


	<script>
		document.getElementById('especialidadeSelect').addEventListener(
				'change', function() {
					document.getElementById('formSelect').submit();
				});
	</script>


	<script>
		$(document).ready(function() {
			$('#data').datepicker({
				format : 'dd/mm/yyyy',
				language : 'pt-BR',
				autoclose : true,
				startDate : new Date(),
				todayHighlight : true
			});

			$('#data').change(function() {
				var selectedDate = $(this).datepicker('getDate');
				updateHorarioDropdown(selectedDate);
			});

			$('#horario').change(function() {
				$('#aviso').addClass('d-none');
			});
		});

		function updateHorarioDropdown(selectedDate) {
			$('#horario').empty().prop('disabled', false);

			$('#horario').append($('<option>', {
				value : '',
				text : 'Selecione um horário'

			}));

			var startHour = 6;
			var endHour = 17;

			var currentMoment = moment(selectedDate);
			var currentTime = moment(currentMoment).startOf('day').add(
					startHour, 'hours');

			while (currentTime.isBefore(moment(currentMoment).startOf('day')
					.add(endHour, 'hours'))) {
				var optionText = currentTime.format('HH:mm ');
				$('#horario').append($('<option>', {
					value : optionText,
					text : optionText
				}));
				currentTime.add(1, 'hours');
			}
		}

		function validarSelecao() {
			if (!$('#data').val()) {
				$('#aviso').removeClass('d-none');
				$('#horario').prop('disabled', true);
			}
		}
	</script>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
		
	</script>
</body>

</html>