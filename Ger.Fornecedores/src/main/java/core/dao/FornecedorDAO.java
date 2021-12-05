package core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import core.util.Conexao;
import dominio.*;

public class FornecedorDAO extends AbstractJdbcDAO{
	
	public FornecedorDAO(Connection cx){
		super(cx, "tab_fornecedores", "for_id");
	}

    public FornecedorDAO() {
        super("tab_fornecedores", "for_id");
    }
    
    IDAO cnaeDAO = new CnaeDAO();
	IDAO contatoDAO = new ContatoDAO();
	IDAO telefoneDAO = new TelefoneDAO();
	IDAO produtoDAO = new ProdutoDAO();
	IDAO servicoDAO = new ServicoDAO();
    
   

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	    
        	Fornecedor fornecedor = (Fornecedor)entidade;  	
            
        	openConnection();
			PreparedStatement pst=null;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_fornecedores(for_nmFantasia, for_rzSocial, for_cnpj, for_inscEstadual, for_inscMunicipal, for_email, for_status,"
            		+ "for_end_tipo, for_end_cep, for_end_tipoLogradouro, for_end_logradouro, for_end_numero, for_end_bairro, for_end_complemento,"
            		+ "for_end_cidade, for_end_estado_uf, for_end_pais, for_tipo_empresa, for_tipo_fornecimento, for_dtCadastro) "); 
            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            try {
                connection.setAutoCommit(false);
                
            pst = connection.prepareStatement(sql.toString(), 
    					Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, fornecedor.getNmFantasia());
            pst.setString(2, fornecedor.getRzSocial());
            pst.setString(3, fornecedor.getCnpj());
            pst.setString(4, fornecedor.getInscricaoEstadual());
            pst.setString(5, fornecedor.getInscricaoMunicipal());
            pst.setString(6, fornecedor.getEmail());
            pst.setString(7, fornecedor.getStatus());
            pst.setString(8, fornecedor.getEndereco().getTipo());
            pst.setString(9, fornecedor.getEndereco().getCep());
            pst.setString(10, fornecedor.getEndereco().getTipoLogradouro());
            pst.setString(11, fornecedor.getEndereco().getLogradouro());
            pst.setString(12, fornecedor.getEndereco().getNumero());
            pst.setString(13, fornecedor.getEndereco().getBairro());
            pst.setString(14, fornecedor.getEndereco().getComplemento());
            pst.setString(15, fornecedor.getEndereco().getCidade());
            pst.setString(16, fornecedor.getEndereco().getEstadoUf());
            pst.setString(17, fornecedor.getEndereco().getPais());
            pst.setString(18, fornecedor.getEmpresa().getTipo());
            pst.setString(19, fornecedor.getEmpresa().getTipoFornecimento());
            pst.setTimestamp(20, new Timestamp(fornecedor.getDtCadastro().getTime()));
            pst.executeUpdate();
            connection.commit();
            
            ResultSet rs = pst.getGeneratedKeys();
            
			if(rs.next()) {
				fornecedor.setId(rs.getInt(1));
				
			}
			
			
				
			for(Contato contato : fornecedor.getContatos()) {
	            try {
	                contatoDAO = new ContatoDAO();
	                contato.setForId(fornecedor.getId());
	                contatoDAO.salvar(contato);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Telefone telefone : fornecedor.getTelefones()) {
	            try {
	                telefoneDAO = new TelefoneDAO();  
	                telefone.setForId(fornecedor.getId());
	                telefoneDAO.salvar(telefone);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Cnae cnae : fornecedor.getCnaes()) {
	            try {
	                cnaeDAO = new CnaeDAO();
	                cnae.setForId(fornecedor.getId());
	                cnaeDAO.salvar(cnae);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Produto produto : fornecedor.getProdutosOfertados()) {
	            try {
	                produtoDAO = new ProdutoDAO();	 
	                produto.setForId(fornecedor.getId());
	                produtoDAO.salvar(produto);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Servico servico : fornecedor.getServicosOfertados()) {
	            try {
	                servicoDAO = new ServicoDAO();
	                servico.setForId(fornecedor.getId());
	                servicoDAO.salvar(servico);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
            
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
        	if(ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
        }
    }

    @Override
    public void alterar(EntidadeDominio entidade) {

    	Fornecedor fornecedor = (Fornecedor)entidade;  	
    	
        
    	openConnection();
		PreparedStatement pst=null;
        StringBuilder sql = new StringBuilder();
        
        sql.append("UPDATE tab_fornecedores SET for_nmFantasia=?, for_rzSocial=?, for_cnpj=?, for_inscEstadual=?, for_inscMunicipal=?, for_email=?, for_status=?,"
        		+ "for_end_tipo=?, for_end_cep=?, for_end_tipoLogradouro=?, for_end_logradouro=?, for_end_numero=?, for_end_bairro=?, for_end_complemento=?,"
        		+ "for_end_cidade=?, for_end_estado_uf=?, for_end_pais=?, for_tipo_empresa=?, for_tipo_fornecimento=?, for_dtCadastro=?"); 
        sql.append("WHERE for_id=?;");
  
        
        try {
            connection.setAutoCommit(false);
            
        pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, fornecedor.getNmFantasia());
        pst.setString(2, fornecedor.getRzSocial());
        pst.setString(3, fornecedor.getCnpj());
        pst.setString(4, fornecedor.getInscricaoEstadual());
        pst.setString(5, fornecedor.getInscricaoMunicipal());
        pst.setString(6, fornecedor.getEmail());
        pst.setString(7, fornecedor.getStatus());
        pst.setString(8, fornecedor.getEndereco().getTipo());
        pst.setString(9, fornecedor.getEndereco().getCep());
        pst.setString(10, fornecedor.getEndereco().getTipoLogradouro());
        pst.setString(11, fornecedor.getEndereco().getLogradouro());
        pst.setString(12, fornecedor.getEndereco().getNumero());
        pst.setString(13, fornecedor.getEndereco().getBairro());
        pst.setString(14, fornecedor.getEndereco().getComplemento());
        pst.setString(15, fornecedor.getEndereco().getCidade());
        pst.setString(16, fornecedor.getEndereco().getEstadoUf());
        pst.setString(17, fornecedor.getEndereco().getPais());
        pst.setString(18, fornecedor.getEmpresa().getTipo());
        pst.setString(19, fornecedor.getEmpresa().getTipoFornecimento());
        pst.setTimestamp(20, new Timestamp(fornecedor.getDtCadastro().getTime()));
        pst.setInt(21, fornecedor.getId());
        pst.executeUpdate();
        connection.commit();
		
		
			
		for(Contato contato : fornecedor.getContatos()) {
            try {
                contatoDAO = new ContatoDAO();
                contato.setForId(fornecedor.getId());
                contatoDAO.alterar(contato);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        for(Telefone telefone : fornecedor.getTelefones()) {
            try {
                telefoneDAO = new TelefoneDAO();  
                telefone.setForId(fornecedor.getId());
                telefoneDAO.alterar(telefone);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        for(Cnae cnae : fornecedor.getCnaes()) {
            try {
                cnaeDAO = new CnaeDAO();
                cnae.setForId(fornecedor.getId());
                cnaeDAO.alterar(cnae);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
             
        
        for(Produto produto : fornecedor.getProdutosOfertados()) {
            try {
                produtoDAO = new ProdutoDAO();	 
                produto.setForId(fornecedor.getId());
                produtoDAO.alterar(produto);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        for(Servico servico : fornecedor.getServicosOfertados()) {
            try {
                servicoDAO = new ServicoDAO();
                servico.setForId(fornecedor.getId());
                servicoDAO.alterar(servico);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    } catch (SQLException e) {
        try {
            connection.rollback();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        e.printStackTrace();
    }finally{
    	if(ctrlTransaction) {
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
    }

    
    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) {    	 	
    	
        Fornecedor fornecedor = (Fornecedor) entidade;
        List<Contato> contatos = new ArrayList<>();
        List<Telefone> telefones = new ArrayList<>();
        List<Cnae> cnaes = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();
        List<Servico> servicos = new ArrayList<>();

        PreparedStatement pstFornecedor = null;
        /*PreparedStatement pstCnae = null;
        PreparedStatement pstTelefone = null;
        PreparedStatement pstContato = null;
        PreparedStatement pstProduto = null;
        PreparedStatement pstServico = null;*/
        

        String sqlFornecedor = null;
		

        if (fornecedor.getPesquisa() != null) {

            sqlFornecedor = "Select * from tab_fornecedores WHERE "
                    + "CAST(for_id as text) LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "CAST(for_dtcadastro as text) LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "for_nmfantasia LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "for_rzsocial LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "CAST(for_cnpj as text) LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "CAST(for_inscestadual as text) LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "for_email LIKE '%" + fornecedor.getPesquisa() + "%' or "
                    + "CAST(for_inscmunicipal as text) LIKE '%" + fornecedor.getPesquisa() + "%' ORDER BY for_id;";
            

        } else {
            sqlFornecedor = "SELECT * FROM tab_fornecedores ORDER BY for_id;";
        }
        
        /*String sqlContato = "SELECT * FROM tab_contatos WHERE ctt_for_id = ? ORDER BY ctt_id;";
        String sqlTelefone = "SELECT * FROM tab_telefones WHERE tel_for_id = ? ORDER BY tel_id;";
        String sqlCnae = "SELECT * FROM tab_cnaes WHERE cna_for_id = ? ORDER BY cna_id;";
        String sqlProduto = "SELECT * FROM tab_produtos WHERE pro_for_id = ? ORDER BY pro_id;";
        String sqlServico = "SELECT * FROM tab_servicos WHERE ser_for_id = ? ORDER BY ser_id;";*/

        try {
            openConnection();
            pstFornecedor = connection.prepareStatement(sqlFornecedor);
            ResultSet rsFornecedor = pstFornecedor.executeQuery();

            List<EntidadeDominio> fornecedores = new ArrayList<EntidadeDominio>();

            while (rsFornecedor.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rsFornecedor.getInt("for_id"));
                f.setDtCadastro(rsFornecedor.getDate("for_dtcadastro"));
                f.setNmFantasia(rsFornecedor.getString("for_nmfantasia"));
                f.setRzSocial(rsFornecedor.getString("for_rzsocial"));
                f.setCnpj(rsFornecedor.getString("for_cnpj"));
                f.setInscricaoEstadual(rsFornecedor.getString("for_inscestadual"));
                f.setInscricaoMunicipal(rsFornecedor.getString("for_inscmunicipal"));
                f.setEmail(rsFornecedor.getString("for_email"));
                f.setStatus(rsFornecedor.getString("for_status"));
                Endereco e = new Endereco();
                e.setTipo(rsFornecedor.getString("for_end_tipo"));
                e.setCep(rsFornecedor.getString("for_end_cep"));
                e.setTipoLogradouro(rsFornecedor.getString("for_end_tipologradouro"));
                e.setLogradouro(rsFornecedor.getString("for_end_logradouro"));
                e.setNumero(rsFornecedor.getString("for_end_numero"));
                e.setBairro(rsFornecedor.getString("for_end_bairro"));
                e.setComplemento(rsFornecedor.getString("for_end_complemento"));
                e.setCidade(rsFornecedor.getString("for_end_cidade"));
                e.setEstadoUf(rsFornecedor.getString("for_end_estado_uf"));
                e.setPais(rsFornecedor.getString("for_end_pais"));
                f.setEndereco(e);
                Empresa emp = new Empresa();
                emp.setTipo(rsFornecedor.getString("for_tipo_empresa"));
                emp.setTipoFornecimento(rsFornecedor.getString("for_tipo_fornecimento"));
                f.setEmpresa(emp);
                      
                cnaes = (List<Cnae>)(List<?>)cnaeDAO.consultar(f);
                contatos = (List<Contato>)(List<?>)contatoDAO.consultar(f);
                telefones = (List<Telefone>)(List<?>)telefoneDAO.consultar(f);
                produtos = (List<Produto>)(List<?>)produtoDAO.consultar(f);
                servicos = (List<Servico>)(List<?>)servicoDAO.consultar(f);
                
                f.setCnaes(cnaes);
                f.setContatos(contatos);
                f.setTelefones(telefones);
                f.setProdutosOfertados(produtos);
                f.setServicosOfertados(servicos);        	
                             
                fornecedores.add(f);
            }

            return fornecedores;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }



    
    public void ativar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE ");
		sql.append(table);
		sql.append(" SET ");
		sql.append("for_status");
		sql.append("=");
		sql.append("?");	
		sql.append(" WHERE ");
		sql.append(idTable);
		sql.append("=");
		sql.append("?");	
		try {
			connection.setAutoCommit(false);				
			pst = connection.prepareStatement(sql.toString());
				
			pst.setString(1, "ATIVO");
			pst.setInt(2, fornecedor.getId());
		
			pst.executeUpdate();		
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void inativar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE ");
		sql.append(table);
		sql.append(" SET ");
		sql.append("for_status");
		sql.append("=");
		sql.append("?");	
		sql.append(" WHERE ");
		sql.append(idTable);
		sql.append("=");
		sql.append("?");	
		try {
			connection.setAutoCommit(false);				
			pst = connection.prepareStatement(sql.toString());
				
			pst.setString(1, "INATIVO");
			pst.setInt(2, fornecedor.getId());
		
			pst.executeUpdate();		
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction) {
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}   
}


