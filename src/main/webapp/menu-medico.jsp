<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="br.com.fiap.bean.Medico"%>

<!DOCTYPE html>
<html lang="PT-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="ISO-8859-1">
    <title>Menu paciente</title>
    <link rel="stylesheet" href="./estilo/back.css">
    <link rel="stylesheet" href="./estilo/menu.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://db.onlinewebfonts.com/c/b1030670fe2c54b8736af23bcf6bd166?family=Gotham+HTF+Light"
        rel="stylesheet">
    <link href="https://db.onlinewebfonts.com/c/1af7207b68ef04bc4e453e0aa814e986?family=Gotham+HTF+Book"
        rel="stylesheet">
    <link href="https://db.onlinewebfonts.com/c/7660bb62fdc3548ba51b96d0fba2705b?family=Gotham+HTF+Medium"
        rel="stylesheet">
        
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<style>
    <style>
        #showPassword {
            display: none;
        }
    </style>
</head>

<body>
    <header class="l-header containerColor">

        <div class="l-header-menu">
            <div class="l-header-menu-wrapper">
                <a href="/Aluno/Home" class="l-header-logo">
                    <img src="./imagens/logoMed.png" alt="">
                </a>

                <a href="login?acaoLogout=medicoLogout" class="l-header-link">
                    <i class="fas fa-power-off me-2"></i> Sair
                </a>
            </div>
        </div>

        <div class="l-header-wrapper ">
            <div class="l-header-box">
               
                <h1 class="l-header-title">
                    Olá dr. ${sessionScope.dadosMedico.getNome()},
                </h1>

                <p class="l-header-subtitle">
                    Seja bem-vindo ao Portal Harmony Health.
                </p>
               
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

        <div class="l-content-wrapper ">

            <div class="l-content-left">
                <div id='aulas' class='l-content-tab'>

                    <a href='medico?acao=abrir-form-edicao&cod_medico=${sessionScope.codMedico}' class='l-servico '>
                        <span class='l-servico-box'>
                            <span class='l-servico-box-wrapper'>
                                <span class='l-servico-media'>
                                    <img src="./imagens/user-interface.png" alt="">
                                </span>
                                <strong class='l-servico-title'>
                                    <span class='l-servico-title-text'>
                                        Dados cadastrais
                                    </span>
                                </strong>

                            </span>
                        </span>
                    </a>

                    <a href='medico?acao=solicitacoes&cod_medico=${sessionScope.codMedico}' class='l-servico '>
                        <span class='l-servico-box'>
                            <span class='l-servico-box-wrapper'>
                                <span class='l-servico-media'>
                                    <img src="./imagens/calendario.png" alt="">
                                </span>
                                <strong class='l-servico-title'>
                                    <span class='l-servico-title-text'>
                                        Solictações recebidas
                                    </span>
                                </strong>

                            </span>
                        </span>
                    </a>

                    <a href='GraficosMed.jsp' class='l-servico '>
                        <span class='l-servico-box'>
                            <span class='l-servico-box-wrapper'>
                                <span class='l-servico-media'>
                                    <img src="./imagens/painel-de-controle.png" alt="">
                                </span>
                                <strong class='l-servico-title'>
                                    <span class='l-servico-title-text'>
                                        Infográficos
                                    </span>
                                </strong>

                            </span>
                        </span>
                    </a>
                </div>
            </div>

        </div>
    </div>
   
    	
    		
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
    
    <script>
    function abrirModal(){
    	$(document).ready(function() {
			$('#modalDados').modal('show');
		});
    }
    </script>
    
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