<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Especialidade"%>
<!DOCTYPE html>
<html lang="PT-BR">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Cadastro paciente</title>
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
					action="medico" method="post">
					<input type="hidden" value="cadastrar" name="acao">
					<div class="mb-3">
						<div class="d-flex">
							<input type="text"
								class="shadow-lg form-control custom-input me-4 " id="nome_med"
								name="nome_med" maxlength="50" placeholder="Nome completo"
								required style="width: 40vh"> <input type="email"
								class="shadow-lg form-control custom-input <%=request.getAttribute("emailInvalido") != null ? "is-invalid" : ""%>"
								id="email_med" name="email_med" aria-describedby="emailHelp"
								maxlength="50" placeholder="E-mail" required style="width: 40vh">
						</div>
						<div class="d-flex justify-content-end">
							<c:if test="${not empty erroEmail }">
								<p class="text-danger" style="font-size: 10px">${erroEmail}</p>
							</c:if>
						</div>
					</div>
					<div class="mb-3">
						<div class="d-flex">
							<input type="tel"
								class="shadow-lg form-control custom-input me-4 <%=request.getAttribute("telefoneInvalido") != null ? "is-invalid" : ""%>"
								id="telefone_med" name="telefone_med" minlength="11"
								maxlength="15" placeholder="Telefone" required
								style="width: 40vh"> <input type="text"
								class="shadow-lg form-control custom-input <%=request.getAttribute("cpfInvalido") != null ? "is-invalid" : ""%>"
								id="crm" name="crm" minlength="9" maxlength="9"
								placeholder="CRM" required style="width: 40vh">
						</div>
						<div class="d-flex justify-content-between">
							<c:if test="${not empty erroTelefone }">
								<p class="text-danger" style="font-size: 10px">${erroTelefone}</p>
							</c:if>
							<c:if test="${not empty erroCpf }">
								<p class="text-danger" style="font-size: 10px">${erroCpf}</p>
							</c:if>
						</div>
					</div>
					<div class="mb-3">
						<div class="d-flex">
						<select
								class="shadow-lg form-select custom-input text-secondary me-4"
								id="especialidade" name="especialidade" required style="width: 40vh">
								<option value="0">Especialidade</option>
					<c:forEach items="${especialidades}" var="e">
						<option value="${e.cod_especialidade}">${e.nome}</option>
					</c:forEach>
							</select>
							 <div class="position-relative">
							<input type="password"
								class="shadow-lg form-control custom-input" id="senha"
								name="senha" minlength="5" maxlength="12" placeholder="Senha"
								required style="width: 40vh">
							<div class="position-absolute end-0 top-50 translate-middle-y">
								<button class="btn" type="button" id="showPasswordMain"
									onclick="togglePassword('senha', 'showPasswordMain')">
									<i class="far fa-eye"></i>
								</button>
							</div>
						</div>
							 
							 
						</div>
					</div>
				


					<div class="mx-5">
						<p class="fw-lighter m-auto" style="font-size: 10px;">Ao
							clicar em Registar-se, estará de acordo com os nossos Termos, a
							nossa Política de Privacidade e a nossa Política de Cookies.</p>
					</div>
					<div class="d-flex w-100 mt-3">
						<button type="submit"
							class="shadow btn btn-success btn-registrar fw-bold m-auto">Registrar-se</button>
						<button type="reset"
							class="shadow btn btn-warning btn-registrar fw-bold m-auto">Limpar</button>
					</div>
					<div class="mt-3 mb-3">
						<a href="medico?acao=abrir-form-login"
							class="text-center text-decoration-none fs-5 text-primary"
							style="font-size: 10px;">Já tem uma conta?</a>
					</div>
				</form>
			</div>

			
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

	document.getElementById("senha").addEventListener(
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

</body>
</html>