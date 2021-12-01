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
	<header>
		<h1 class="header-title">Cadastro de Fornecedores</h1>
	</header>
	 <%
	 	//Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao"); 
	 	Resultado resultado = (Resultado) request.getAttribute("resultado");
     
      %>
	<main>
		<div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Cadastrar Fornecedor</button>
    		<a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Voltar</a>	
    		  		
    		<form action="${pageContext.request.contextPath}/ConsultarFornecedor">				
    			<input type="text" class="form-control" id="txtPesquisa"name="txtPesquisa" placeholder="Pesquisa">
                <input class="btn btn-info" type="submit" id="OPERACAO" name="OPERACAO" value="CONSULTAR" />
    		</form>
    			
    			
			<span id="spanSearch" class="search material-icons">search</span>
   		 </div>
			
		<table id="tableFornecedor" class="records">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome Fantasia</th>
					<th>CNPJ</th>				
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
                    <td><a href="${pageContext.request.contextPath}/ConsultarFornecedor?txtListaId=<%=f.getId()%>&OPERACAO=VISUALIZAR" class="btn btn-default" >Visualizar</a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirFornecedor?OPERACAO=EXCLUIR&txtListaId=<%=f.getId()%>" class="btn btn-default" >Excluir</a></td>
                </tr>

                <%
                                
                            }
                        }
                    }
                %>
		</table>
		
		<!-- SE PRECISAR MOSTRAR O MODAL NA LISTAGEM DESCOMENTAR -->
		<%-- <div class="modal" id="modal">
		<form action="${pageContext.request.contextPath}/SalvarFornecedor">
			<div class="modal-content">
				<nav class="nav_tabs">
					<ul>
						<li><input type="radio" id="tab1" class="rd_tab" name="tabs"
							checked> <span class="modal-close" id="modalClose">&#10006;</span>
							<label for="tab1" class="tab_label">Empresa</label>
							<div class="tab-content">
								<h1></h1>
								<div id="form" class="modal-form">

									<input id="txtForNomeFantasia" name="txtForNomeFantasia"  type="text" data-index="new" class="modal-field" value="<%= nomeFantasia %>"
										placeholder="Nome Fantasia" >

									<input id="txtForRazaoSocial" name="txtForRazaoSocial" type="text" class="modal-field" value="<%= razaoSocial %>"
										placeholder="Razão Social" > 
										
									<input id="txtForCNPJ" name="txtForCNPJ" type="text" class="modal-field" value="<%= cnpj %>"
										placeholder="CNPJ" > 
									
									<input id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" type="text" class="modal-field" value="<%= inscricaoEstadual %>"
										placeholder="Inscrição Estadual" > 
									
									<input id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" type="text" class="modal-field" value="<%= inscricaoMunicipal %>"
										placeholder="Inscrição Municipal" > 
										
									<input id="txtForEmail" name="txtForEmail" type="text" class="modal-field" value="<%= email %>"
										placeholder="Email" > 
										
									<input id="txtForTipoEmpresa" name="txtForTipoEmpresa" type="text" class="modal-field" value="<%= tipoEmpresa %>"
										placeholder="Tipo Empresa" > 
										
									<input id="txtForTipoFornecimento" name="txtForTipoFornecimento" type="text" class="modal-field" value="<%= tipoFornecimento %>"
										placeholder="Tipo Fornecimento" >

								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form2" class="modal-form">
									<input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" value="<%= codigo %>"
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
									<input id="descricao_fornecimento" type="text" class="modal-field" value="<%= srvDescricao %>"
										placeholder="Descrição">

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
									<!--  <input id="ramal_contato" type="text" class="modal-field" placeholder="Ramal">
                                    <input id="codigo_contato" type="text" class="modal-field" placeholder="Código">
                                    <input id="descricao_contato" type="text" class="modal-field"
                                        placeholder="Descrição"> -->
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
							</div></li>
					</ul>
				</nav>
				<footer class="modal-footer">
					<button id="salvar" class="button save">Salvar</button>
					 <input type="submit" class="button save" id="OPERACAO" name="OPERACAO" value="SALVAR"/>
					<button id="cancelar" class="button cancel">Cancelar</button>
				</footer>
			</div>
			</form>
		</div> --%>
	</main>
	<footer> </footer>
</html>