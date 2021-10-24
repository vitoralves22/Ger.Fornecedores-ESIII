package main.java.mvc.core.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import main.java.mvc.core.util.Conexao;
import main.java.mvc.model.domain.Endereco;
import main.java.mvc.model.domain.EntidadeDominio;
import main.java.mvc.model.domain.Fornecedor;

public class FornecedorDAO extends AbstractJdbcDAO{

    public FornecedorDAO() {
        super("tab_fornecedor", "for_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
        openConnection();
        PreparedStatement pst = null;
        Fornecedor fornecedor = (Fornecedor)entidade;
        Endereco end = fornecedor.getEndereco();
        
        try {
            connection.setAutoCommit(false);
            EnderecoDAO endDAO = new EnderecoDAO();
            endDAO.connection = connection;
            endDAO.ctrlTransaction = false;
            endDAO.salvar(end);

            StringBuilder sql = new StringBuilder();
            //sql.append("INSERT INTO tb_fornecedor(nmFantasia, rzSocial, cnpj, cnaes, inscricaoEstadual, inscricaoMunicipal, email, end_id"); 
            sql.append("INSERT INTO tab_fornecedor(for_nmFantasia, for_rzSocial, for_cnpj, for_inscEstadual, for_inscMunicipal, for_email, end_id, for_dtCadastro) "); 
            sql.append(" VALUES (?,?,?,?,?,?,?,?)");

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, fornecedor.getNmFantasia());
            pst.setString(2, fornecedor.getRzSocial());
            pst.setString(3, fornecedor.getCnpj());
            //pst.setArray(4, fornecedor.getCnaes()); //TODO resolver retorno de cnae(retorna cnae)
            pst.setString(4, fornecedor.getInscricaoEstadual());
            pst.setString(5, fornecedor.getInscricaoMunicipal());
            pst.setString(6, fornecedor.getEmail());
            pst.setInt(7, end.getId());

            Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
            
            pst.setTimestamp(8, time);
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


