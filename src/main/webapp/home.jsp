<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="ISO-8859-1">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <style>
            body,
            html {
                margin: 0;
                padding: 0;
                height: 100%;
                overflow: hidden;
               
            }
    
            .carousel-container {
                position: relative;
                width: 100vw;
                height: 100vh;
                
            }
    
            .carousel {
                width: 100%;
                height: 100%;
               
            }
    
            .overlay {
                position: absolute;
                top: 30%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
                color: #fff;
            }
    
            .overlay img {
                max-width: 60%;
                max-height: 100%;
                display: block;
                margin:0 auto;
            }
    
            .btn-group {
                margin-top: 20px;
            }

            @keyframes blink {
            0% {
                opacity: 1;
            }

            50% {
                opacity: 0.50;
            }

            100% {
                opacity: 1;
            }
        }

        .blinking-image {
            animation: blink 1.25s infinite;
        }
        </style>
</head>

<body>
   
    <div class="carousel-container">

        <div id="meuCarrossel" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-inner opacity-25">
                <div class="carousel-item active shadow-lg">
                    <img src="./imagens/carr_um.jpg" class="d-block w-100" alt="Imagem 1">
                </div>
                <div class="carousel-item shadow-lg">
                    <img src="./imagens/carr_dois.jpg" class="d-block w-100" alt="Imagem 2">
                </div>
                <div class="carousel-item shadow-lg">
                    <img src="./imagens/carr_tres.jpg" class="d-block w-100" alt="Imagem 3">
                </div>
                <div class="carousel-item shadow-lg">
                    <img src="./imagens/carr_quatro.jpg" class="d-block w-100" alt="Imagem 4">
                </div>
                <div class="carousel-item shadow-lg">
                    <img src="./imagens/carr_cinco.jpg" class="d-block w-100" alt="Imagem 5">
                </div>
    
            </div>
        </div>
    
        <div class="overlay">
            <img src="./imagens/logoMed.png" alt="Imagem de sobreposição" class="blinking-image">
            <div class="d-flex flex-column w-50 justify-content-center" style="margin-left: 12vw;">
                <a href="login-paciente.jsp"><button type="button" class="btn btn-primary w-100">PACIENTE</button></a>
                <a href="login-medico.jsp"><button type="button" class="btn btn-primary mt-2 w-100">MÉDICO</button></a>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous">
    </script>
</body>

</html>
    