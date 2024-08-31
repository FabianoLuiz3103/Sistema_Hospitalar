<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Dados_biometricos"%>

<!DOCTYPE html>
<html lang="PT-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="ISO-8859-1">
    <title>Dados biométricos</title>
    <link rel="stylesheet" href="./estilo/back.css">
    <link rel="stylesheet" href="./estilo/menu.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://db.onlinewebfonts.com/c/b1030670fe2c54b8736af23bcf6bd166?family=Gotham+HTF+Light"
        rel="stylesheet">
    <link href="https://db.onlinewebfonts.com/c/1af7207b68ef04bc4e453e0aa814e986?family=Gotham+HTF+Book"
        rel="stylesheet">
    <link href="https://db.onlinewebfonts.com/c/7660bb62fdc3548ba51b96d0fba2705b?family=Gotham+HTF+Medium"
        rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

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

                <h1 class="l-header-title">
                   Resultados de exames
                </h1>
            </div>
        </div>
    </header>

    <nav id="menu" class="l-menu">
        <div class="d-flex text-light font">
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>
            <p>HARMONY HEALTH <img src="./imagens/cina.png" class="p-1 pe-2"></p>

        </div>
    </nav>
    <div class="l-content">
        <div class="l-content-wrapper">
          <div class="d-flex flex-column">
            <div class="row bg w-100">
    
                <div class="d-flex">

                    <div class="card col-12 mb-3 shadow">
                      <div class="card-header text-center">
                        <h5>PACIENTE:</h5>
                      </div>
                      <div class="card-body" style="text-align: left;">
                        <h6 class="card-text"><span class="fw-bold">Nome:</span> ${sessionScope.dadosPaciente.getNome()}, ${sessionScope.dadosPaciente.getIdade()}</h6>
                        <c:forEach var="d" items="${biometricos}" begin="0" end="0">
                        <h6 class="card-text"><span class="fw-bold">Peso:</span> ${d.peso}kg</h6>
                        <h6 class="card-text"><span class="fw-bold">Altura:</span> ${d.altura}cm</h6>
                        </c:forEach>
                      </div>
                    </div>

                    
                </div>
              </div>

            <div class="l-content-left">
              <div id='aulas' class='l-content-tab'>
    
                
              </div>
            </div>
 <div class="table-responsive bg-dark">
  <table class="table table-hover shadow">
    <thead>
      <tr>
        <th scope="col">#</th>
        <th scope="col" class="text-center">Paciente</th>
        <th scope="col" class="text-center">Médico</th>
        <th scope="col" class="text-center">Avaliação</th>
      </tr>
    </thead>
    <tbody class="table-group-divider">
      <c:forEach var="row" items="${biometricos}" varStatus="status" step="7">
        <tr>
          <th scope="row">${status.index / 7 + 1}</th>
          <td>
            <table class="table table-hover table-bordered shadow text-center">
              <thead>
                <tr>
                  <th scope="col">Diagnóstico</th>
                  <th scope="col">Resultado</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="d" items="${biometricos}" begin="${status.index}" end="${status.index + 6}" varStatus="innerStatus">
                  <tr>
                    <td>${d.tipo_diagnostico}</td>
                    <td>${d.resultado_exame}</td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </td>
          <td>
            <div class="card col-10 col-sm-6 w-100 mb-3 shadow">
  <div class="card-header text-center">
    <h5>MÉDICO:</h5>
  </div>
  <div class="card-body">
    <blockquote class="blockquote mb-0">
      <c:forEach var="d" items="${biometricos}" begin="1" end="1">
        <p class="fs-6"><span class="fw-bold">Nome:</span> ${row.medico}</p>
        <p class="fs-6"><span class="fw-bold">CRM:</span> ${row.crm}</p>
        <p class="fs-6"><span class="fw-bold">Especialidade:</span> ${row.especialidade}</p>
      </c:forEach>
    </blockquote>
  </div>
</div>
          </td>
          <td>
           <div class="card col-10 col-sm-6 w-100 mb-3 shadow">
  <div class="card-header text-center">
    <h5>AVALIAÇÃO:</h5>
  </div>
  <div class="card-body">
    <blockquote class="blockquote mb-0">
    <div class="d-flex flex-column">
      <a href='avaliacao.html?cod_paciente=${row.cod_paciente}&cod_consulta=${row.cod_consulta}'><button class="btn btn-primary">Responder</button></a>
      <c:forEach var="d" items="${biometricos}" begin="1" end="1">
      <footer class="blockquote-footer mt-1 fs-6">Consulta: ${row.cod_consulta}</footer>
      <footer class="blockquote-footer fs-6">Data: ${row.data}</footer>
       </c:forEach>
    </div>
    </blockquote>
  </div>
</div>
          </td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
 
          </div>
        </div>
      </div>
    
    

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
</body>

</html>