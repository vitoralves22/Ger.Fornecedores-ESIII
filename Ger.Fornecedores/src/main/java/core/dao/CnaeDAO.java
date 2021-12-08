package core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import core.util.Conexao;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.Cnae;


public class CnaeDAO extends AbstractJdbcDAO{
	
	public CnaeDAO(Connection cx){
		super(cx, "tab_cnaes", "cna_id");
	}

    public CnaeDAO() {
        super("tab_cnaes", "cna_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
        	Cnae cnae = (Cnae)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_cnaes(cna_numero, cna_dtCadastro, cna_for_id) "); 
            sql.append(" VALUES (?, ?, ?)");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, cnae.getCodigo());
            pst.setTimestamp(2, new Timestamp(cnae.getDtCadastro().getTime()));
            pst.setInt(3, cnae.getForId());
            pst.executeUpdate();
            
            
            ResultSet rs = pst.getGeneratedKeys();
			int idCnae=0;
			if(rs.next())
                idCnae = rs.getInt(1);
			cnae.setId(idCnae);

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
    	if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
        	Cnae cnae = (Cnae)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("UPDATE tab_cnaes SET cna_numero=?"); 
            sql.append("WHERE cna_for_id=? AND cna_id=?");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, cnae.getCodigo());
            pst.setInt(2, cnae.getForId());
            pst.setInt(3, cnae.getId());
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
    public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
    	
    	Fornecedor fornecedor = (Fornecedor) entidade;
		List<EntidadeDominio> listaCnaes = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_cnaes WHERE cna_for_id = ?");
		
		try {
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaCnaes.add(new Cnae(
					rs.getInt("cna_id"),
					rs.getString("cna_numero"),
					new Date(rs.getTimestamp("cna_dtcadastro").getTime()),
					rs.getInt("cna_for_id")
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
		return listaCnaes;
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


