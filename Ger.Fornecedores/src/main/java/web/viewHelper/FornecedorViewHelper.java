package web.viewHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import core.aplicacao.Resultado;
import dominio.Cnae;
import dominio.Contato;
import dominio.Empresa;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.Produto;
import dominio.Servico;
import dominio.Telefone;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FornecedorViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String operacao = request.getParameter("OPERACAO");
		Endereco endereco = new Endereco();
		Fornecedor fornecedor = new Fornecedor();
		Empresa empresa = new Empresa();
		
		if (!operacao.equals("VISUALIZAR") && !operacao.equals("EXCLUIR") && !operacao.equals("CONSULTAR")) {
					
			// Dados de Endereco.
			String endTipo = request.getParameter("txtEndTipo");
			String endCEP = request.getParameter("txtEndCEP").replace(".", "").replace("/", "").replace("-", "");
			String endTipoLogradouro = request.getParameter("txtEndTipoLogradouro");
			String endLogradouro = request.getParameter("txtEndLogradouro");
			String endNumero = request.getParameter("txtEndNumero");
			String endBairro = request.getParameter("txtEndBairro");
			String endComplemento = request.getParameter("txtEndComplemento");
			String endCidade = request.getParameter("txtEndCidade");
			String endEstadoUf = request.getParameter("txtEndEstadoUf");
			String endPais = request.getParameter("txtEndPais");

			if (endTipo != null && !endTipo.trim().equals("")) {
				endereco.setTipo(endTipo);
			}
			if (endCEP != null && !endCEP.trim().equals("")) {
				endereco.setCep(endCEP);
			}
			if (endTipoLogradouro != null && !endTipoLogradouro.trim().equals("")) {
				endereco.setTipoLogradouro(endTipoLogradouro);
			}
			if (endLogradouro != null && !endLogradouro.trim().equals("")) {
				endereco.setLogradouro(endLogradouro);
			}
			if (endNumero != null && !endNumero.trim().equals("")) {
				endereco.setNumero(endNumero);
			}
			if (endBairro != null && !endBairro.trim().equals("")) {
				endereco.setBairro(endBairro);
			}
			if (endComplemento != null && !endComplemento.trim().equals("")) {
				endereco.setComplemento(endComplemento);
			}
			if (endCidade != null && !endCidade.trim().equals("")) {
				endereco.setCidade(endCidade);
			}
			if (endEstadoUf != null && !endEstadoUf.trim().equals("")) {
				endereco.setEstadoUf(endEstadoUf);
			}
			if (endPais != null && !endPais.trim().equals("")) {
				endereco.setPais(endPais);
			}

			// Dados de Telefone.
			String[] telsId = request.getParameterValues("txtTelId");
			String[] telsDDI = request.getParameterValues("ddi_telefone");
			String[] telsDDD = request.getParameterValues("ddd_telefone");
			String[] telsNumero = request.getParameterValues("numero_telefone");
			List<Telefone> listaTelefones = new ArrayList<Telefone>();
			
			for(int i = 0; i < telsNumero.length; i++) {
				if (telsId == null &&telsDDI[i] != null && !telsDDI[i].trim().equals("") && 
						telsDDD[i] != null && !telsDDD[i].trim().equals("") && 
							telsNumero[i] != null && !telsNumero[i].trim().equals("")) {
					listaTelefones.add(new Telefone(telsDDI[i], telsDDD[i], telsNumero[i]));
					
				}else if(telsId != null && !telsId[i].trim().equals("") && telsDDI[i] != null && !telsDDI[i].trim().equals("") && 
						telsDDD[i] != null && !telsDDD[i].trim().equals("") && 
							telsNumero[i] != null && !telsNumero[i].trim().equals("")) {
					int telId = Integer.parseInt(telsId[i]);
					listaTelefones.add(new Telefone(telId, telsDDI[i], telsDDD[i], telsNumero[i]));
				}
			}
			fornecedor.setTelefones(listaTelefones);		
				
			
			//	Dados do Cnae.
			String[] cnaesId = request.getParameterValues("txtCnaeId");
			String[] cnaesString = request.getParameterValues("txtCnaeCodigo");
			List<Cnae> listaCnaes = new ArrayList<>();
			for(int i = 0; i < cnaesString.length; i++) {
				if (cnaesId == null && cnaesString[i] != null && !cnaesString[i].trim().equals("")) {
					listaCnaes.add(new Cnae(cnaesString[i]));
					
				}else if(cnaesId != null && !cnaesId[i].trim().equals("") && 
						cnaesString[i] != null && !cnaesString[i].trim().equals("")) {
					int cnaeId = Integer.parseInt(cnaesId[i]);
					listaCnaes.add(new Cnae(cnaeId, cnaesString[i]));
				}
			}
			fornecedor.setCnaes(listaCnaes);
			

			// Dados do Contato.		
			List<Contato> listaContatos = new ArrayList<>();
			
			String[] cttsId = request.getParameterValues("txtCttId");
			String[] cttsNome = request.getParameterValues("txtCttnome");
			String[] cttsDepartamento = request.getParameterValues("txtCttdepartamento");
			String[] cttsEmail = request.getParameterValues("txtCttemail");
			String[] cttsDDI = request.getParameterValues("txtTelDDI");
			String[] cttsDDD = request.getParameterValues("txtTelDDD");
			String[] cttsNumero = request.getParameterValues("txtTelNumero");
			
			//if (cttsNome != null) {
			for(int i = 0; i < cttsNome.length; i++) {
				if (cttsId != null && !cttsId[i].trim().equals("") &&
						cttsNome[i] != null && !cttsNome[i].trim().equals("") && 
							cttsDepartamento[i] != null && !cttsDepartamento[i].trim().equals("") &&
								cttsEmail[i] != null && !cttsEmail[i].trim().equals("") && cttsDDI[i] != null &&
									!cttsDDI[i].trim().equals("") && cttsDDD[i] != null && !cttsDDD[i].trim().equals("") &&
										cttsNumero[i] != null && !cttsNumero[i].trim().equals("")){
					int cttId = Integer.parseInt(cttsId[i]);
					listaContatos.add(new Contato(cttId, cttsNome[i], cttsDepartamento[i], cttsEmail[i], new Telefone (cttsDDI[i], cttsDDD[i], cttsNumero[i])));
				}else if(cttsId == null &&
						cttsNome[i] != null && !cttsNome[i].trim().equals("") && 
							cttsDepartamento[i] != null && !cttsDepartamento[i].trim().equals("") &&
								cttsEmail[i] != null && !cttsEmail[i].trim().equals("") && cttsDDI[i] != null &&
									!cttsDDI[i].trim().equals("") && cttsDDD[i] != null && !cttsDDD[i].trim().equals("") &&
										cttsNumero[i] != null && !cttsNumero[i].trim().equals("")){
					listaContatos.add(new Contato(cttsNome[i], cttsDepartamento[i], cttsEmail[i], new Telefone (cttsDDI[i], cttsDDD[i], cttsNumero[i])));
				}	
				
			}
			fornecedor.setContatos(listaContatos);
			//}
			
			
			
			
			
			// Dados do Produto.
			String[] produtosId = request.getParameterValues("txtProId");
			String[] produtosDescricao = request.getParameterValues("txtDescProduto");
			List<Produto> listaProdutos = new ArrayList<>();
			
			for(int i = 0; i < produtosDescricao.length; i++) {
				if (produtosId == null && produtosDescricao[i] != null && !produtosDescricao[i].trim().equals("")) {
					listaProdutos.add(new Produto(produtosDescricao[i]));	
					
				}else if(produtosId != null && !produtosId[i].trim().equals("") && 
						produtosDescricao[i] != null && !produtosDescricao[i].trim().equals("")){
					
					int proId = Integer.parseInt(produtosId[i]);
					listaProdutos.add(new Produto(proId, produtosDescricao[i]));
				}
				fornecedor.setProdutosOfertados(listaProdutos);
			}
			
			
			
						
			// Dados do Serviço.
			String[] servicosId = request.getParameterValues("txtSerId");
			List<Servico> listaServicos = new ArrayList<>();
			String[] servicosDescricao = request.getParameterValues("txtDescServico");
			
			for(int i = 0; i < servicosDescricao.length; i++) {
				if (servicosId == null && servicosDescricao[i] != null && !servicosDescricao[i].trim().equals("")) {
					listaServicos.add(new Servico(servicosDescricao[i]));	
					
				}else if(servicosId != null && !servicosId[i].trim().equals("") && 
						servicosDescricao[i] != null && !servicosDescricao[i].trim().equals("")){
					
					int serId = Integer.parseInt(servicosId[i]);
					listaServicos.add(new Servico(serId, servicosDescricao[i]));
				}
				fornecedor.setServicosOfertados(listaServicos);
			}
			
			
			// Dados do Fornecedor.
			String nomeFantasia = request.getParameter("txtForNomeFantasia");
			String razaoSocial = request.getParameter("txtForRazaoSocial");
			String cnpj = request.getParameter("txtForCNPJ").replace(".", "").replace("/", "").replace("-", "");
			String inscricaoEstadual = request.getParameter("txtForInscricaoEstadual").replace("-", "").replace(".", "").replace("/", "");
			String inscricaoMunicipal = request.getParameter("txtForInscricaoMunicipal").replace("-", "").replace(".", "").replace("/", "");
			String tipoEmpresa = request.getParameter("txtForTipoEmpresa");
			String tipoFornecimento = request.getParameter("txtForTipoFornecimento");
			String email = request.getParameter("txtForEmail");
			String status = request.getParameter("txtForStatus");
			
			if (status != null && !status.trim().equals("")) {
				fornecedor.setStatus(status);
			}
			
			if (nomeFantasia != null && !nomeFantasia.trim().equals("")) {
				fornecedor.setNmFantasia(nomeFantasia);
			}
			if (razaoSocial != null && !razaoSocial.trim().equals("")) {
				fornecedor.setRzSocial(razaoSocial);
			}
			if (cnpj != null && !cnpj.trim().equals("")) {
				fornecedor.setCnpj(cnpj);
			}
			if (inscricaoEstadual != null && !inscricaoEstadual.trim().equals("")) {
				fornecedor.setInscricaoEstadual(inscricaoEstadual);
			}
			if (inscricaoMunicipal != null && !inscricaoMunicipal.trim().equals("")) {
				fornecedor.setInscricaoMunicipal(inscricaoMunicipal);
			}
						
			if (tipoEmpresa != null && !tipoEmpresa.trim().equals("")) {
				empresa.setTipo(tipoEmpresa); 
			} 			
						
			if (tipoFornecimento != null &&
				!tipoFornecimento.trim().equals("")) {
				empresa.setTipoFornecimento(tipoFornecimento); 
			}
						
			if (empresa != null) {
				fornecedor.setEmpresa(empresa);
			}
			
			if (empresa != null) {
				fornecedor.setEmpresa(empresa);
			}
				
						 
			if (email != null && !email.trim().equals("")) {
				fornecedor.setEmail(email);
			}
			
				
			if (endereco != null) {
				fornecedor.setEndereco(endereco);
			}	


			if (operacao.equals("ALTERAR")) {
				int for_id = Integer.valueOf(request.getParameter("txtAlterarFornecedorId"));
				fornecedor.setId(for_id);
			}
			
			if(operacao.equals("RASCUNHO")) {
				fornecedor.setStatus("Rascunho");
			}


			} else {

			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao");
			String listaId = request.getParameter("txtListaId");
			String pesquisa = request.getParameter("txtPesquisa");
			
		
			
			if (pesquisa != null && !pesquisa.trim().equals("")) {
				fornecedor.setPesquisa(pesquisa);
				
			}

			
			if (!operacao.equals("CONSULTAR")) {
				if (listaId != null && !listaId.trim().equals("")) {

					int id = Integer.parseInt(listaId);

					for (EntidadeDominio e : resultado.getEntidades()) {
						if (e.getId() == id) {
							fornecedor = (Fornecedor) e;
						}
					}
				}
			} else {
				fornecedor.setId(null);
			}

		}
		return fornecedor;
		
		
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		 

		String operacao = request.getParameter("OPERACAO");
		
		
		
		RequestDispatcher dispatcher = null;

		if (operacao.equals("SALVAR")|| operacao.equals("RASCUNHO")) {
			if (resultado.getMsg().equals("Fornecedor salvo com sucesso.")) {
				request.setAttribute("resultado", resultado);						
				dispatcher = request.getRequestDispatcher("ConsultarFornecedor.jsp");

			} else {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("fornecedorSessao", resultado);
				dispatcher = request.getRequestDispatcher("ConsultarFornecedor.jsp");
			}
		} else if (operacao.equals("CONSULTAR")) {
			
			request.getSession().setAttribute("fornecedorSessao", resultado);	
			dispatcher = request.getRequestDispatcher("/ConsultarFornecedor.jsp");
			
		} else if (operacao.equals("VISUALIZAR")) {
			request.getSession().setAttribute("VisualizarFornecedor", resultado.getEntidades().get(0));
			dispatcher = request.getRequestDispatcher("VisualizarFornecedor.jsp");

		} else if (operacao.equals("ALTERAR")) {

			if (resultado.getMsg().equals("Alterado com sucesso.")) {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("fornecedorSessao", resultado);
				dispatcher = request.getRequestDispatcher("/ConsultarFornecedor.jsp");
			} else {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("fornecedorSessao", resultado);
				dispatcher = request.getRequestDispatcher("ConsultarFornecedor.jsp");
			}

		} else if (operacao.equals("EXCLUIR")) {
			request.setAttribute("fornecedorSessao", resultado);
			dispatcher = request.getRequestDispatcher("/ConsultarFornecedor?OPERACAO=CONSULTAR");
		}

		dispatcher.forward(request, response);
		
		
	}

}
