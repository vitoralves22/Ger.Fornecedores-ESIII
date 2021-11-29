package web.viewHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class FornecedorViewHelper implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String operacao = request.getParameter("OPERACAO");

		Endereco endereco = new Endereco();
		Fornecedor fornecedor = new Fornecedor();
		Empresa empresa = new Empresa();
		List<Empresa> listaEmpresas = new ArrayList<>();
		Cnae cnae = new Cnae();
		List<Cnae> listaCnaes = new ArrayList<>();
		Telefone telefone = new Telefone();
		List<Telefone> listaTelefones = new ArrayList<Telefone>();
		Contato contato = new Contato();
		List<Contato> listaContatos = new ArrayList<>();
		Produto produto = new Produto();
		List<Produto> listaProdutos = new ArrayList<>();
		Servico servico = new Servico();
		List<Servico> listaServicos = new ArrayList<>();

		if (!operacao.equals("VISUALIZAR") && !operacao.equals("EXCLUIR") && !operacao.equals("CONSULTAR")) {

			// Dados de Endereco.
			String endTipo = request.getParameter("txtEndTipo");
			String endCEP = request.getParameter("txtEndCEP");
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
			String telDDI = request.getParameter("txtTelDDI");
			String telDDD = request.getParameter("txtTelDDD");
			String telNumero = request.getParameter("txtTelNumero");

			if (telDDI != null && !telDDI.trim().equals("")) {
				telefone.setDdi(telDDI);
			}
			if (telDDD != null && !telDDD.trim().equals("")) {
				telefone.setDdd(telDDD);
			}
			if (telNumero != null && !telNumero.trim().equals("")) {
				telefone.setNumero(telNumero);
			}
			
			// Dados do Cnae.
			String codigo = request.getParameter("txtCnaeCodigo");

			if (codigo != null && !codigo.trim().equals("")) {
				cnae.setCodigo(codigo);
			}

			// Dados do Contato.
			String cttNome = request.getParameter("txtCttnome");
			String cttDepartamento = request.getParameter("txtCttdepartamento");
			String cttEmail = request.getParameter("txtCttemail");

			if (cttNome != null && !cttNome.trim().equals("")) {
				contato.setNome(cttNome);
			}
			if (cttDepartamento != null && !cttDepartamento.trim().equals("")) {
				contato.setDepartamento(cttDepartamento);
			}
			if (cttEmail != null && !cttEmail.trim().equals("")) {
				contato.setEmail(cttEmail);
			}
			if (telefone != null) {
				contato.setTelefone(telefone);
			}
			
			// Dados do Produto.
			String pdtDescricao = request.getParameter("txtPdtDescricao");
			
			if (pdtDescricao != null && !pdtDescricao.trim().equals("")) {
				produto.setDescricao(pdtDescricao);
			}
						
			// Dados do Serviço.
			String srvDescricao = request.getParameter("txtPdtDescricao");
			
			if (srvDescricao != null && !srvDescricao.trim().equals("")) {
				servico.setDescricao(srvDescricao);
			}
			
			// Dados do Fornecedor.
			String nomeFantasia = request.getParameter("txtForNomeFantasia");
			String razaoSocial = request.getParameter("txtForRazaoSocial");
			String cnpj = request.getParameter("txtForCNPJ");
			String inscricaoEstadual = request.getParameter("txtForInscricaoEstadual");
			String inscricaoMunicipal = request.getParameter("txtForInscricaoMunicipal");
			String tipoEmpresa = request.getParameter("txtForTipoEmpresas");
			String tipoFornecimento = request.getParameter("txtForTipoFornecimento");
			String email = request.getParameter("txtForEmail");
			
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
			/*
			 * if (tipoEmpresa != null && !tipoEmpresa.trim().equals("")) {
			 * fornecedor.setTipoEmpresa(tipoEmpresa); } if (tipoFornecimento != null &&
			 * !tipoFornecimento.trim().equals("")) {
			 * fornecedor.setTipoFornecimento(tipoFornecimento); }
			 */
			if (email != null && !email.trim().equals("")) {
				fornecedor.setEmail(email);
			}

			if (endereco != null) {
				fornecedor.setEndereco(endereco);
			}

			if (cnae != null) {
				listaCnaes.add(cnae);
				fornecedor.setCnaes(listaCnaes);
			}

			if (telefone != null) {
				listaTelefones.add(telefone);
				fornecedor.setTelefones(listaTelefones);
			}

			if (contato != null) {
				listaContatos.add(contato);
				fornecedor.setContatos(listaContatos);
			}

			if (produto != null) {
				listaProdutos.add(produto);
				fornecedor.setProdutosOfertados(listaProdutos);
			}

			if (servico != null) {
				listaServicos.add(servico);
				fornecedor.setServicosOfertados(listaServicos);
				fornecedor.setStatus("ativo");
			}

			if (operacao.equals("ALTERAR")) {

				int for_id = Integer.valueOf(request.getParameter("txtAlterarFornecedorId"));
				fornecedor.setId(for_id);
			}

		} else {

			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("fornecedorSessao");
			String listaId = request.getParameter("txtListaId");
			String pesquisa = request.getParameter("txtPesquisa");

			if (pesquisa != null && !pesquisa.trim().equals("")) {
				fornecedor.setForPesquisa(pesquisa);
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
				fornecedor.setId(0);
			}

		}
		return fornecedor;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String operacao = request.getParameter("OPERACAO");
		RequestDispatcher dispatcher = null;

		if (operacao.equals("SALVAR")) {
			if (resultado.getMsg().equals("Fornecedor salvo com sucesso.")) {

				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("clienteSessao", resultado);
				dispatcher = request.getRequestDispatcher("/ConsultarCliente?txtPesquisa=ativo&OPERACAO=CONSULTAR");

			} else {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("clienteSessao", resultado);
				dispatcher = request.getRequestDispatcher("cliente/FormCadastrarCliente.jsp");
			}
		} else if (operacao.equals("CONSULTAR")) {

			request.getSession().setAttribute("clienteSessao", resultado);
			dispatcher = request.getRequestDispatcher("cliente/FormListarCliente.jsp");

		} else if (operacao.equals("VISUALIZAR")) {

			request.getSession().setAttribute("VisualizarCliente", resultado.getEntidades().get(0));
			dispatcher = request.getRequestDispatcher("cliente/FormVisualizarCliente.jsp");

		} else if (operacao.equals("ALTERAR")) {

			if (resultado.getMsg().equals("Alterado com sucesso.")) {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("clienteSessao", resultado);
				dispatcher = request.getRequestDispatcher("/ConsultarCliente?txtPesquisa=ativo&OPERACAO=CONSULTAR");
			} else {
				request.setAttribute("resultado", resultado);
				request.getSession().setAttribute("enderecoSessao", resultado);
				dispatcher = request.getRequestDispatcher("cliente/FormVisualizarCliente.jsp");
			}

		} else if (operacao.equals("EXCLUIR")) {

			request.setAttribute("resultado", resultado);
			dispatcher = request.getRequestDispatcher("/ConsultarCliente?OPERACAO=CONSULTAR");
		}

		dispatcher.forward(request, response);
	}

}
