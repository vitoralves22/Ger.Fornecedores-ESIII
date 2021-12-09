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
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
</head>

<body>

	               
        
	<header>
		<h1 class="header-title">Cadastro de Fornecedores</h1>
	</header>
	
	<main>
	
		 <div>
    		<button type="button" class="button blue mobile" id="cadastrarFornecedor">Cadastrar Fornecedor</button>					
   		 </div>
		
		
		<form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/ConsultarFornecedor">
              <input type="text" class="form-control" id="txtPesquisa"name="txtPesquisa" placeholder="Pesquisa">
              <input class="btn btn-info" type="submit" id="OPERACAO" name="OPERACAO" value="CONSULTAR" />
        </form>
      
			
		<table id="tableFornecedor" class="records">
		  	    <%
            		Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao");
       			 %> 
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
                                	if(f.getId() != null){                   
                %>
                 <tr>
                    <td><%= f.getId()%></td>
                    <td><%= f.getNmFantasia()%></td>
                    <td><%= f.getCnpj()%></td>
                    <td><%= f.getEmail()%></td>
                    <td><%= f.getStatus()%></td>
                    <td><a href="${pageContext.request.contextPath}/ConsultarFornecedor?txtListaId=<%=f.getId()%>&OPERACAO=VISUALIZAR" class="btn btn-default" ><span class="consult material-icons">description</span></a></td>
                    <td><a href="${pageContext.request.contextPath}/ExcluirFornecedor?OPERACAO=EXCLUIR&txtListaId=<%=f.getId()%>" class="btn btn-default" ><span class="delete material-icons">delete</span></a></td>
                </tr>

                <%
                                	} 
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
							$(wrapperCnaes).append('<div id="form2" class="modal-form"><div id="conteudo-column" class="conteudo-column"><label for="txtCnaeCodigo">CNAE: </label><br><input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" placeholder="CNAE" ></div><a style="text-align:right" href="#" class="remove_field"><span class="delete material-icons">delete</span></a></div>');
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
							$(wrapperTels).append('<div id="form6" class="modal-form"><div id="conteudo-column" class="conteudo-column"><label for="ddi_telefone">DDI: </label><br><input id="ddi_telefone" name="ddi_telefone" type="text" class="modal-field" placeholder="DDI" maxlength="3"></div><div id="conteudo-column" class="conteudo-column"><label for="ddd_telefone">DDD: </label><br><input id="ddd_telefone" name="ddd_telefone" type="text" class="modal-field" placeholder="DDD" maxlength="2"></div><div id="conteudo-column" class="conteudo-column"><label for="numero_telefone">Numero: </label><br><input id="numero_telefone" name="numero_telefone" type="tel" class="modal-field" placeholder="Numero"></div><a style="text-align:right" href="#" class="remove_field"><span class="delete material-icons">delete</span></a></div>');
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
							$(wrapperCtts).append('<div id="form5" class="modal-form"><div id="conteudo-column" class="conteudo-column"><label for="txtCttnome">Nome: </label><br><input id="txtCttnome" name="txtCttnome" type="text" class="modal-field" placeholder="Nome" ></div><div id="conteudo-column" class="conteudo-column"><label for="txtCttemail">Email: </label><br><input id="txtCttemail" name="txtCttemail" type="email" class="modal-field" placeholder="Email" ></div><div id="conteudo-column" class="conteudo-column"><label for="txtCttdepartamento">Departamento: </label><br><input id="txtCttdepartamento" name="txtCttdepartamento" type="text" class="modal-field" placeholder="Departamento" ></div><div id="conteudo-column" class="conteudo-column"><label for="txtTelDD">DDI: </label><br><input id="txtTelDDI" name="txtTelDDI" type="text" class="modal-field" placeholder="DDI" maxlength="3"> </div><div id="conteudo-column" class="conteudo-column"><label for="txtTelDDD">DDD: </label><br><input id="txtTelDDD" name="txtTelDDD" type="text" class="modal-field" placeholder="DDD" maxlength="2"></div><div id="conteudo-column" class="conteudo-column"><label for="txtTelNumero">Numero telefone: </label><br><input id="txtTelNumero" name="txtTelNumero" type="tel" class="modal-field" placeholder="Telefone" maxlength="9"></div><a style="text-align:right" href="#" class="remove_field"><span class="delete material-icons">delete</span></a></div>');
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
							$(wrapperForn).append('<div id="form3" class="modal-form"><div id="conteudo-column" class="conteudo-column"><label for="txtDescProduto">Produto: </label><br><input id="txtDescProduto" name="txtDescProduto" type="text" class="modal-field" placeholder="Produto"></div><div id="conteudo-column" class="conteudo-column"><label for="txtDescServico">Servico: </label><br><input id="txtDescServico" name="txtDescServico" type="text" class="modal-field" placeholder="Servico"></div><a style="text-align:right" href="#" class="remove_field"><span class="delete material-icons">delete</span></a></div>');
						  });
				  
						  $(wrapperForn).on("click", ".remove_field", function (e) { //user click on remove text
							e.preventDefault(); $(this).parent('div').remove(); x--;
						  })
				  
						});
	  				</script>
	  				<script>
	  					$(document).ready(function(){
							$("#txtForCNPJ").mask("00.000.000/0000-00");
							$("#txtTelNumero").mask("0000-0000");
							$("#txtTelDDI").mask('000');
							$("#txtTelDDD").mask('00');
							$("#txtEndCEP").mask('00000-000');
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

									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForNomeFantasia">Nome Fantasia: </label>
										<br>
										<input id="txtForNomeFantasia" name="txtForNomeFantasia"  type="text" data-index="new" class="modal-field" 
											placeholder="Nome Fantasia" >
									</div>
									<div id="conteudo-column" class="conteudo-column">
				                        <label for="txtForRazaoSocial">Razao Social: </label>
										<br>
										<input id="txtForRazaoSocial" name="txtForRazaoSocial" type="text" class="modal-field"
											placeholder="Razão Social" >  
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtForCNPJ">CNPJ: </label>
										<br>
										<input id="txtForCNPJ" name="txtForCNPJ" type="text" class="modal-field" 
											placeholder="CNPJ" maxlength="14">  
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtForInscricaoEstadual">Inscricao Estadual: </label>
										<br>
										<input id="txtForInscricaoEstadual" name="txtForInscricaoEstadual" type="text" class="modal-field" 
											placeholder="Inscrição Estadual" maxlength="15" > 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtForInscricaoMunicipal">Inscricao Municipal: </label>
										<br>
										<input id="txtForInscricaoMunicipal" name="txtForInscricaoMunicipal" type="text" class="modal-field" 
											placeholder="Inscrição Municipal" maxlength="15"> 
									</div>
									<div id="conteudo-column" class="conteudo-column">	
										<label for="txtForEmail">Email: </label>
										<br>
										<input id="txtForEmail" name="txtForEmail" type="text" class="modal-field"
											placeholder="Email" > 
									</div>
									
									<div id="conteudo-column" class="conteudo-column">	
										<label for="txtForStatus">Status: </label>
										<br>
										<select id="txtForStatus" name="txtForStatus" class="modal-field">
											<option value="Ativo" >Ativo</option>
											<option value="Inativo" >Inativo</option>
											
										</select>
									</div>
									
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtForTipoEmpresa">TipoEmpresa: </label>
										<br>
										<input id="txtForTipoEmpresa" name="txtForTipoEmpresa" type="text" class="modal-field"
											placeholder="Tipo Empresa" >  
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtForTipoFornecimento">Tipo Fornecimento: </label>
										<br>
										<select id="txtForTipoFornecimento" name="txtForTipoFornecimento" class="modal-field">
											<option value="Produto" >Produto</option>
											<option value="Serviço" >Serviço</option>
											<option value="Ambos" >Ambos</option>
										</select>
									</div>	
								</div>
							</div></li>
						
						<li><input type="radio" name="tabs" class="rd_tab" id="tab2">
							<label for="tab2" class="tab_label">CNAE</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperCnaes">
								<div id="form2" class="modal-form">
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtCnaeCodigo">CNAE: </label>
										<br>
										<input id="txtCnaeCodigo" type="text" name="txtCnaeCodigo" class="modal-field" 
										placeholder="CNAE" >
									</div>
									<button type="button" class="buttom-add"
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
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtDescProduto">Produto: </label>
										<br>
										<input id="txtDescProduto" name="txtDescProduto" type="text" class="modal-field" 
											placeholder="Produto"> 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtDescServico">Servico: </label>
										<br>
										<input id="txtDescServico" name="txtDescServico" type="text" class="modal-field" 
											placeholder="Servico">
									</div>

									<button type="button" class="buttom-add"
										id="addFornecimento">Add+</button>
								</div>	
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab4">
							<label for="tab4" class="tab_label">Endereço</label>
							<div class="tab-content">
								<h2></h2>
								<div id="form4" class="modal-form">
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndTipo">Tipo Endereco: </label>
										<br>
										<input id="txtEndTipo" name="txtEndTipo" type="text" class="modal-field" 
											placeholder="Tipo Endereço" > 	 
									</div>	
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndTipoLogradouro">Tipo Logradouro: </label>
										<br>
										<input id="txtEndTipoLogradouro" name="txtEndTipoLogradouro" type="text" class="modal-field"
											placeholder="Tipo Logradouro" >  
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndLogradouro">Logradouro: </label>
										<br>
										<input id="txtEndLogradouro" name="txtEndLogradouro" type="text" class="modal-field" 
											placeholder="Logradouro" >   
									</div>		
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndNumero">Numero: </label>
										<br>
										<input id="txtEndNumero" name="txtEndNumero" type="text" class="modal-field" 
											placeholder="Numero" >  
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndBairro">Bairro: </label>
										<br>
										<input id="txtEndBairro" name="txtEndBairro" type="text" class="modal-field"
											placeholder="Bairro" >    
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndCidade">Cidade: </label>
										<br>
										<input id="txtEndCidade" name="txtEndCidade" type="text" class="modal-field"
											placeholder="Cidade" > 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndEstadoUf">UF: </label>
										<br>
										<input id="txtEndEstadoUf" name="txtEndEstadoUf" type="text" class="modal-field"
											placeholder="UF" maxlength="2"> 
									</div>	
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndPais">País: </label>
										<br>
										<input id="txtEndPais" name="txtEndPais" type="text" class="modal-field"
											placeholder="País" >
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndCEP">CEP: </label>
										<br>
										<input id="txtEndCEP" name="txtEndCEP" type="text" class="modal-field"
											placeholder="CEP" maxlength="8">  
									</div>	
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtEndComplemento">Complemento: </label>
										<br>
										<input id="txtEndComplemento" name="txtEndComplemento" type="text" class="modal-field"
											placeholder="Complemento">
									</div>	
								</div>
							</div></li>
						<li><input type="radio" name="tabs" class="rd_tab" id="tab5">
							<label for="tab5" class="tab_label">Contato</label>
							<div class="tab-content">
								<h2></h2>
								<div class="wrapperContatos">
								<div id="form5" class="modal-form">
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtCttnome">Nome: </label>
										<br>
										<input id="txtCttnome" name="txtCttnome" type="text" class="modal-field" 
											placeholder="Nome" > 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtCttemail">Email: </label>
										<br>
										<input id="txtCttemail" name="txtCttemail" type="email" class="modal-field" 
											placeholder="Email" >
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtCttdepartamento">Departamento: </label>
										<br>
										<input id="txtCttdepartamento" name="txtCttdepartamento" type="text" class="modal-field" 
											placeholder="Departamento" >
									</div>	
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtTelDD">DDI: </label>
										<br>
										<input id="txtTelDDI" name="txtTelDDI" type="text" class="modal-field" 
											placeholder="DDI" maxlength="3"> 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtTelDDD">DDD: </label>
										<br>
										<input id="txtTelDDD" name="txtTelDDD" type="text" class="modal-field" 
											placeholder="DDD" maxlength="2">
									</div>	
									<div id="conteudo-column" class="conteudo-column">
										<label for="txtTelNumero">Numero telefone: </label>
										<br>
										<input id="txtTelNumero" name="txtTelNumero" type="tel" class="modal-field" 
											placeholder="Telefone" maxlength="9">
									</div> 	
									<button type="button" class="buttom-add"
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
									<div id="conteudo-column" class="conteudo-column">
										<label for="ddi_telefone">DDI: </label>
										<br>
										<input id="ddi_telefone" name="ddi_telefone" type="text" class="modal-field" 
											placeholder="DDI" maxlength="3"> 
									</div> 
									<div id="conteudo-column" class="conteudo-column">
										<label for="ddd_telefone">DDD: </label>
										<br>
										<input id="ddd_telefone" name="ddd_telefone" type="text" class="modal-field" 
											placeholder="DDD" maxlength="2"> 
									</div>
									<div id="conteudo-column" class="conteudo-column">
										<label for="numero_telefone">Numero: </label>
										<br>
										<input id="numero_telefone" name="numero_telefone" type="tel" class="modal-field" 
											placeholder="Numero">
									</div>
									<button type="button" class="buttom-add"
										id="addTel">Add+</button>
								</div>
								</div>
							</div></li>
							
					</ul>
				</nav>
				<footer class="modal-footer">				
					 <input type="submit" class="button save" id="OPERACAO" name="OPERACAO" value="SALVAR"/>
					 <input type="submit" class="button rascunho" id="OPERACAO" name="OPERACAO" value="RASCUNHO"/>
				</footer>
			</div>
			</form>
		</div>
		<div>
            <h5>
               <%
                   if (resultadoCadastro != null && resultado.getMsg() != null) {
                      out.println(resultado.getMsg());
                   }
               %>         
            </h5>
        </div>
	</main>
	<footer> </footer>
</html>