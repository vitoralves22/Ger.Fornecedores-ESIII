package main.java.mvc.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import main.java.mvc.core.util.Conexao;
import main.java.mvc.model.domain.EntidadeDominio;
import main.java.mvc.model.domain.Fornecedor;

public class FornecedorDAO extends AbstractJdbcDAO{
	
	public FornecedorDAO(Connection cx){
		super(cx, "tab_fornecedores", "for_id");
	}

    public FornecedorDAO() {
        super("tab_fornecedores", "for_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
        	Fornecedor fornecedor = (Fornecedor)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_fornecedores(for_nmFantasia, for_rzSocial, for_cnpj, for_inscEstadual, for_inscMunicipal, for_email, for_status,"
            		+ "for_end_tipo, for_end_cep, for_end_tipoLogradouro, for_end_logradouro, for_end_numero, for_end_bairro, for_end_complemento,"
            		+ "for_end_cidade, for_end_estado_uf, for_end_pais, for_dtCadastro) "); 
            sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, fornecedor.getNmFantasia());
            pst.setString(2, fornecedor.getRzSocial());
            pst.setString(3, fornecedor.getCnpj());
            pst.setString(4, fornecedor.getInscricaoEstadual());
            pst.setString(5, fornecedor.getInscricaoMunicipal());
            pst.setString(6, fornecedor.getEmail());
            pst.setString(7, fornecedor.getStatus().getDescricao());
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
            
            
            ResultSet rs = pst.getGeneratedKeys();
			int idFornecedor=0;
			if(rs.next())
                idFornecedor = rs.getInt(1);
			fornecedor.setId(idFornecedor);

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            
            try {
                pst.close();
                if(ctrlTransaction)
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void alterar(EntidadeDominio entidade) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    protected void openConnection(){
        try {
            if(connection == null ||connection.isClosed())
            connection = Conexao.getConnectionPostgres();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}


