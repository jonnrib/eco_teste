<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <title>Cursos</title>
    <meta
      name="description"
      content="Conheça a Ecoartesia, uma organização comprometida com a promoção da conscientização ambiental, diversidade e sustentabilidade. Explore nossos projetos, cursos que visam criar um futuro mais inclusivo e ecologicamente responsável. Junte-se a nós na busca por fazer a diferença no mundo." />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="robots" content="index,follow" />
    <meta name="author" content="Squad 32" />
    <meta name="copyright" content="Squad 32" />
    <!-- Favicon -->
    <link rel="icon" type="image/png" sizes="192x192" href="assets/img/android-chrome-192x192.png" />
    <link rel="icon" type="image/png" sizes="512x512" href="assets/img/android-chrome-512x512.png" />
    <link rel="apple-touch-icon" sizes="180x180" href="assets/img/apple-touch-icon.png" />
    <link rel="icon" type="image/x-icon" href="assets/img/favicon.ico" />
    <link rel="icon" type="image/png" sizes="16x16" href="assets/img/favicon-16x16.png" />
    <link rel="icon" type="image/png" sizes="32x32" href="assets/img/favicon-32x32.png" />
    <link rel="manifest" href="../site.webmanifest" />
    <!-- CSS do Bootstrap -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
      crossorigin="anonymous" />
    <!-- Arquivo CSS -->
    <link rel="stylesheet" href="assets/css/cursos.css" />
    <!-- Ícones -->
    <script src="https://kit.fontawesome.com/5ec96718ca.js" crossorigin="anonymous"></script>
    <!-- Fontes -->
    <link
      href="https://www.dafontfree.net/embed/YWxiZXJ0dXMtbWVkaXVtLXJlZ3VsYXImZGF0YS8zMTEvbi8xODI2NzAvTm8tY3JtbnkudHRm"
      rel="stylesheet"
      type="text/css" />
  </head>

  <body class="d-flex flex-column bg-image">
    <!-- Header -->
    <header class="header">
      <!-- Barra de Navegação -->
      <jsp:include page="components/navbar.jsp" />
    </header>

    <!-- Escurece o fundo quando o menu hamburguer é aberto -->
    <div id="overlay"></div>

    <!-- Home -->
    <section class="home">
      <!-- Formulário de Contato -->
      <jsp:include page="components/ContatoForm.jsp" />

      <!-- Formulário de login e cadastro-->
      <jsp:include page="components/LoginCadastroForm.jsp" />

      <!-- Conteúdo da página -->
      <div class="video-container">
        <main class="page-content">
          <!-- Player de Vídeo -->
          <section class="main-video">
            <video src="assets/vid/Diversidade e inclusão.mp4" controls autoplay muted></video>
            <h3 class="title">Diversidade e inclusão</h3>
          </section>
          <!-- Lista de Vídeos -->
          <section class="video-playlist">
            <div class="videos"></div>
          </section>
        </main>
      </div>
    </section>

    <!-- Início do Rodapé -->
    <jsp:include page="components/footer.jsp" />

    <!-- Link para o JavaScript do Bootstrap -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
      crossorigin="anonymous"></script>

    <!-- Link do JavaScript -->
    <script src="assets/js/cursos.js"></script>
  </body>
</html>
