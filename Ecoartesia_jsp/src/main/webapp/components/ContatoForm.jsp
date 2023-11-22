<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<section class="msg_sec">
  <div class="msg_container bg-image">
    <i class="fa-solid fa-xmark fa-fade msg_close"></i>
    <form id="contatoForm" action="/InserirContatos" method="post" onsubmit="enviarFormulario(); return false;">
      <h2>Contato</h2>

      <div class="form-group">
        <input type="text" name="nome" placeholder="Digite seu nome" required />
        <i class="fa-solid fa-user fa-fade name"></i>
      </div>

      <div class="form-group">
        <input type="email" name="email" placeholder="Digite seu email" required />
        <i class="fa-solid fa-envelope fa-fade email"></i>
      </div>
      <div class="form-group">
        <input type="tel" name="telefone" placeholder="Telefone" required />
        <i class="fa-solid fa-phone fa-fade phone"></i>
      </div>

      <div class="form-group" id="form-group-msg">
        <textarea name="mensagem" placeholder="Digite sua mensagem..." required></textarea>
        <i class="fa-regular fa-comment-dots fa-fade message"></i>
      </div>
      <button type="submit" class="msg_button">Enviar Mensagem</button>
    </form>
  </div>
</section>