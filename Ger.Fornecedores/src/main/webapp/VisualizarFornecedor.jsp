<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
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
         Resultado resultado = (Resultado) request.getAttribute("fornecedorSessao");
         Fornecedor fornecedor = (Fornecedor) session.getAttribute("fornecedorSessao"); 
     %>
	<main>
		
		<div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Cadastrar Fornecedor</button> 		
    		    		
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
					<th>UF</th>
					<th>Tipo</th>
					<th>Contato</th>
					<th>Ativo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<div class="form-group">
							<input class="checkbox" id="checkbox1" type='checkbox' />
						</div>
					</td>
					<td><span class="edit material-icons"> edit</span> <span
						class="consult material-icons">description</span> <span
						class="delete material-icons">delete</span></td>
				</tr>

			</tbody>
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
								<div id="form" class="modal-form">
									<input type="text" class="form-control" value="<%= fornecedor.getId %>" id="txtAlterarClienteId" name="txtAlterarClienteId" readonly>
									
									<input id="txtForNomeFantasia" name="txtForNomeFantasia"  type="text" data-index="new" class="modal-field" value="<%= fornecedor.getNmFantasia() %>"
										placeholder="Nome Fantasia" required>

									<input id="txtForRazaoSocial" name="txtForRazaoSocial" type="text" class="modal-field" value="<%= fornecedor.getRzSocial() %>"
										placeholder="Razão Social" required> 
										
									<input id="txtForCNPJ" name="txtForCNPJ" type="text" class="modal-field" value="<%= fornecedor.getCnpj() %>"
										placeholder="CNPJ" required> 
									
									<input id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" type="text" class="modal-field" value="<%= fornecedor.getInscricaoEstadual() %>"
										placeholder="Inscrição Estadual" required> 
									
									<input id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" type="text" class="modal-field" value="<%= fornecedor.getInscricaoMunicipal() %>"
										placeholder="Inscrição Municipal" required> 
										
									<input id="txtForEmail" name="txtForEmail" type="text" class="modal-field" value="<%= fornecedor.getEmail() %>"
										placeholder="Email" required> 
										
									<input id="txtForTipoEmpresas" name="txtForTipoEmpresas" type="text" class="modal-field" value="<%= fornecedor.getEmpresas().get(0).getTipoEmpresa() %>"
										placeholder="Tipo Empresa" required> 
										
									<input id="txtForTipoFornecimento" name="txtForTipoFornecimento" type="text" class="modal-field" value="<%= fornecedor.getEmpresas().get(0).getTipoFornecimento() %>"
										placeholder="Tipo Fornecimento" required>

								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form2" class="modal-form">
									<input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" value="<%= fornecedor.getCnaes().get(0).getCodigo() %>"
										placeholder="CNAE" required>

									<button type="button" class="button addContato"
										id="adicionarCnae">Add+</button>
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab3">
							<label for="tab3" class="tab_label">Fornecimento</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form3" class="modal-form">
									<input id="tipo_fornecimento" name="tipo_fornecimento" type="text" class="modal-field" value="<%= fornecedor.getEmpresas().get(0).getTipoFornecimento() %>"
										placeholder="Tipo"> 
									<input id="descricao_fornecimento" name="descricao_fornecimento" type="text" class="modal-field" value="<%= fornecedor.getProdutosOfertados().get(0).getDescricao() %>"
										placeholder="Descrição">
									<input id="descricao_fornecimento" type="text" class="modal-field" value="<%= fornecedor.getProdutosOfertados().get(0).getDescricao() %>"
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
									<input id="txtEndTipo" name="txtEndTipo" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getTipo() %>"
										placeholder="Tipo Endereço" required> 
										
									<input id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getTipoLogradouro() %>"
										placeholder="Tipo Logradouro" required> 
										
									<input id="txtEndLogradouro" name="txtEndLogradouro" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getLogradouro() %>"
										placeholder="Logradouro" required> 
										
									<input id="txtEndNumero" name="txtEndNumero" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getNumero() %>"
										placeholder="Numero" required>
										
									<input id="txtEndBairro" name="txtEndBairro" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getBairro() %>"
										placeholder="Bairro" required> 
										
									<input id="txtEndCidade" name="txtEndCidade" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getCidade() %>"
										placeholder="Cidade" required>
										
									<input id="txtEndEstadoUf" name="txtEndEstadoUf" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getEstadoUf() %>"
										placeholder="UF" required> 
										
									<input id="txtEndPais" name="txtEndPais" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getPais() %>"
										placeholder="País" required> 
										
									<input id="txtEndCEP" name="txtEndCEP" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getCep() %>"
										placeholder="CEP" required> 
										
									<input id="txtEndComplemento" name="txtEndComplemento" type="text" class="modal-field" value="<%= fornecedor.getEndereco().getComplemento() %>"
										placeholder="Complemento">
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
							<label for="tab5" class="tab_label">Contato</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form5" class="modal-form">
									<input id="txtCttnome" name="txtCttnome" type="text" class="modal-field" value="<%= fornecedor.getContatos().get(0).getNome() %>"
										placeholder="Nome" required> 
										
									<input id="txtCttemail" name="txtCttemail" type="email" class="modal-field" value="<%= fornecedor.getContatos().get(0).getEmail() %>" 
										placeholder="Email" required>
										
									<input id="txtCttdepartamento" name="txtCttdepartamento" type="text" class="modal-field" value="<%= fornecedor.getContatos().get(0).getDepartamento() %>"
										placeholder="Departamento" required> 
										
									<input id="txtTelDDI" name="txtTelDDI" type="text" class="modal-field" value="<%= fornecedor.getContatos().get(0).getTelefone().getDdi() %>"
										placeholder="DDI" required> 
										
									<input id="txtTelDDD" name="txtTelDDD" type="text" class="modal-field" value="<%= fornecedor.getContatos().get(0).getTelefone().getDdd() %>"
										placeholder="DDD" required>
										
									<input id="txtTelNumero" name="txtTelNumero" type="tel" class="modal-field" value="<%= fornecedor.getContatos().get(0).getTelefone().getNumero() %>"
										placeholder="Telefone" required>
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
									<input id="ddd_telefone" name="ddd_telefone" type="text" class="modal-field" value="<%= fornecedor.getTelefones().get(0).getDdi() %>"
										placeholder="DDD"> 
										
									<input id="ddi_telefone" name="ddi_telefone" type="text" class="modal-field" value="<%= fornecedor.getTelefones().get(0).getDdd() %>"
										placeholder="DDI"> 
										
									<input id="numero_telefone" name="numero_telefone" type="tel" class="modal-field" value="<%= fornecedor.getTelefones().get(0).getNumero()%>"
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
		</div>
	</main>
	<footer> </footer>
</html>

 --%>