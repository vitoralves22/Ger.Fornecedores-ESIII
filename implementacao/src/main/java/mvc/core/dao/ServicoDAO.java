package main.java.mvc.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import main.java.mvc.core.util.Conexao;
import main.java.mvc.model.domain.Empresa;
import main.java.mvc.model.domain.EntidadeDominio;
import main.java.mvc.model.domain.Fornecedor;
import main.java.mvc.model.domain.Servico;


public class ServicoDAO extends AbstractJdbcDAO{
	
	public ServicoDAO(Connection cx){
		super(cx, "tab_servicos", "ser_id");
	}

    public ServicoDAO() {
        super("tab_servicos", "ser_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
        	Servico servico = (Servico)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_servicos(ser_descricao, ser_for_id, ser_dtCadastro ) "); 
            sql.append(" VALUES (?, (SELECT MAX(tab_fornecedores.for_id) FROM tab_fornecedores), ?)");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, servico.getDescricao());      
            pst.setTimestamp(2, new Timestamp(servico.getDtCadastro().getTime()));
            pst.executeUpdate();
            
            
            ResultSet rs = pst.getGeneratedKeys();
			int idServico=0;
			if(rs.next())
                idServico = rs.getInt(1);
			servico.setId(idServico);

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
		Fornecedor fornecedor = (Fornecedor) entidade;
		List<EntidadeDominio> listaServicos = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_servicos WHERE ser_for_id = ?");

		
		try {				
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaServicos.add(new Servico(
					rs.getInt("ser_id"),
					rs.getString("ser_descricao"),
					new Date(rs.getTimestamp("ser_dtcadastro").getTime())
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
		return listaServicos;
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


