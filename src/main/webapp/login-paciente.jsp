<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Login paciente</title>
<link rel="stylesheet" href="./estilo/back.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style>
#showPassword {
	display: none;
}
</style>
</head>
<body>
	<div class="containerColor">

		<main class="d-flex justify-content-center align-items-center"
			style="height: 100vh;">
			<div class="card shadow-lg border border-0 w-50">
				<div class="card-header bg-light">
					<div class="d-flex justify-content-center align-items-center">
						<img class="shadown-lg" src="./imagens/logoMed.png" alt="">
					</div>
				</div>

				<form class="mt-3 d-flex flex-column align-items-center"
					action="login" method="post">
					<input type="hidden" value="pacienteLogin" name="acaoLogin">
					<div class="mb-3">
						<div class="d-flex">
							<input type="text"
								class="shadow-lg form-control custom-input <%=request.getAttribute("loginInvalido") != null ? "is-invalid" : ""%>"
								id="cpf" name="cpf" minlength="11" maxlength="11"
								placeholder="CPF (Somente números)" required style="width: 40vh">
						</div>
					</div>
					<div class="mb-3">
						<div class="position-relative">
							<input type="password"
								class="shadow-lg form-control custom-input <%=request.getAttribute("loginInvalido") != null ? "is-invalid" : ""%>"
								id="senha" name="senha" minlength="5" maxlength="12"
								placeholder="Senha" required style="width: 40vh">
							<div class="position-absolute end-0 top-50 translate-middle-y">
								<button class="btn" type="button" id="showPasswordMain"
									onclick="togglePassword('senha', 'showPasswordMain')">
									<i class="far fa-eye"></i>
								</button>
							</div>
						</div>
					</div>
					<c:if test="${not empty erroLogin }">
						<p class="text-danger" style="font-size: 15px">${erroLogin}</p>
					</c:if>

					<div class="d-flex flex-column text-center w-100 mt-3">
						<button type="submit"
							class="btn btn-primary btn-lg m-auto text-cente fw-bold fs-5"
							style="width: 40vh;">Iniciar sessão</button>
						<a href="#" class="mt-2 text-decoration-none"
							onclick="modalSenha()">Esqueceu a senha?</a>
					</div>
					<div class="card-body d-flex align-items-center w-100">
						<span class="border border-1 w-100 rounded-5 mx-2"
							style="height: 1px; margin-bottom: 10px;"></span>
						<p>ou</p>
						<span class="border border-1 w-100 rounded-5 mx-2"
							style="height: 1px; margin-bottom: 10px;"></span>
					</div>

					<div class="d-flex justify-content-center w-100 mb-3">
						<a href="cadastro-paciente.jsp"><button type="button"
								class="btn btn-success w-100 m-auto text-cente fw-bold fs-6">Criar
								nova conta</button></a>
					</div>
				</form>
			</div>

			<div class="modal" id="myModal" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<p class="alert alert-success">Cadastro feito com sucesso!</p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-bs-dismiss="modal">Ir para login</button>
						</div>
					</div>
				</div>
			</div>

			<div class="modal" id="modalSenha" tabindex="-1">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5>Redefinir senha</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">
							<form id="formCpfSenha" action="paciente" method="post">
								<input type="hidden" value="verifica-cpf" name="acao">
								<div class="d-flex justify-content-center flex-column">
									<div class="mb-3">
										<div class="d-flex">
											<input type="text"
												class="form-control custom-input <%=request.getAttribute("cpfInvalid") != null ? "is-invalid" : ""%>"
												id="cpfS" name="cpfS" minlenght="11" maxlength="11"
												placeholder="CPF(Somente números)" required
												style="max-width: 500px;">
										</div>
										<c:if test="${not empty cpfMsg }">
												<p class="text-danger" style="font-size: 10px">${cpfMsg}</p>
										</c:if>
										
										<c:if test="${cpfInvalid eq true}">
											<script>
												$(document).ready(function() {
												$('#modalSenha').modal('show');
															});
											</script>
										</c:if>
									</div>

									<div class="w-100 d-flex align-items-center">
										<button type="submit"
											class="btn btn-success btn-registrar fw-bold m-auto">Enviar</button>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
			<c:if test="${cpfValid eq true}">
				<div class="modal fade" id="modalAltSenha" tabindex="-1"
					role="dialog" aria-labelledby="modalExemploLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalExemploLabel">Redefinir
									senha</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form id="formAltSenha" action="paciente" method="post">
									<input type="hidden" value="altera-senha" name="acao">
									<div class="d-flex justify-content-center flex-column">
										<div class="mb-3">
											<div class="position-relative">
												<input type="password"
													class="shadow-lg form-control custom-input"
													id="senhaS" name="senhaS" minlength="5" maxlength="12"
													placeholder="Nova senha" required style="max-width: 500px;">
												<div
													class="position-absolute end-0 top-50 translate-middle-y">
													<button class="btn" type="button"
														onclick="togglePassword('senhaS', 'showPasswordModal')">
														<i class="far fa-eye"></i>
													</button>
												</div>
											</div>
										</div>

										<div class="w-100 d-flex align-items-center">
											<button type="submit"
												class="btn btn-success btn-registrar fw-bold m-auto">Alterar</button>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer"></div>
						</div>
					</div>
				</div>

				<script>
					$(document).ready(function() {
						$('#modalAltSenha').modal('show');
					});
				</script>
			</c:if>

			<c:if test="${senhaValid eq true}">
				<div class="modal fade" id="modalMensagem" tabindex="-1"
					role="dialog" aria-labelledby="modalExemploLabel"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="modalExemploLabel">Redefinir
									senha</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<form id="formAltSenha" action="paciente" method="post">
									<input type="hidden" value="altera-senha" name="acao">
									<div class="d-flex justify-content-center flex-column">
										<div class="mb-3">
											<div class="d-flex ms-5">
												<h4 class="alert alert-success" style="max-width: 500px;">Senha alterada com
													sucesso!</h4>
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="modal-footer"></div>
						</div>
					</div>
				</div>

				<script>
					$(document).ready(function() {
						$('#modalMensagem').modal('show');
					});
				</script>

			</c:if>
		</main>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
		

	<script>
		function togglePassword(inputId, buttonId) {
			var senhaInput = document.getElementById(inputId);
			var showPasswordButton = document.getElementById(buttonId);

			if (senhaInput.type === "password") {
				senhaInput.type = "text";
				showPasswordButton.innerHTML = '<i class="fas fa-eye-slash"></i>';
			} else {
				senhaInput.type = "password";
				showPasswordButton.innerHTML = '<i class="fas fa-eye"></i>';
			}
		}

		document.getElementById(inpuId).addEventListener(
				"input",
				function() {
					var senhaInput = document.getElementById("senha");
					var showPasswordButton = document
							.getElementById("showPasswordMain");

					if (senhaInput.value.trim() !== "") {
						showPasswordButton.style.display = "block";
					} else {
						showPasswordButton.style.display = "none";
					}
				});
	</script>

	<script>
		document.addEventListener('DOMContentLoaded', function() {
			var cadastroSucesso =
	<%=request.getAttribute("cadastroSucesso")%>
		;

			var modal = document.getElementById('myModal');

			if (modal && cadastroSucesso === true) {

				var myModal = new bootstrap.Modal(modal);
				myModal.show();
			}
		});

		function modalSenha() {
			var modal = document.getElementById('modalSenha');
			var modalS = new bootstrap.Modal(modal);
			modalS.show();

		}
		function fecharModalSenha() {
			$('#modalSenha').modal('hide');

		}
	</script>

</body>
</html>