<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Consulta"%>
<%@ page import="br.com.fiap.bean.Especialidade"%>
<%@ page import="br.com.fiap.bean.Medico"%>
<%@ page import="br.com.fiap.bean.Paciente"%>
<!DOCTYPE html>
<html lang="PT-BR">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0"
	charset="ISO-8859-1">
<title>Confirmação agendamento</title>
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

<style>
.card:hover {
	transform: translateY(-5px);
	transition: transform 0.3s ease;
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

				<h1 class="l-header-title">Confirmação de agendamento</h1>
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
                <div id='conteudo' class='l-content-tab'>

                    <div class="d-flex m-auto w-75" style="height: 120vh;">
                        <div class="card col-12 mb-3 shadow">
                            <div id="consultaHeader" class="card-header text-center">
                                <h5><span class="fw-bold">CONSULTA: <span class="fst-italic">#${dadosConsulta.cod_consulta}</span></span></h5>
                            </div>
                            <div class="card-body text-center">
                                <h5 id="pacienteTitle" class="card-text"><span class="fw-bold">Paciente:</span></h5>
                                <hr>
                                <h6 id="pacienteNome" class="card-text">Nome: <span class="fw-light">${dadosPaciente.nome}</span> </h6>
                                <hr>
                                <h6 id="pacienteIdade" class="card-text">Idade: <span class="fw-light">${dadosPaciente.idade}</span></h6>
                                <hr>
                                <h6 id="pacienteSexo" class="card-text">Sexo: <span class="fw-light">${dadosPaciente.sexo}</span></h6>
                                <hr>
                                <br>
                                <h5 id="medicoTitle" class="card-text"><span class="fw-bold">Médico:</span></h5>
                                <hr>
                                <h6 id="medicoNome" class="card-text">Nome: <span class="fw-light">${dadosMedico.nome}</span> </h6>
                                <hr>
                                <h6 id="medicoCRM" class="card-text">CRM: <span class="fw-light">${dadosMedico.crm}</span></h6>
                                <hr>
                                <h6 id="especialidade" class="card-text">Especialidade: <span class="fw-light">${dadosEspecialidade.nome}</span></h6>
                                <hr>
                                <br>
                                <h5 id="consultaTitle" class="card-text"><span class="fw-bold">Consulta:</span></h5>
                                <hr>
                                <h6 id="consultaData" class="card-text">Data: <span class="fw-light">${dadosConsulta.data}</span> </h6>
                                <hr>
                                <h6 id="consultaHora" class="card-text">Hora: <span class="fw-light">${dadosConsulta.hora}</span> </h6>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-primary" onclick="gerarPDF()">Gerar PDF</button>
        </div>
    </div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
		
	</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.68/pdfmake.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.68/vfs_fonts.js"></script>


<script>
    function gerarPDF() {
        var consultaHeader = document.getElementById("consultaHeader");
        var pacienteNome = document.getElementById("pacienteNome");
        var pacienteIdade = document.getElementById("pacienteIdade");
        var pacienteSexo = document.getElementById("pacienteSexo");
        var medicoNome = document.getElementById("medicoNome");
        var medicoCRM = document.getElementById("medicoCRM");
        var especialidade = document.getElementById("especialidade");
        var consultaData = document.getElementById("consultaData");
        var consultaHora = document.getElementById("consultaHora");
        if (consultaHeader && pacienteNome && pacienteIdade && pacienteSexo && medicoNome && medicoCRM && especialidade && consultaData && consultaHora) {
            var content = [
                { text: 'Relatório de Consulta', style: 'header' },
                { text: consultaHeader.innerText, style: 'subheader' },
                { text: 'Paciente:', style: 'subheader' },
                { text: pacienteNome.innerText, margin: [0, 0, 0, 5] },
                { text: pacienteIdade.innerText, margin: [0, 0, 0, 5] },
                { text: pacienteSexo.innerText, margin: [0, 0, 0, 5] },
                { text: 'Médico:', style: 'subheader' },
                { text: medicoNome.innerText, margin: [0, 0, 0, 5] },
                { text: medicoCRM.innerText, margin: [0, 0, 0, 5] },
                { text: especialidade.innerText, margin: [0, 0, 0, 5] },
                { text: 'Consulta:', style: 'subheader' },
                { text: consultaData.innerText, margin: [0, 0, 0, 5] },
                { text: consultaHora.innerText, margin: [0, 0, 0, 5] },
                { canvas: [{ type: 'line', x1: 0, y1: 0, x2: 515, y2: 0 }], margin: [0, 5, 0, 5] },
            ];
            var styles = {
                header: { fontSize: 18, bold: true, margin: [0, 0, 0, 10] },
                subheader: { fontSize: 16, bold: true, margin: [0, 10, 0, 5] }
            };
            var docDefinition = { content: content, styles: styles };
            pdfMake.createPdf(docDefinition).open();
        } else {
            console.error('Algum elemento não foi encontrado.');
        }
    }
</script>
	
</body>

</html>