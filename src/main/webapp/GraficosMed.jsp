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
<title>Infográficos</title>
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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<style>
.custom-center {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 70vh;
	margin-top: 100px;
}

.card {
	border: none;
}

.grafico-container {
	margin-top: 20px;
}

.grafico {
	max-width: 100%;
}

@media ( max-width : 767px) {
	.grafico-container {
		margin-top: 10px;
	}
	.grafico {
		max-width: 100%;
		height: auto;
	}
}

@media ( min-width : 768px) {
	.grafico-container {
		margin-top: 10px;
	}
	.grafico {
		max-width: 80%;
		max-height: 50vh;
	}
}

.card:hover {
            transform: scale(1.03); 
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); 
        }

</style>
</head>

<body>
	<header class="l-header containerColor">

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

				<h1 class="l-header-title">INFOGRÁFICOS</h1>

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

					<div class="w-100">

						<div class="d-flex justify-content-center w-100 text-center">
							<div class="card shadown border" style="width: 18rem;">
								<div class="card-body">
								    <h5 class="card-title">QUANTIDADE DE PACIENTES</h5>
									<h5 class="card-title" id="paciente"></h5>
									
								</div>
							</div>

							<div class="card shadown border ms-5" style="width: 18rem;">
								<div class="card-body">
								    <h5 class="card-title">NOTA MÉDIA</h5>
									<h5 class="card-title" id="media"></h5>
									
								</div>
							</div>


						</div>

						<div class="d-flex w-100 mt-3">

							<div class="card p-3 container mt-3 col-lg-6 col-12 text-center"
								style="border: none">
								<h3 class="text-center">Idade dos clientes</h3>
								<h6 class="text-center">Quantidade de clientes em cada
									faixa de idade.</h6>
								<div class="grafico-container">
									<canvas id="graficoIdades" class="grafico"></canvas>
								</div>
							</div>

							<div class="card p-3 container mt-3 ms-5 col-lg-6 col-12"
								style="border: none">
								<h3 class="text-center">Frequência das notas</h3>
								<h6 class="text-center">Quantidade que cada nota foi
									escolhida.</h6>
								<div class="grafico-container">
									<canvas id="graficoESG" class="grafico"></canvas>
								</div>
							</div>
						</div>
						<div class="d-flex w-100 mt-3">

							<div class="card p-3 container mt-3 col-lg-6 col-12 text-center"
								style="border: none">
								<h3 class="text-center">Quantidade de pacientes por gênero</h3>
								<h6 class="text-center">Quantidade de clientes por gênero.</h6>
								<div class="grafico-container ms-5">
									<canvas id="graficoSexos" class="grafico"></canvas>
								</div>
							</div>

						</div>

					</div>

				</div>
			</div>

		</div>
	</div>



	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
		
	</script>
	<script>
	document.addEventListener("DOMContentLoaded", function() {
	    function atualizarGrafico() {
	        fetch('graficos?acao=idades')
	        .then(response => response.json())
	        .then(data => {
	            var idades = data;
	            function calcularFrequencias(idades) {
	                var frequencias = [0, 0, 0, 0]; 
	                idades.forEach(function(idade) {
	                	if(idade < 18){
	                		frequencias[0]++;
	                	} else if (idade >= 18 && idade <= 30) {
	                        frequencias[1]++;
	                    } else if (idade >= 31 && idade <= 45) {
	                        frequencias[2]++;
	                    } else {
	                        frequencias[3]++;
	                    }
	                });

	                return frequencias;
	            }
	            var labels = ["0-18", "18-30", "31-45", "46+"];
	            var cores = ["#FF6384","#40E0D0", "#36A2EB", "#FFCE56"];
	            var ctx = document.getElementById("graficoIdades").getContext("2d");
	            var frequencias = calcularFrequencias(idades);

	            var myPieChart = new Chart(ctx, {
	                type: "pie",
	                data: {
	                    labels: labels,
	                    datasets: [{
	                        data: frequencias,
	                        backgroundColor: cores
	                    }]
	                },
	                options: {
	                    responsive: true
	                }
	            });
	        })
	        .catch(error => {
	            console.error('Erro ao buscar dados JSON:', error);
	        });
	    }
	    atualizarGrafico();
	});

	document.addEventListener("DOMContentLoaded", function() {
	    function atualizarGraficoDois() {
	        fetch('graficos?acao=notas')
	        .then(response => response.json())
	        .then(data => {
	            var dados = data;
	            var labels = ["0", "1", "2", "3","4", "5", "6", "7", "8", "9","10"];
	            var cores = ["#FF6384", "#36A2EB", "#FFCE56", "#40E0D0", "#CCCCFF", "#FFBF00", "#DFFF00", "#FF7F50", "#5D6D7E", "#138D75", "#9B59B6 "];
	            var ctx = document.getElementById("graficoESG").getContext("2d");

	            var myBarChart = new Chart(ctx, {
	                type: "bar",
	                data: {
	                    labels: labels,
	                    datasets: [{
	                        label: 'Frequência de notas',
	                        data: dados,
	                        backgroundColor: cores
	                        
	                    }]
	                    
	                },
	                options: {
	                    responsive: true,
	                    scales: {
	                        y: {
	                            beginAtZero: true
	                        }
	                    }
	                }
	            });
	        })
	        .catch(error => {
	            console.error('Erro ao buscar dados JSON para o gráfico dois:', error);
	        });
	    }
	    atualizarGraficoDois();
	});
	
	document.addEventListener("DOMContentLoaded", function() {
	    function atualizaQuantidade() {
	        fetch('graficos?acao=quantidade')
	            .then(response => response.json())
	            .then(data => {
	                // Verifica se a resposta contém um número
	                if (typeof data === 'number') {
	                    var quantidade = data;
	                    document.getElementById('paciente').innerHTML = " " + quantidade;
	                } else {
	                    console.error('A resposta do servidor não contém um número válido.');
	                }
	            })
	            .catch(error => {
	                console.error('Erro ao buscar dados JSON para o gráfico dois:', error);
	            });
	    }

	    atualizaQuantidade();
	});
	
	document.addEventListener("DOMContentLoaded", function() {
	    function atualizaMedia() {
	        fetch('graficos?acao=media')
	            .then(response => response.json())
	            .then(data => {
	                // Verifica se a resposta contém um número
	                if (typeof data === 'number') {
	                    var media = data;
	                    document.getElementById('media').innerHTML = " " + media;
	                } else {
	                    console.error('A resposta do servidor não contém um número válido.');
	                }
	            })
	            .catch(error => {
	                console.error('Erro ao buscar dados JSON para o gráfico dois:', error);
	            });
	    }

	    atualizaMedia();
	});
    
	document.addEventListener("DOMContentLoaded", function() {
	    function atualizarGraficoTres() {
	        fetch('graficos?acao=sexo')
	        .then(response => response.json())
	        .then(data => {
	            var sexos = data;
	       
	            var labels = ["M", "F"];
	            var cores = ["#2342EE ","#EE23D8 "];
	            var ctx = document.getElementById("graficoSexos").getContext("2d");

	            var myPieChart = new Chart(ctx, {
	                type: "doughnut",
	                data: {
	                    labels: labels,
	                    datasets: [{
	                        data: sexos,
	                        backgroundColor: cores
	                    }]
	                },
	                options: {
	                    responsive: true
	                }
	            });
	        })
	        .catch(error => {
	            console.error('Erro ao buscar dados JSON:', error);
	        });
	    }
	    atualizarGraficoTres();
	});



	</script>

</body>

</html>