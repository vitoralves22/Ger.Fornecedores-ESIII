<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="dominio.*"%>
<%@page import="core.aplicacao.Resultado"%>
<%@page import="web.command.*"%>
<%@page import="web.controle.*"%>
<%@page import="web.viewHelper.*"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<title>CRUD</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Karla:ital,wght@0,400;0,700;1,200;1,800&display=swap">
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/button.css">
	<link rel="stylesheet" href="css/records.css">
	<link rel="stylesheet" href="css/modal.css">
	<link rel="stylesheet" href="css/tabs.css">
	<link rel="stylesheet" href="css/checkbox.css">
	<link rel="stylesheet" href="css/span.css">
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/icon?family=Material+Icons">	
		<script src="main.js" defer></script> 
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		
</head>

<body>

	    <%
            Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao");
        %>                
        
	<header>
		<h1 class="header-title">Cadastro de Fornecedores</h1>
	</header>
	
	<main>
	
		 <div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Cadastrar Fornecedor</button>					
			<span id="spanSearch" class="search material-icons">search</span>
   		 </div>
		
		
		<form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ConsultarFornecedor">
              <input type="text" class="form-control" id="txtPesquisa"name="txtPesquisa" placeholder="Pesquisa">
              <input class="btn btn-info" type="submit" id="OPERACAO" name="OPERACAO" value="CONSULTAR" />
        </form>
			
		<table id="tableFornecedor" class="records">
				<thead>
                    <tr>
						<th>ID</th>
						<th>Nome Fantasia</th>
						<th>CNPJ</th>
						<th>Email</th>
						<th>Status</th>	
						<th>Visualizar</th>	
						<th>Excluir</th>	
									
					</tr>
                </thead>		

                <%
                    if (resultado != null) {
                        List<EntidadeDominio> fornecedores = resultado.getEntidades();
                        if (fornecedores != null) {
                            for (int i = 0; i < fornecedores.size(); i++) {
                                Fornecedor f = (Fornecedor) fornecedores.get(i);

                                
                %>
                 <tr>
                    <td><%= f.getId()%></td>
                    <td><%= f.getNmFantasia()%></td>
                    <td><%= f.getCnpj()%></td>
                    <td><%= f.getEmail()%></td>
                    <td><%= f.getStatus()%></td>
                    <td><a href="${pageContext.request.contextPath}/ConsultarFornecedor?txtListaId=<%=f.getId()%>&OPERACAO=VISUALIZAR" class="btn btn-default" >Visualizar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirFornecedor?OPERACAO=EXCLUIR&txtListaId=<%=f.getId()%>" class="btn btn-default" >Excluir</a></td>
                </tr>

                <%
                                
                            }
                        }
                    }
                %>

		</table>
		
		
		<div class="modal" id="modal">
			<form action="${pageContext.request.contextPath}/SalvarFornecedor">
		
			<%     
	            Resultado resultadoCadastro = (Resultado) request.getAttribute("resultado");
	            Resultado fornecedoresCadastro = (Resultado) session.getAttribute("fornecedorSessao");
            %>
    
		
			<div class="modal-content">
			
					<script>
						$(document).ready(function () {
						  var wrapperCnaes = $(".wrapperCnaes"); //Fields wrapper
						  var addCnaeButton = $("#addCnaeButton"); //Add button ID
				  
						  $(addCnaeButton).click(function (e) { //on add input button click
							e.preventDefault();
							$(wrapperCnaes).append('<div id="form2" class="modal-form"><input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" placeholder="CNAE"><a style="text-align:right" href="#" class="remove_field">Remover CNAE</a></div>');
						  });
				  
						  $(wrapperCnaes).on("click", ".remove_field", function (e) { //user click on remove text
							e.preventDefault(); $(this).parent('div').remove(); x--;
						  })
				  
						});
	  				</script>
	  				
	  				<script>
						$(document).ready(function () {
						  var wrapperTels = $(".wrapperTelefones"); //Fields wrapper
						  var addTelButton = $("#addTel"); //Add button ID
				  
						  $(addTelButton).click(function (e) { //on add input button click
							e.preventDefault();
							$(wrapperTels).append('<div id="form6" class="modal-form"><input id="ddd_telefone" type="text" name="ddd_telefone" class="modal-field" placeholder="DDD"><input id="ddi_telefone" type="text" name="ddi_telefone" class="modal-field" placeholder="DDI"><input id="numero_telefone" type="text" name="numero_telefone" class="modal-field" placeholder="Numero"><a style="text-align:right" href="#" class="remove_field">Remover Telefone</a></div>');
						  });
				  
						  $(wrapperTels).on("click", ".remove_field", function (e) { //user click on remove text
							e.preventDefault(); $(this).parent('div').remove(); x--;
						  })
				  
						});
	  				</script>
	  				
	  				<script>
						$(document).ready(function () {
						  var wrapperCtts = $(".wrapperContatos"); //Fields wrapper
						  var addCttButton = $("#addCtt"); //Add button ID
				  
						  $(addCttButton).click(function (e) { //on add input button click
							e.preventDefault();
							$(wrapperCtts).append('<div id="form5" class="modal-form"><input id="txtCttnome" type="text" name="txtCttnome" class="modal-field" placeholder="Nome"><input id="txtCttemail" type="text" name="txtCttemail" class="modal-field" placeholder="Email"><input id="txtCttdepartamento" type="text" name="txtCttdepartamento" class="modal-field" placeholder="Departamento"><input id="txtTelDDI" type="text" name="txtTelDDI" class="modal-field" placeholder="DDI"><input id="txtTelDDD" type="text" name="txtTelDDD" class="modal-field" placeholder="DDD"><input id="txtTelNumero" type="text" name="txtTelNumero" class="modal-field" placeholder="Numero Tel"><a style="text-align:right" href="#" class="remove_field">Remover Telefone</a></div>');
						  });
				  
						  $(wrapperCtts).on("click", ".remove_field", function (e) { //user click on remove text
							e.preventDefault(); $(this).parent('div').remove(); x--;
						  })
				  
						});
	  				</script>
	  				
	  				
	  				<script>
						$(document).ready(function () {
						  var wrapperForn = $(".wrapperFornecimento"); //Fields wrapper
						  var addFornButton = $("#addFornecimento"); //Add button ID
				  
						  $(addFornButton).click(function (e) { //on add input button click
							e.preventDefault();
							$(wrapperForn).append('<div id="form3" class="modal-form"><input id="txtDescProduto" type="text" name="txtDescProduto" class="modal-field" placeholder="Produto"><input id="txtDescServico" type="text" name="txtDescServico" class="modal-field" placeholder="Servico"><a style="text-align:right" href="#" class="remove_field">Remover</a></div>');
						  });
				  
						  $(wrapperForn).on("click", ".remove_field", function (e) { //user click on remove text
							e.preventDefault(); $(this).parent('div').remove(); x--;
						  })
				  
						});
	  				</script>
	  				
	  				
				<nav class="nav_tabs">
					<ul>
						<li><input type="radio" id="tab1" class="rd_tab" name="tabs"
							checked> <span class="modal-close" id="modalClose">&#10006;</span>
							<label for="tab1" class="tab_label">Empresa</label>
							<div class="tab-content">
								<h1></h1>
								<div id="form" class="modal-form">

									<input id="txtForNomeFantasia" name="txtForNomeFantasia"  type="text" data-index="new" class="modal-field"
										placeholder="Nome Fantasia" >

									<input id="txtForRazaoSocial" name="txtForRazaoSocial" type="text" class="modal-field"
										placeholder="Razão Social" > 
										
									<input id="txtForCNPJ" name="txtForCNPJ" type="text" class="modal-field" 
										placeholder="CNPJ" maxlength="14"> 
									
									<input id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" type="text" class="modal-field" 
										placeholder="Inscrição Estadual" maxlength="11" > 
									
									<input id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" type="text" class="modal-field" 
										placeholder="Inscrição Municipal" maxlength="11"> 
										
									<input id="txtForEmail" name="txtForEmail" type="text" class="modal-field"
										placeholder="Email" > 
										
									<input id="txtForTipoEmpresa" name="txtForTipoEmpresa" type="text" class="modal-field"
										placeholder="Tipo Empresa" > 
										
									<input id="txtForTipoFornecimento" name="txtForTipoFornecimento" type="text" class="modal-field"
										placeholder="Tipo Fornecimento" >

								</div>
							</div></li>
							
							
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperCnaes">
								<div id="form2" class="modal-form">
								
									<input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" 
										placeholder="CNAE" >

									<button type="button" class="button addContato"
										id="addCnaeButton">Add+</button>
								</div>
								</div>
								
							</div></li>
							
							
						<li><input type="radio" name="tabs" class="rd_tab" id="tab3">
							<label for="tab3" class="tab_label">Fornecimento</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperFornecimento">
								<div id="form3" class="modal-form">
								
									<input id="txtDescProduto" name="txtDescProduto" type="text" class="modal-field" 
										placeholder="Produto"> 
											
									<input id="txtDescServico" name="txtDescServico" type="text" class="modal-field" 
										placeholder="Servico">
									
									<button type="button" class="button addContato"
										id="addFornecimento">Add+</button>
								</div>	
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
							<label for="tab4" class="tab_label">Endereço</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form4" class="modal-form">
									<input id="txtEndTipo" name="txtEndTipo" type="text" class="modal-field" 
										placeholder="Tipo Endereço" > 
										
									<input id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" type="text" class="modal-field"
										placeholder="Tipo Logradouro" > 
										
									<input id="txtEndLogradouro" name="txtEndLogradouro" type="text" class="modal-field" 
										placeholder="Logradouro" >
										
									<input id="txtEndNumero" name="txtEndNumero" type="text" class="modal-field" 
										placeholder="Numero" >
										
									<input id="txtEndBairro" name="txtEndBairro" type="text" class="modal-field"
										placeholder="Bairro" > 
										
									<input id="txtEndCidade" name="txtEndCidade" type="text" class="modal-field"
										placeholder="Cidade" >
										
									<input id="txtEndEstadoUf" name="txtEndEstadoUf" type="text" class="modal-field"
										placeholder="UF" maxlength="2"> 
										
									<input id="txtEndPais" name="txtEndPais" type="text" class="modal-field"
										placeholder="País" > 
										
									<input id="txtEndCEP" name="txtEndCEP" type="text" class="modal-field"
										placeholder="CEP" maxlength="8"> 
										
									<input id="txtEndComplemento" name="txtEndComplemento" type="text" class="modal-field"
										placeholder="Complemento">
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
							<label for="tab5" class="tab_label">Contato</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperContatos">
								<div id="form5" class="modal-form">
									<input id="txtCttnome" name="txtCttnome" type="text" class="modal-field" 
										placeholder="Nome" > 
										
									<input id="txtCttemail" name="txtCttemail" type="email" class="modal-field" 
										placeholder="Email" >
										
									<input id="txtCttdepartamento" name="txtCttdepartamento" type="text" class="modal-field" 
										placeholder="Departamento" > 
										
									<input id="txtTelDDI" name="txtTelDDI" type="text" class="modal-field" 
										placeholder="DDI" maxlength="3"> 
										
									<input id="txtTelDDD" name="txtTelDDD" type="text" class="modal-field" 
										placeholder="DDD" maxlength="2">
										
									<input id="txtTelNumero" name="txtTelNumero" type="tel" class="modal-field" 
										placeholder="Telefone" maxlength="9">
									
									<button type="button" class="button addContato"
										id="addCtt">Add+</button>
								</div>
								</div>
							</div></li>
							
						<li><input type="radio" name="tabs" class="rd_tab" id="tab6">
							<label for="tab6" class="tab_label">Telefone</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperTelefones">
								<div id="form6" class="modal-form">
									<input id="ddd_telefone" name="ddd_telefone" type="text" class="modal-field" 
										placeholder="DDD" maxlength="2"> 
										
									<input id="ddi_telefone" name="ddi_telefone" type="text" class="modal-field" 
										placeholder="DDI" maxlength="3"> 
										
									<input id="numero_telefone" name="numero_telefone" type="tel" class="modal-field" 
										placeholder="Numero">
										
									<button type="button" class="button addContato"
										id="addTel">Add+</button>
								</div>
								</div>
							</div></li>
							
					</ul>
				</nav>
				<footer class="modal-footer">				
					 <input type="submit" class="button save" id="OPERACAO" name="OPERACAO" value="SALVAR"/>
				</footer>
			</div>
			</form>
		</div>
				<div>
                    <h5>
                        <%
                            if (resultadoCadastro != null && resultado.getMsg() != null) {
                                out.print(resultado.getMsg());

                            }
                        %>
                    </h5>
                </div>
	</main>
	<footer> </footer>
</html>