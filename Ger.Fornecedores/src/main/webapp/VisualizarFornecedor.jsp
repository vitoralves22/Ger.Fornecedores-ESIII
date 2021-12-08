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
	
	<main>
		
		 <div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Alterar Fornecedor</button>					
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
		
			<%
	           Resultado resultadoVisualizar = (Resultado) request.getAttribute("resultado");
	           Fornecedor fornecedorVisualizar = (Fornecedor) session.getAttribute("VisualizarFornecedor");
	        %>
		
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
				                        <input type="text" class="form-control" value="<%=fornecedorVisualizar.getId()%>" id="txtAlterarFornecedorId" name="txtAlterarFornecedorId" readonly>
                   					 </div>

									<div class="form-group col-5">
				                        <label for="txtForNomeFantasia">Nome Fantasia: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getNmFantasia()%>" id="txtForNomeFantasia" name="txtForNomeFantasia" placeholder="Nome fantasia" maxlength="30">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForRazaoSocial">Razao Social: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getRzSocial()%>" id="txtForRazaoSocial" name="txtForRazaoSocial" placeholder="Razao social" maxlength="30">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForCNPJ">Cnpj: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getCnpj()%>" id="txtForCNPJ" name="txtForCNPJ" placeholder="CNPJ" maxlength="14">
                    				</div>
                    				
									<div class="form-group col-5">
				                        <label for="txtForInscricaoEstadual">Inscricao Estadual: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getInscricaoEstadual()%>" id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" placeholder="Insc. Estadual" maxlength="30">
                    				</div>
									
									<div class="form-group col-5">
				                        <label for="txtForInscricaoMunicipal">Inscricao Municipal: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getInscricaoMunicipal()%>" id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" placeholder="Insc. Municipal" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtForEmail">Email: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEmail()%>" id="txtForEmail" name="txtForEmail" placeholder="Email" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtForStatus">Status: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getStatus()%>" id="txtForStatus" name="txtForStatus" placeholder="Status" maxlength="30">
                    				</div>
										
									<div class="form-group col-5">
				                        <label for="txtForTipoEmpresa">TipoEmpresa: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEmpresa().getTipo()%>" id="txtForTipoEmpresa" name="txtForTipoEmpresa" placeholder="TipoEmpresa" maxlength="30">
                    				</div>
										
									<div class="form-group col-5">
				                        <label for="txtForTipoFornecimento">TipoFornecimento: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEmpresa().getTipoFornecimento()%>" id="txtForTipoFornecimento" name="txtForTipoFornecimento" placeholder="TipoFornecimento" maxlength="30">
                    				</div>
                    				
								</div>
								</div>		
							</div></li>
							
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
							<h2></h2>
								<% 	
    								for (int i = 0; i< fornecedorVisualizar.getCnaes().size(); i++) {
    							%>
								<div id="form2" class="modal-form">
									
                   					<div class="form-group col-5">
					                     <label for="txtCnaeId">Id: </label>
					                     <input type="text" class="form-control" value="<%= fornecedorVisualizar.getCnaes().get(i).getId()%>" id="txtCnaeId" name="txtCnaeId" maxlength="30" readonly>
	                    			</div>
	                    			
									<div class="form-group col-5">
				                        <label for="txtCnaeCodigo">Codigo Cnae: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getCnaes().get(i).getCodigo()%>" id="txtCnaeCodigo" name="txtCnaeCodigo" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    				<%
                        				}
                 					 %>

									<button type="button" class="button addContato"
										id="adicionarCnae">Add+</button>
								</div>
							</div>
						</li>
						
						<li><input type="radio" name="tabs" class="rd_tab" id="tab3">
							<label for="tab3" class="tab_label">Fornecimento</label>
							<div class="tab-content">
							<h2></h2>
								<div id="form3" class="modal-form">
									<% 	
	    								for (int i = 0; i< fornecedorVisualizar.getProdutosOfertados().size(); i++) {
	    							%>
	    							<div class="form-group col-5">
					                      <label for="txtProId">Id: </label>
					                      <input type="text" class="form-control" value="<%= fornecedorVisualizar.getProdutosOfertados().get(i).getId()%>" id="txtProId" name="txtProId" maxlength="30" readonly>
	                    			</div>
	                    			
									<div class="form-group col-5">
				                        <label for="txtDescProduto">Produto: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getProdutosOfertados().get(i).getDescricao()%>" id="txtDescProduto" name="txtDescProduto" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    					
                    				<%
                        				}
                 					%>
                    				
                    				<% 	
	    								for (int i = 0; i< fornecedorVisualizar.getServicosOfertados().size(); i++) {
	    							%>
	    							<div class="form-group col-5">
					                      <label for="txtSerId">Id: </label>
					                      <input type="text" class="form-control" value="<%= fornecedorVisualizar.getServicosOfertados().get(i).getId()%>" id="txtSerId" name="txtSerId" maxlength="30" readonly>
	                    			</div>
	    							
                    				<div class="form-group col-5">
				                        <label for="txtDescServico">Servico: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getServicosOfertados().get(i).getDescricao()%>" id="txtDescServico" name="txtDescServico" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    				<%
                        				}
                 					%>
                    				
									<button type="button" class="button addContato"
										id="adicionarFornecimento">Add+</button>
										
								</div>
							</div>
						</li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
							<label for="tab4" class="tab_label">Endereço</label>
							<div class="tab-content">
							<h2></h2>
								<div id="form4" class="modal-form">
								
									<div class="form-group col-5">
				                        <label for="txtEndTipo">Tipo: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getTipo()%>" id="txtEndTipo" name="txtEndTipo" placeholder="Tipo Endereco" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndTipoLogradouro">Tipo Logradouro: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getTipoLogradouro()%>" id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" placeholder="Tipo Logradouro" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndLogradouro">Logradouro: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getLogradouro()%>" id="txtEndLogradouro" name="txtEndLogradouro" placeholder="Logradouro" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndNumero">Numero: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getNumero()%>" id="txtEndNumero" name="txtEndNumero" placeholder="Numero" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndBairro">Bairro: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getBairro()%>" id="txtEndBairro" name="txtEndBairro" placeholder="Bairro" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndCidade">Cidade: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getCidade()%>" id="txtEndCidade" name="txtEndCidade" placeholder="Cidade" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndEstadoUf">UF: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getEstadoUf()%>" id="txtEndEstadoUf" name="txtEndEstadoUf" placeholder="UF" maxlength="2">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndPais">Pais: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getPais()%>" id="txtEndPais" name="txtEndPais" placeholder="Pais" maxlength="30">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndCEP">CEP: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getCep()%>" id="txtEndCEP" name="txtEndCEP" placeholder="CEP" maxlength="8">
                    				</div>
                    				
                    				<div class="form-group col-5">
				                        <label for="txtEndComplemento">Complemento: </label>
				                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getEndereco().getComplemento()%>" id="txtEndComplemento" name="txtEndComplemento" placeholder="Complemento" maxlength="30">
                    				</div>
								</div>
							</div></li>
							<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
								<label for="tab5" class="tab_label">Contato</label>
								<div class="tab-content">
								<h2></h2>
									<div id="form5" class="modal-form">
									
										
										<% 	
	    									for (int i = 0; i< fornecedorVisualizar.getContatos().size(); i++) {
	    								%>
	    								
	    								<div class="form-group col-5">
					                        <label for="txtCttId">Id: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getId()%>" id="txtCttId" name="txtCttId" placeholder="Nome" maxlength="30" readonly>
	                    				</div>
	    								
										<div class="form-group col-5">
					                        <label for="txtCttnome">Nome: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getNome()%>" id="txtCttnome" name="txtCttnome" placeholder="Nome" maxlength="30">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="txtCttemail">Email: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getEmail()%>" id="txtCttemail" name="txtCttemail" placeholder="Email" maxlength="30">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="txtCttdepartamento">Departamento: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getDepartamento()%>" id="txtCttdepartamento" name="txtCttdepartamento" placeholder="Departamento" maxlength="30">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="txtTelDDI">DDI contato: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getDdi()%>" id="txtTelDDI" name="txtTelDDI" placeholder="DDI contato" maxlength="3">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="txtTelDDD">DDD contato: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getDdd()%>" id="txtTelDDD" name="txtTelDDD" placeholder="DDD contato" maxlength="2">
	                    				</div>	
	                    				
	                    				<div class="form-group col-5">
					                        <label for="txtTelNumero">Numero contato: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getNumero()%>" id="txtTelNumero" name="txtTelNumero" placeholder="Numero contato" maxlength="9">
	                    				</div>	
	                    				
	                    				<%
	    									}
	                    				%>						
																								
												
										<button type="button" class="button addContato"
											id="adicionarContato">Add+</button>
									</div>
								</div></li>
								
								<li><input type="radio" name="tabs" class="rd_tab" id="tab6">
								<label for="tab6" class="tab_label">Telefone</label>
								<div class="tab-content">
								<h2></h2>
									<div id="form6" class="modal-form">
										
										<% 	
	    									for (int i = 0; i< fornecedorVisualizar.getTelefones().size(); i++) {
	    								%>
	    								
	    								<div class="form-group col-5">
					                        <label for="txtTelId">Id: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getTelefones().get(i).getId()%>" id="txtTelId" name="txtTelId" maxlength="30" readonly>
	                    				</div>
										
										<div class="form-group col-5">
					                        <label for="ddd_telefone">ddd fornecedor: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdd()%>" id="ddd_telefone" name="ddd_telefone" placeholder="ddd fornecedor" maxlength="2">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="ddi_telefone">ddi fornecedor: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdi()%>" id="ddi_telefone" name="ddi_telefone" placeholder="ddi fornecedor" maxlength="3">
	                    				</div>
	                    				
	                    				<div class="form-group col-5">
					                        <label for="numero_telefone">telefone fornecedor: </label>
					                        <input type="text" class="form-control" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdi()%>" id="numero_telefone" name="numero_telefone" placeholder="numero telefone fornecedor" maxlength="9">
	                    				</div>
	                    				
	                    				<%
	    									}
	                    				%>
	                										
											<button type="button" class="button addContato"
												id="adicionarTelefone">Add+</button>
									</div>
								</div></li>
								
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