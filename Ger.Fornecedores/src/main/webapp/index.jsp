<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="dominio.*"%>
<%@page import="core.*"%>
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
            Resultado resultado = (Resultado) request.getAttribute("resultado");
            Resultado fornecedores = (Resultado) session.getAttribute("fornecedorSessao");

            String nomeFantasia =  "";
			String razaoSocial =  "";
			String cnpj =  "";
			String inscricaoEstadual =  "";
			String inscricaoMunicipal =  "";
			String tipoEmpresa =  "";
			String tipoFornecimento =  "";
			String email =  "";
			String endTipo =  "";
			String endCEP =  "";
			String endTipoLogradouro =  "";
			String endLogradouro =  "";
			String endNumero =  "";
			String endBairro =  "";
			String endComplemento =  "";
			String endCidade =  "";
			String endEstadoUf =  "";
			String endPais =  "";
			String codigo =  "";
			String telDDI = "";
			String telDDD = "";;
			String telNumero = "";
			String cttNome = "";
			String cttDepartamento = "";
			String cttEmail = "";
			String cttTelDDI = "";
			String cttTelDDD = "";;
			String cttTelNumero = "";
			String pdtDescricao = "";
			String srvDescricao = "";
					

            if (resultado != null) {
                if (resultado.getEntidades() != null) {
                    Fornecedor fornecedor = (Fornecedor) fornecedores.getEntidades().get(0);

                    if (fornecedor.getNmFantasia() == null) {
                    	nomeFantasia = "";
                    } else {
                    	nomeFantasia = fornecedor.getNmFantasia();
                    }
                    if (fornecedor.getRzSocial() == null) {
                    	razaoSocial = "";
                    } else {
                    	razaoSocial = fornecedor.getRzSocial();
                    }
                    if (fornecedor.getCnpj() == null) {
                    	cnpj = "";
                    } else {
                    	cnpj = fornecedor.getCnpj() ;
                    }
                    if (fornecedor.getInscricaoEstadual()== null) {
                    	inscricaoEstadual = "";
                    } else {
                    	inscricaoEstadual = fornecedor.getInscricaoEstadual();
                    }
                    if (fornecedor.getInscricaoMunicipal() == null) {
                    	inscricaoMunicipal = "";
                    } else {
                    	inscricaoMunicipal = fornecedor.getInscricaoMunicipal();
                    }
                   /*  if (fornecedor.getTipoEmpresa() == null) {
                    	tipoEmpresa = "";
                    } else {
                    	tipoEmpresa = fornecedor.getTipoEmpresa();
                    }
                    if (fornecedor.getTipoFornecimento() == null) {
                    	tipoFornecimento = "";
                    } else {
                    	tipoFornecimento = fornecedor.getTipoFornecimento();
                    } */
                    if (fornecedor.getEmail() == null) {
                    	email  = "";
                    } else {
                    	email = fornecedor.getEmail();
                    }
                    if (fornecedor.getEndereco().getTipo() == null) {
                    	endTipo  = "";
                    } else {
                    	endTipo = fornecedor.getEndereco().getTipo();
                    }
                    if (fornecedor.getEndereco().getCep() == null) {
                    	endCEP  = "";
                    } else {
                    	endCEP = fornecedor.getEndereco().getCep();
                    }
                    if (fornecedor.getEndereco().getTipoLogradouro() == null) {
                    	endTipoLogradouro  = "";
                    } else {
                    	endTipoLogradouro = fornecedor.getEndereco().getTipoLogradouro();
                    }
                    if (fornecedor.getEndereco().getLogradouro() == null) {
                    	endLogradouro  = "";
                    } else {
                    	endLogradouro = fornecedor.getEndereco().getLogradouro();
                    }
                    if (fornecedor.getEndereco().getNumero() == null) {
                    	endNumero  = "";
                    } else {
                    	endNumero = fornecedor.getEndereco().getNumero();
                    }
                    if (fornecedor.getEndereco().getBairro() == null) {
                    	endBairro  = "";
                    } else {
                    	endBairro = fornecedor.getEndereco().getBairro();
                    }
                    if (fornecedor.getEndereco().getComplemento() == null) {
                    	endComplemento  = "";
                    } else {
                    	endComplemento = fornecedor.getEndereco().getComplemento();
                    }
                    if (fornecedor.getEndereco().getCidade() == null) {
                    	endCidade  = "";
                    } else {
                    	endCidade = fornecedor.getEndereco().getCidade();
                    }
                    if (fornecedor.getEndereco().getEstadoUf() == null) {
                    	endEstadoUf  = "";
                    } else {
                    	endEstadoUf = fornecedor.getEndereco().getEstadoUf();
                    }
                    if (fornecedor.getEndereco().getPais() == null) {
                    	endPais  = "";
                    } else {
                    	endPais = fornecedor.getEndereco().getPais();
                    }
                    if (fornecedor.getCnaes().get(0).getCodigo() == null) {
                    	codigo  = "";
                    } else {
                    	codigo = fornecedor.getCnaes().get(0).getCodigo() ;
                    } 
                    if (fornecedor.getTelefones().get(0).getDdi() == null) {
                    	telDDI = "";
                    } else {
                    	telDDI = fornecedor.getTelefones().get(0).getDdi();
                    } 
                    if (fornecedor.getTelefones().get(0).getDdd() == null) {
                    	telDDD = "";
                    } else {
                    	telDDD = fornecedor.getTelefones().get(0).getDdd();
                    } 
                    if (fornecedor.getTelefones().get(0).getNumero() == null) {
                    	telNumero = "";
                    } else {
                    	telNumero = fornecedor.getTelefones().get(0).getNumero();
                    } 
                    if (fornecedor.getContatos().get(0).getNome() == null) {
                    	cttNome = "";
                    } else {
                    	cttNome = fornecedor.getContatos().get(0).getNome();
                    } 
                    if (fornecedor.getContatos().get(0).getDepartamento()== null) {
                    	cttDepartamento = "";
                    } else {
                    	cttDepartamento = fornecedor.getContatos().get(0).getDepartamento();
                    } 
                    if (fornecedor.getContatos().get(0).getEmail()== null) {
                    	cttEmail = "";
                    } else {
                    	cttEmail = fornecedor.getContatos().get(0).getEmail();
                    }
                    if (fornecedor.getContatos().get(0).getTelefone().getDdi() == null) {
                    	telDDI = "";
                    } else {
                    	telDDI = fornecedor.getContatos().get(0).getTelefone().getDdi();
                    } 
                    if (fornecedor.getContatos().get(0).getTelefone().getDdd() == null) {
                    	telDDD = "";
                    } else {
                    	telDDD = fornecedor.getContatos().get(0).getTelefone().getDdd();
                    } 
                    if (fornecedor.getContatos().get(0).getTelefone().getNumero() == null) {
                    	telNumero = "";
                    } else {
                    	telNumero = fornecedor.getContatos().get(0).getTelefone().getNumero() ;
                    }
                    if (fornecedor.getProdutosOfertados().get(0).getDescricao() == null) {
                    	pdtDescricao = "";
                    } else {
                    	pdtDescricao = fornecedor.getProdutosOfertados().get(0).getDescricao();
                    }
                    if (fornecedor.getServicosOfertados().get(0).getDescricao() == null) {
                    	srvDescricao = "";
                    } else {
                    	srvDescricao = fornecedor.getServicosOfertados().get(0).getDescricao();
                    }
                }
            }
        %>
	<main>
		<button type="button" class="button blue mobile"
			id="cadastrarFornecedor">Cadastrar Fornecedor</button>
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
			<div class="modal-content">
				<nav class="nav_tabs">
					<ul>
						<li><input type="radio" id="tab1" class="rd_tab" name="tabs"
							checked> <span class="modal-close" id="modalClose">&#10006;</span>
							<label for="tab1" class="tab_label">Empresa</label>
							<div class="tab-content">
								<h1></h1>
								<form id="form" class="modal-form">

									<input id="txtForNomeFantasia" type="text" data-index="new" class="modal-field" value="<%=nomeFantasia %>"
										placeholder="Nome Fantasia" required>

									<input id="txtForRazaoSocial" type="text" class="modal-field" value="<%=razaoSocial %>"
										placeholder="Razão Social" required> 
										
									<input id="txtForCNPJ" type="text" class="modal-field" value="<%=cnpj %>"
										placeholder="CNPJ" required> 
									
									<input id="txtForInscricaoEstadual" type="text" class="modal-field" value="<%=inscricaoEstadual %>"
										placeholder="Inscrição Estadual" required> 
									
									<input id="txtForInscricaoMunicipal" type="text" class="modal-field" value="<%=inscricaoMunicipal %>"
										placeholder="Inscrição Municipal" required> 
										
									<input id="txtForEmail" type="text" class="modal-field" value="<%=email %>"
										placeholder="Email" required> 
										
									<input id="txtForTipoEmpresas" type="text" class="modal-field" value="<%=tipoEmpresa %>"
										placeholder="Tipo Empresa" required> 
										
									<input id="txtForTipoFornecimento" type="text" class="modal-field" value="<%=tipoFornecimento %>"
										placeholder="Tipo Fornecimento" required>

								</form>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<form id="form2" class="modal-form">
									<input id="txtCnaeCodigo" type="text" class="modal-field" value="<%=codigo %>"
										placeholder="CNAE" required>

									<button type="button" class="button addContato"
										id="adicionarCnae">Add+</button>
								</form>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab3">
							<label for="tab3" class="tab_label">Fornecimento</label>
							<div class="tab-content">
								<h2></h2>
								<form id="form3" class="modal-form">
									<input id="tipo_fornecimento" type="text" class="modal-field" value="<%=tipoFornecimento %>"
										placeholder="Tipo"> 
									<input id="descricao_fornecimento" type="text" class="modal-field" value="<%=pdtDescricao %>"
										placeholder="Descrição">
									<%-- <input id="descricao_fornecimento" type="text" class="modal-field" value="<%=srvDescricao %>"
										placeholder="Descrição"> --%>

									<button type="button" class="button addContato"
										id="adicionarFornecimento">Add+</button>
								</form>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
							<label for="tab4" class="tab_label">Endereço</label>
							<div class="tab-content">
								<h2></h2>
								<form id="form4" class="modal-form">
									<input id="txtEndTipo" type="text" class="modal-field" value="<%=endTipo %>"
										placeholder="Tipo Endereço" required> 
										
									<input id="txtEndTipoLogradouro" type="text" class="modal-field" value="<%=endTipoLogradouro %>"
										placeholder="Tipo Logradouro" required> 
										
									<input id="txtEndLogradouro" type="text" class="modal-field" value="<%=endLogradouro %>"
										placeholder="Logradouro" required> 
										
									<input id="txtEndNumero" type="text" class="modal-field" value="<%=endNumero %>"
										placeholder="Numero" required>
										
									<input id="txtEndBairro" type="text" class="modal-field" value="<%=endBairro %>"
										placeholder="Bairro" required> 
										
									<input id="txtEndCidade" type="text" class="modal-field" value="<%=endCidade %>"
										placeholder="Cidade" required>
										
									<input id="txtEndEstadoUf" type="text" class="modal-field" value="<%=endEstadoUf %>"
										placeholder="UF" required> 
										
									<input id="txtEndPais" type="text" class="modal-field" value="<%=endPais %>"
										placeholder="País" required> 
										
									<input id="txtEndCEP" type="text" class="modal-field" value="<%=endCEP %>"
										placeholder="CEP" required> 
										
									<input id="txtEndComplemento" type="text" class="modal-field" value="<%=endComplemento %>"
										placeholder="Complemento">
								</form>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
							<label for="tab5" class="tab_label">Contato</label>
							<div class="tab-content">
								<h2></h2>
								<form id="form5" class="modal-form">
									<input id="txtCttnome" type="text" class="modal-field" value="<%=cttNome %>"
										placeholder="Nome" required> 
										
									<input id="txtCttemail" type="email" class="modal-field" value="<%=cttEmail %>" 
										placeholder="Email" required>
										
									<input id="txtCttdepartamento" type="text" class="modal-field" value="<%=cttDepartamento %>"
										placeholder="Departamento" required> 
										
									<input id="txtTelDDI" type="text" class="modal-field" value="<%=cttTelDDI %>"
										placeholder="DDI" required> 
										
									<input id="txtTelDDD" type="text" class="modal-field" value="<%=cttTelDDD %>"
										placeholder="DDD" required>
										
									<input id="txtTelNumero" type="tel" class="modal-field" value="<%=cttTelNumero %>"
										placeholder="Telefone" required>
									<!--  <input id="ramal_contato" type="text" class="modal-field" placeholder="Ramal">
                                    <input id="codigo_contato" type="text" class="modal-field" placeholder="Código">
                                    <input id="descricao_contato" type="text" class="modal-field"
                                        placeholder="Descrição"> -->
									<button type="button" class="button addContato"
										id="adicionarContato">Add+</button>
								</form>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab6">
							<label for="tab6" class="tab_label">Telefone</label>
							<div class="tab-content">
								<h2></h2>
								<form id="form6" class="modal-form">
									<input id="ddd_telefone" type="text" class="modal-field" value="<%=telDDI %>"
										placeholder="DDD"> 
										
									<input id="ddi_telefone" type="text" class="modal-field" value="<%=telDDD %>"
										placeholder="DDI"> 
										
									<input id="numero_telefone" type="tel" class="modal-field" value="<%=telNumero %>"
										placeholder="Numero">
										
									<button type="button" class="button addContato"
										id="adicionarTelefone">Add+</button>
								</form>
							</div></li>
					</ul>
				</nav>
				<footer class="modal-footer">
					<button id="salvar" class="button save">Salvar</button>
					<button id="cancelar" class="button cancel">Cancelar</button>
				</footer>
			</div>
		</div>
	</main>
	<footer> </footer>
</html>