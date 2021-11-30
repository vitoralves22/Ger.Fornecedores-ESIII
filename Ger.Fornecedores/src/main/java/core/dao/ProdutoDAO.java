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
import dominio.*;



public class ProdutoDAO extends AbstractJdbcDAO{
	
	public ProdutoDAO(Connection cx){
		super(cx, "tab_produtos", "pro_id");
	}

    public ProdutoDAO() {
        super("tab_produtos", "pro_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	if(connection == null){
			openConnection();
		}
		
    	PreparedStatement pst=null;
		
        	Produto produto = (Produto)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_produtos(pro_descricao, pro_for_id, pro_dtCadastro ) "); 
            sql.append(" VALUES (?, ?, ?)");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, produto.getDescricao());
            pst.setInt(2, produto.getForId());          
            pst.setTimestamp(3, new Timestamp(produto.getDtCadastro().getTime()));
            pst.executeUpdate();
            
            
            ResultSet rs = pst.getGeneratedKeys();
			int idProduto=0;
			if(rs.next())
                idProduto = rs.getInt(1);
			produto.setId(idProduto);

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
		
        	Produto produto = (Produto)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("UPDATE tab_produtos SET pro_descricao=?"); 
            sql.append("WHERE pro_for_id=?");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, produto.getDescricao());
            pst.setInt(2, produto.getForId());          
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
		List<EntidadeDominio> listaProdutos = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_produtos WHERE pro_for_id = ?");

		
		try {
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
            ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaProdutos.add(new Produto(
					rs.getInt("pro_id"),
					rs.getString("pro_descricao"),
					new Date(rs.getTimestamp("pro_dtcadastro").getTime()),
					rs.getInt("pro_for_id")
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
		return listaProdutos;
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


