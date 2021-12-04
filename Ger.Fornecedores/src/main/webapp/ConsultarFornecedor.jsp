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
</head>

<body>
	    <%
            Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao");
        %>
	<header>
		<h1 class="header-title">Cadastro de Fornecedores</h1>
	</header>
	
	<main>
		
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
		
		
		<div class="modal" id="modal">
		<%-- <form action="${pageContext.request.contextPath}/SalvarFornecedor">
		
						 <%       
            Resultado resultadoCadastro = (Resultado) request.getAttribute("resultado");
            Resultado fornecedoresCadastro = (Resultado) session.getAttribute("fornecedorSessao");
            
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
			String proDescricao = "";
			String serDescricao = "";
					
            if (resultadoCadastro != null) {
                if (resultadoCadastro.getEntidades() != null) {
                    Fornecedor fornecedor = (Fornecedor) fornecedoresCadastro.getEntidades().get(0);
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
                    
                   	if (fornecedor.getEmpresa().getTipo() == null) {
                    	tipoEmpresa = "";
                    } else {
                    	tipoEmpresa = fornecedor.getEmpresa().getTipo();
                    }
                   	
                    if (fornecedor.getEmpresa().getTipoFornecimento() == null) {
                    	tipoFornecimento = "";
                    } else {
                    	tipoFornecimento = fornecedor.getEmpresa().getTipoFornecimento();
                    }
                    
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
                    	proDescricao = "";
                    } else {
                    	proDescricao = fornecedor.getProdutosOfertados().get(0).getDescricao();
                    }
                    if (fornecedor.getServicosOfertados().get(0).getDescricao() == null) {
                    	serDescricao = "";
                    } else {
                    	serDescricao = fornecedor.getServicosOfertados().get(0).getDescricao();
                    }
                }
            }
        %>
		
		
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
							</div></li>
					</ul>
				</nav>
				<footer class="modal-footer">				
					 <input type="submit" class="button save" id="OPERACAO" name="OPERACAO" value="SALVAR"/>
				</footer>
			</div>
			</form> --%>
		</div>
	</main>
	<footer> </footer>
</html>