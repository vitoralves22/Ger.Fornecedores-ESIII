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
import model.domain.EntidadeDominio;
import model.domain.*;

public class FornecedorDAO extends AbstractJdbcDAO{
	
	public FornecedorDAO(Connection cx){
		super(cx, "tab_fornecedores", "for_id");
	}

    public FornecedorDAO() {
        super("tab_fornecedores", "for_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        	Fornecedor fornecedor = (Fornecedor)entidade;  	
        	
        	IDAO empresaDAO = new EmpresaDAO();
        	IDAO cnaeDAO = new CnaeDAO();
            IDAO contatoDAO = new ContatoDAO();
            IDAO telefoneDAO = new TelefoneDAO();
            IDAO produtoDAO = new ProdutoDAO();
            IDAO servicoDAO = new ServicoDAO();
            
        	openConnection();
			PreparedStatement pst=null;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_fornecedores(for_nmFantasia, for_rzSocial, for_cnpj, for_inscEstadual, for_inscMunicipal, for_email, for_status,"
            		+ "for_end_tipo, for_end_cep, for_end_tipoLogradouro, for_end_logradouro, for_end_numero, for_end_bairro, for_end_complemento,"
            		+ "for_end_cidade, for_end_estado_uf, for_end_pais, for_dtCadastro) "); 
            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
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
            pst.setTimestamp(18, new Timestamp(fornecedor.getDtCadastro().getTime()));
            pst.executeUpdate();
            connection.commit();
            
            ResultSet rs = pst.getGeneratedKeys();
            
			if(rs.next()) {
				fornecedor.setId(rs.getInt(1));
				
			}
			
			System.out.println(fornecedor.getId());	
				
			for(Contato contato : fornecedor.getContatos()) {
	            try {
	                contatoDAO = new ContatoDAO();
	                contatoDAO.salvar(contato);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Telefone telefone : fornecedor.getTelefones()) {
	            try {
	                telefoneDAO = new TelefoneDAO();                
	                telefoneDAO.salvar(telefone);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Cnae cnae : fornecedor.getCnaes()) {
	            try {
	                cnaeDAO = new CnaeDAO();	                
	                cnaeDAO.salvar(cnae);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	             
	        for(Empresa empresa : fornecedor.getEmpresas()) {
	            try {
	                empresaDAO = new EmpresaDAO();	                
	                empresaDAO.salvar(empresa);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Produto produto : fornecedor.getProdutosOfertados()) {
	            try {
	                produtoDAO = new ProdutoDAO();	                
	                produtoDAO.salvar(produto);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        
	        for(Servico servico : fornecedor.getServicosOfertados()) {
	            try {
	                servicoDAO = new ServicoDAO();	                
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
    public void alterar(EntidadeDominio entidade) throws SQLException {
        // TODO Auto-generated method stub
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
    	IDAO cnaeDAO = new CnaeDAO();
		IDAO telefoneDAO = new TelefoneDAO();
		IDAO contatoDAO = new ContatoDAO();
		IDAO empresaDAO = new EmpresaDAO();
		IDAO produtoDAO = new ProdutoDAO();
		IDAO servicoDAO = new ServicoDAO();

		Fornecedor fornecedor = (Fornecedor) entidade;
		List<EntidadeDominio> listaFornecedores = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM ");
		sql.append(table);
		sql.append(" WHERE ");
		sql.append(idTable);
		sql.append("=");
		sql.append("?");
		
		try {				
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaFornecedores.add(new Fornecedor(
					rs.getInt("for_id"),
					rs.getString("for_nmfantasia"),
					rs.getString("for_rzsocial"),
					rs.getString("for_cnpj"),
					rs.getString("for_inscestadual"),
					rs.getString("for_inscmunicipal"),
					rs.getString("for_email"),
					new Endereco(
						rs.getString("for_end_tipo"),
						rs.getString("for_end_cep"),
						rs.getString("for_end_tipologradouro"),
						rs.getString("for_end_logradouro"),
						rs.getString("for_end_numero"),
						rs.getString("for_end_bairro"),
						rs.getString("for_end_complemento"),
						rs.getString("for_end_cidade"),
						rs.getString("for_end_estado_uf"),
						rs.getString("for_end_pais")
					),
					(List<Cnae>)(List<?>)cnaeDAO.consultar(fornecedor),
					(List<Telefone>)(List<?>)telefoneDAO.consultar(fornecedor),
					(List<Contato>)(List<?>)contatoDAO.consultar(fornecedor),
					(List<Empresa>)(List<?>)empresaDAO.consultar(fornecedor),
					(List<Produto>)(List<?>)produtoDAO.consultar(fornecedor),
					(List<Servico>)(List<?>)servicoDAO.consultar(fornecedor),
					rs.getString("for_status"),
					new Date(rs.getTimestamp("for_dtcadastro").getTime())
				));
			}		
		
		
		} catch (SQLException e) {
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listaFornecedores;
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


