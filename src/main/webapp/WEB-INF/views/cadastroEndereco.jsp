<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Endereço</title>

		<c:url value="/resources/css" var="cssPath" />
		<c:url value="/resources/js" var="jsPath" />
		

		 <!-- Estilo Bootstrap -->
		<link rel="stylesheet" href="${cssPath}/bootstrap.css">
		<link rel="stylesheet" href="${cssPath}/datatables.css">
		<link rel="stylesheet" href="${cssPath}/jquery.dataTables.css">
		
		<!-- JS Bootstrap -->
		
		<!-- JS Projeto -->		
		<script src="${jsPath}/jquery-3.0.0.js"></script>
		<script src="${jsPath}/jquery.min.js"></script>		
		<script src="${jsPath}/bootstrap.js"></script>
		<script src="${jsPath}/bootstrap.min.js"></script>
		<script src="${jsPath}/datatables.js"></script>
		<script src="${jsPath}/jquery.dataTables.js"></script>		
		
		<!-- Estilo Projeto -->		
		<link rel="stylesheet" href="${cssPath}/style.css">
		

</head>
<body>
	

	<div class="container">
	
			<div class="col-lg-12">
				
			<h2>Lista Endereços Cadastrados</h2>
	
	<div class="form-row" style="margin-top: 30px;margin-bottom: 30px;">
	    <div class="form-group col-md-10">
	      <label for="rua">Informe o Id do endereço para Filtrar</label>      
	      <input type="text" id="myInput" class="form-control" onkeyup="filterById()" placeholder="Informe o Id do endereço" title="Informe o Id">
	    </div>		
	</div>			
					<table id="tabelaEnderecos" class="table table-hover">						
							<thead>
								<tr>
									<th scope="col">id</th>
									<th scope="col">rua</th>
									<th scope="col">número</th>
									<th scope="col">complemento</th>
									<th scope="col">bairro</th>
									<th scope="col">cep</th>									
									<th scope="col">cidade</th>
									<th scope="col">estado</th>
									<th scope="col">ações</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="endereco" items="${listaEnderecos}">
									<tr id="endereco${endereco.id}">
										<td><c:out value="${endereco.id}" /></td>
										<td><c:out value="${endereco.rua}" /></td>
										<td><c:out value="${endereco.numero}" /></td>
										<td><c:out value="${endereco.complemento}" /></td>
										<td><c:out value="${endereco.bairro}" /></td>
										<td><c:out value="${endereco.cep}" /></td>
										<td><c:out value="${endereco.cidade}" /></td>
										<td><c:out value="${endereco.estado}" /></td>
										<td>
											<a href="javascript:;" onclick="editar(${endereco.id})" class="btn btn-warning btn-xs">editar</a>											
											<a href="javascript:;" onclick="deletar(${endereco.id})" class="btn btn-danger btn-xs">excluir</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
					</table>
				</div>
			        		 
        		 <div class="col-lg-10">
        		 	
        		 	<h2>Cadastro de Endereço</h2>
     
						<form:form id="formEndereco">
						
						<input type="hidden" id="id" name="id">
						
					  <div class="form-row">
					    <div class="form-group col-md-10">
					      <label for="rua">Rua:</label>
					      <input type="text" class="form-control" name="rua" id="rua" placeholder="rua" required>
					    </div>
					    <div class="form-group col-md-2">
					      <label for="numero">Número:</label>
					      <input type="number" class="form-control" name="numero" id="numero" placeholder="numero" required>
					    </div>
					  </div>
					  <div class="form-group col-md-6">
					    <label for="complemento">Complemento:</label>
					    <input type="text" class="form-control" name="complemento" id="complemento" placeholder="complemento">
					  </div>
					  <div class="form-group col-md-6">
					    <label for="cep">Cep:</label>
					    <input type="number" class="form-control" name="cep" id="cep" maxlength="8" placeholder="00000000" required>
					  </div>
					  <div class="form-group col-md-12">
					    <label for="bairro">Bairro:</label>
					    <input type="text" class="form-control" name="bairro" id="bairro" placeholder="bairro">
					  </div>
					  <div class="form-row">
					    <div class="form-group col-md-6">
					      <label for="cidade">Cidade</label>
					      <input type="text" class="form-control" name="cidade" id="cidade" placeholder="cidade" required>
					    </div>
					    <div class="form-group col-md-4">
					      <label for="estado">Estado</label>
					      <input type="text" class="form-control" name="estado" id="estado" placeholder="estado" required>
					    </div>
					  </div>
					  <div class="form-row">
					  	<div class="form-group col-md-12">
					  		<button type="submit" id="submitForm" class="btn btn-primary"><span id="textButton"></span></button>
					  		<button type="button" onclick="reloadPage();" id="submitForm" class="btn btn-primary">cancelar</button>
					  	</div>
					  </div>
					</form:form>
				</div>
				
							
		</div>
		
