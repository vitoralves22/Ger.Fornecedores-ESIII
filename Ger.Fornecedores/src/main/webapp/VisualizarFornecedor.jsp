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
		
			<%
	           Resultado resultado = (Resultado) request.getAttribute("resultado");
	           Fornecedor fornecedorVisualizar = (Fornecedor) session.getAttribute("VisualizarFornecedor");
	        %>
		
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
								
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtAlterarFornecedorId">Id: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%=fornecedorVisualizar.getId()%>" id="txtAlterarFornecedorId" name="txtAlterarFornecedorId" readonly>
                   					 </div>

									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForNomeFantasia">Nome Fantasia: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getNmFantasia()%>" id="txtForNomeFantasia" name="txtForNomeFantasia" placeholder="Nome fantasia" maxlength="30">
                    				</div>
                    				
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForRazaoSocial">Razao Social: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getRzSocial()%>" id="txtForRazaoSocial" name="txtForRazaoSocial" placeholder="Razao social" maxlength="30">
                    				</div>
                    				
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForCNPJ">Cnpj: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getCnpj()%>" id="txtForCNPJ" name="txtForCNPJ" placeholder="CNPJ" maxlength="14">
                    				</div>
                    				
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForInscricaoEstadual">Inscricao Estadual: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getInscricaoEstadual()%>" id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" placeholder="Insc. Estadual" maxlength="30">
                    				</div>
									
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForInscricaoMunicipal">Inscricao Municipal: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getInscricaoMunicipal()%>" id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" placeholder="Insc. Municipal" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForEmail">Email: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEmail()%>" id="txtForEmail" name="txtForEmail" placeholder="Email" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForStatus">Status: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getStatus()%>" id="txtForStatus" name="txtForStatus" placeholder="Status" maxlength="30">
                    				</div>
										
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForTipoEmpresa">TipoEmpresa: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEmpresa().getTipo()%>" id="txtForTipoEmpresa" name="txtForTipoEmpresa" placeholder="TipoEmpresa" maxlength="30">
                    				</div>
										
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForTipoFornecimento">TipoFornecimento: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEmpresa().getTipoFornecimento()%>" id="txtForTipoFornecimento" name="txtForTipoFornecimento" placeholder="TipoFornecimento" maxlength="30">
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
									
                   					<div id="conteudo-column" class="conteudo-column">
					                     <label for="txtCnaeId">Id: </label>
					                     <br>
					                     <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getCnaes().get(i).getId()%>" id="txtCnaeId" name="txtCnaeId" maxlength="30" readonly>
	                    			</div>
	                    			
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtCnaeCodigo">Codigo Cnae: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getCnaes().get(i).getCodigo()%>" id="txtCnaeCodigo" name="txtCnaeCodigo" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    				<%
                        				}
                 					 %>

									<button type="button" class="buttom-add"
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
	    							<div id="conteudo-column" class="conteudo-column">
					                      <label for="txtProId">Id: </label>
					                      <br>
					                      <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getProdutosOfertados().get(i).getId()%>" id="txtProId" name="txtProId" maxlength="30" readonly>
	                    			</div>
	                    			
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtDescProduto">Produto: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getProdutosOfertados().get(i).getDescricao()%>" id="txtDescProduto" name="txtDescProduto" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    					
                    				<%
                        				}
                 					%>
                    				
                    				<% 	
	    								for (int i = 0; i< fornecedorVisualizar.getServicosOfertados().size(); i++) {
	    							%>
	    							<div id="conteudo-column" class="conteudo-column">
					                      <label for="txtSerId">Id: </label>
					                      <br>
					                      <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getServicosOfertados().get(i).getId()%>" id="txtSerId" name="txtSerId" maxlength="30" readonly>
	                    			</div>
	    							
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtDescServico">Servico: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getServicosOfertados().get(i).getDescricao()%>" id="txtDescServico" name="txtDescServico" placeholder="Codigo Cnae" maxlength="30">
                    				</div>
                    				<%
                        				}
                 					%>
                    				
									<button type="button" class="buttom-add"
										id="adicionarFornecimento">Add+</button>
										
								</div>
							</div>
						</li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
							<label for="tab4" class="tab_label">Endere??o</label>
							<div class="tab-content">
							<h2></h2>
								<div id="form4" class="modal-form">
								
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndTipo">Tipo: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getTipo()%>" id="txtEndTipo" name="txtEndTipo" placeholder="Tipo Endereco" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndTipoLogradouro">Tipo Logradouro: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getTipoLogradouro()%>" id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" placeholder="Tipo Logradouro" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndLogradouro">Logradouro: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getLogradouro()%>" id="txtEndLogradouro" name="txtEndLogradouro" placeholder="Logradouro" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndNumero">Numero: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getNumero()%>" id="txtEndNumero" name="txtEndNumero" placeholder="Numero" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndBairro">Bairro: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getBairro()%>" id="txtEndBairro" name="txtEndBairro" placeholder="Bairro" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndCidade">Cidade: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getCidade()%>" id="txtEndCidade" name="txtEndCidade" placeholder="Cidade" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndEstadoUf">UF: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getEstadoUf()%>" id="txtEndEstadoUf" name="txtEndEstadoUf" placeholder="UF" maxlength="2">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndPais">Pais: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getPais()%>" id="txtEndPais" name="txtEndPais" placeholder="Pais" maxlength="30">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndCEP">CEP: </label>
				                        <br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getCep()%>" id="txtEndCEP" name="txtEndCEP" placeholder="CEP" maxlength="8">
                    				</div>
                    				
                    				<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtEndComplemento">Complemento: </label>
				                       	<br>
				                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getEndereco().getComplemento()%>" id="txtEndComplemento" name="txtEndComplemento" placeholder="Complemento" maxlength="30">
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
	    								
	    								<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtCttId">Id: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getId()%>" id="txtCttId" name="txtCttId" placeholder="Nome" maxlength="30" readonly>
	                    				</div>
	    								
										<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtCttnome">Nome: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getNome()%>" id="txtCttnome" name="txtCttnome" placeholder="Nome" maxlength="30">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtCttemail">Email: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getEmail()%>" id="txtCttemail" name="txtCttemail" placeholder="Email" maxlength="30">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtCttdepartamento">Departamento: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getDepartamento()%>" id="txtCttdepartamento" name="txtCttdepartamento" placeholder="Departamento" maxlength="30">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtTelDDI">DDI contato: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getDdi()%>" id="txtTelDDI" name="txtTelDDI" placeholder="DDI contato" maxlength="3">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtTelDDD">DDD contato: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getDdd()%>" id="txtTelDDD" name="txtTelDDD" placeholder="DDD contato" maxlength="2">
	                    				</div>	
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtTelNumero">Numero contato: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getContatos().get(i).getTelefone().getNumero()%>" id="txtTelNumero" name="txtTelNumero" placeholder="Numero contato" maxlength="9">
	                    				</div>	
	                    				
	                    				<%
	    									}
	                    				%>						
																								
												
										<button type="button" class="buttom-add"
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
	    								
	    								<div id="conteudo-column" class="conteudo-column">
					                        <label for="txtTelId">Id: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getTelefones().get(i).getId()%>" id="txtTelId" name="txtTelId" maxlength="30" readonly>
	                    				</div>
										
										<div id="conteudo-column" class="conteudo-column">
					                        <label for="ddd_telefone">ddd fornecedor: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdd()%>" id="ddd_telefone" name="ddd_telefone" placeholder="ddd fornecedor" maxlength="2">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="ddi_telefone">ddi fornecedor: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdi()%>" id="ddi_telefone" name="ddi_telefone" placeholder="ddi fornecedor" maxlength="3">
	                    				</div>
	                    				
	                    				<div id="conteudo-column" class="conteudo-column">
					                        <label for="numero_telefone">telefone fornecedor: </label>
					                        <br>
					                        <input type="text" class="modal-field" value="<%= fornecedorVisualizar.getTelefones().get(i).getDdi()%>" id="numero_telefone" name="numero_telefone" placeholder="numero telefone fornecedor" maxlength="9">
	                    				</div>
	                    				
	                    				<%
	    									}
	                    				%>
	                										
											<button type="button" class="buttom-add"
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