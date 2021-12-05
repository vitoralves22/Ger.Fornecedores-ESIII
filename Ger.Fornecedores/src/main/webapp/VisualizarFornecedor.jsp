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
	
</head>

<body>

		<%
           Resultado resultado = (Resultado) request.getAttribute("resultado");
           Fornecedor fornecedor = (Fornecedor) session.getAttribute("VisualizarFornecedor");
        %>

	<header>
		<h1 class="header-title">Cadastro de Fornecedores</h1>
	</header>
	
	<main>
		
		 <div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Cadastrar Fornecedor</button>					
			<span id="spanSearch" class="search material-icons">search</span>
   		 </div>
			
		<table id="tableFornecedor" class="records">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome Fantasia</th>
					<th>CNPJ</th>
					<th>UF</th>
					<th>Tipo</th>
					<th>Contato</th>
					<th>Ativo</th>
				</tr>
			</thead>		

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    
                    <td></td>
                    <td></td>
                </tr>

		</table>
		
		
		<div class="modal" id="modal">
		<form action="${pageContext.request.contextPath}/AlterarFornecedor">
		
		
		
			<div class="modal-content">
				<nav class="nav_tabs">
					<ul>
						<li><input type="radio" id="tab1" class="rd_tab" name="tabs"
							checked> <span class="modal-close" id="modalClose">&#10006;</span>
							<label for="tab1" class="tab_label">Empresa</label>
							<div class="tab-content">
								<h1></h1>
								
								<div class="row">
								<div id="form" class="modal-form">
								
									<div class="form-group col-1">
				                        <label for="txtAlterarFornecedorId">Id: </label>
				                        <input type="text" class="form-control" value="<%=fornecedor.getId()%>" id="txtAlterarFornecedorId" name="txtAlterarFornecedorId" readonly>
                   					 </div>

									<div class="form-group col-5">
				                        <label for="txtForNomeFantasia">Nome Fantasia: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getNmFantasia()%>" id="txtForNomeFantasia" name="txtForNomeFantasia" placeholder="Nome fantasia" maxlength="30">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForRazaoSocial">Razao Social: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getRzSocial()%>" id="txtForRazaoSocial" name="txtForRazaoSocial" placeholder="Razao social" maxlength="30">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForCNPJ">Cnpj: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getCnpj()%>" id="txtForCNPJ" name="txtForCNPJ" placeholder="CNPJ" maxlength="14">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForInscricaoEstadual">Inscricao Estadual: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getInscricaoEstadual()%>" id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" placeholder="Insc. Estadual" maxlength="30">
                    				</div>
									
									<div class="form-group col-5">
				                        <label for="txtForInscricaoMunicipal">Inscricao Municipal: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getInscricaoMunicipal()%>" id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" placeholder="Insc. Municipal" maxlength="30">
                    				</div>
										
									<div class="form-group col-5">
				                        <label for="txtForEmail">Email: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getEmail()%>" id="txtForEmail" name="txtForEmail" placeholder="Email" maxlength="30">
                    				</div>
										
									<div class="form-group col-5">
				                        <label for="txtForTipoEmpresa">TipoEmpresa: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getEmpresa().getTipo()%>" id="txtForTipoEmpresa" name="txtForTipoEmpresa" placeholder="TipoEmpresa" maxlength="30">
                    				</div>
										
									<div class="form-group col-5">
				                        <label for="txtForTipoFornecimento">TipoFornecimento: </label>
				                        <input type="text" class="form-control" value="<%= fornecedor.getEmpresa().getTipoFornecimento()%>" id="txtForTipoFornecimento" name="txtForTipoFornecimento" placeholder="TipoFornecimento" maxlength="30">
                    				</div>
                    				
								</div>
								</div>		
							</div></li>
							
						<%-- <li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form2" class="modal-form">
									<input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" value="<%= fornecedor.getCnaes().get(0).getCodigo() %>"
										placeholder="CNAE" >

									<button type="button" class="button addContato"
										id="adicionarCnae">Add+</button>
											</div>
										</div></li>
									<li><input type="radio" name="tabs" class="rd_tab" id="tab3">
										<label for="tab3" class="tab_label">Fornecimento</label>
										<div class="tab-content">
											<h2></h2>
											<div id="form3" class="modal-form">
												<input id="txtDescProduto" name="txtDescProduto" type="text" class="modal-field" value="<%= proDescricao %>"
													placeholder="Produto"> 
												<input id="txtDescServico" name="txtDescServico" type="text" class="modal-field" value="<%= serDescricao %>"
													placeholder="Servico">
												
			
												<button type="button" class="button addContato"
													id="adicionarFornecimento">Add+</button>
											</div>
										</div></li>
									<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
										<label for="tab4" class="tab_label">Endereço</label>
										<div class="tab-content">
											<h2></h2>
											<div id="form4" class="modal-form">
												<input id="txtEndTipo" name="txtEndTipo" type="text" class="modal-field" value="<%= endTipo %>"
													placeholder="Tipo Endereço" > 
													
												<input id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" type="text" class="modal-field" value="<%= endTipoLogradouro %>"
													placeholder="Tipo Logradouro" > 
													
												<input id="txtEndLogradouro" name="txtEndLogradouro" type="text" class="modal-field" value="<%= endLogradouro %>"
													placeholder="Logradouro" > 
													
												<input id="txtEndNumero" name="txtEndNumero" type="text" class="modal-field" value="<%= endNumero %>"
													placeholder="Numero" >
													
												<input id="txtEndBairro" name="txtEndBairro" type="text" class="modal-field" value="<%= endBairro %>"
													placeholder="Bairro" > 
													
												<input id="txtEndCidade" name="txtEndCidade" type="text" class="modal-field" value="<%= endCidade %>"
													placeholder="Cidade" >
													
												<input id="txtEndEstadoUf" name="txtEndEstadoUf" type="text" class="modal-field" value="<%= endEstadoUf %>"
													placeholder="UF" > 
													
												<input id="txtEndPais" name="txtEndPais" type="text" class="modal-field" value="<%= endPais %>"
													placeholder="País" > 
													
												<input id="txtEndCEP" name="txtEndCEP" type="text" class="modal-field" value="<%= endCEP %>"
													placeholder="CEP" > 
													
												<input id="txtEndComplemento" name="txtEndComplemento" type="text" class="modal-field" value="<%= endComplemento %>"
													placeholder="Complemento">
											</div>
										</div></li>
									<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
										<label for="tab5" class="tab_label">Contato</label>
										<div class="tab-content">
											<h2></h2>
											<div id="form5" class="modal-form">
												<input id="txtCttnome" name="txtCttnome" type="text" class="modal-field" value="<%= cttNome %>"
													placeholder="Nome" > 
													
												<input id="txtCttemail" name="txtCttemail" type="email" class="modal-field" value="<%= cttEmail %>" 
													placeholder="Email" >
													
												<input id="txtCttdepartamento" name="txtCttdepartamento" type="text" class="modal-field" value="<%= cttDepartamento %>"
													placeholder="Departamento" > 
													
												<input id="txtTelDDI" name="txtTelDDI" type="text" class="modal-field" value="<%= cttTelDDI %>"
													placeholder="DDI" > 
													
												<input id="txtTelDDD" name="txtTelDDD" type="text" class="modal-field" value="<%= cttTelDDD %>"
													placeholder="DDD" >
													
												<input id="txtTelNumero" name="txtTelNumero" type="tel" class="modal-field" value="<%= cttTelNumero %>"
													placeholder="Telefone" >
												
												<button type="button" class="button addContato"
													id="adicionarContato">Add+</button>
											</div>
										</div></li>
									<li><input type="radio" name="tabs" class="rd_tab" id="tab6">
										<label for="tab6" class="tab_label">Telefone</label>
										<div class="tab-content">
											<h2></h2>
											<div id="form6" class="modal-form">
												<input id="ddd_telefone" name="ddd_telefone" type="text" class="modal-field" value="<%= telDDI %>"
													placeholder="DDD"> 
													
												<input id="ddi_telefone" name="ddi_telefone" type="text" class="modal-field" value="<%= telDDD %>"
													placeholder="DDI"> 
													
												<input id="numero_telefone" name="numero_telefone" type="tel" class="modal-field" value="<%= telNumero %>"
													placeholder="Numero">
													
												<button type="button" class="button addContato"
													id="adicionarTelefone">Add+</button>
											</div>
										</div></li> --%>
								</ul>
				</nav>
				<footer class="modal-footer">				
					  <input type="submit" class="btn btn-success"id="OPERACAO" name="OPERACAO" value="ALTERAR"/>
				</footer>
			</div>
			</form>
		</div>
	</main>
	<footer> </footer>
</html>