</body>

<script type="text/javascript">

$(document).ready(function(){

	$("#textButton").text("cadastrar");
	
});
	function reloadPage(){
		window.location.reload();
	}


	function filterById() {
		  var input, filter, table, tr, td, i;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("tabelaEnderecos");
		  tr = table.getElementsByTagName("tr");
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[0];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }       
		  }
		}

	$('#formEndereco').submit( function() {

		debugger;
		
		var id = $("#id").val();	
		
		if(id == "" || id == null){
		
			var dados = {					
			    "rua": $("#rua").val(),
			    "numero": $("#numero").val(),
			    "bairro": $("#bairro").val(),
			    "complemento": $("#complemento").val(),
			    "cep": $("#cep").val(),
			    "cidade": $("#cidade").val(),
			    "estado": $("#estado").val()
			};	
			
			
	    $.ajax({
	        url: '/v2/endereco',
	        type: 'POST',
	        contentType: "application/json",
	        dataType: 'json',
	        data: JSON.stringify(dados),
	        success: function(data) {
	        	reloadPage();
	        	alert("Endereço cadastrado com sucesso.");
	        },
	        error: function(data){	        	
	        	alert("Ocorreu um erro.")
		    }
	    });
	    
	  }else{

		  var dados = {				  
			  	"id": $("#id").val(),
			    "rua": $("#rua").val(),
			    "numero": $("#numero").val(),
			    "bairro": $("#bairro").val(),
			    "complemento": $("#complemento").val(),
			    "cep": $("#cep").val(),
			    "cidade": $("#cidade").val(),
			    "estado": $("#estado").val()	
			};
		  
		  $.ajax({
		        url: '/v2/endereco/'+ id,
		        type: 'PUT',
		        contentType: "application/json",
		        dataType: 'json',
		        data: JSON.stringify(dados),
		        success: function(data) {
		        	reloadPage();
		        	alert("Endereço atualizado com sucesso.");
		        },
		        error: function(data){	        	
		        	alert("Ocorreu um erro.")
			    }
		    });
	  }
	});
	
	function deletar(id){		
		$.ajax({
	        url: '/v2/endereco/' + id,
	        type: 'DELETE',
	        dataType: "JSON",
	        data:{
	        	id : id
	        },
	        success: function(data) {		        
	        	reloadPage();
	        },
	        complete: function(data){
	        	reloadPage();
	        	alert("Endereço deletado com sucesso.")
		    }
	    });
	}
	
	
	function editar(id){
		$.ajax({
	        url: '/v2/endereco/'+ id,
	        type: 'GET',
	        contentType: "application/json",
	        dataType: 'json',
	        data: {
	        	id : id
	        },
	        success: function(data) {

	        	$("#id").val(data.id);
	    		$("#rua").val(data.rua);
	    	    $("#numero").val(data.numero);
	    	    $("#bairro").val(data.bairro);
	    	    $("#complemento").val(data.complemento);
	    	    $("#cep").val(data.cep);
	    	    $("#cidade").val(data.cidade);
	    	    $("#estado").val(data.estado);

	    	    $("#textButton").text("atualizar");
	        	
	        },
	        error: function(data){	        	
	        	alert("Ocorreu um erro.")
		    }
	    });
		
	}

</script>

</html>