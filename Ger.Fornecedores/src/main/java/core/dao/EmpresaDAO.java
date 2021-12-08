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
import dominio.Cnae;
import dominio.Empresa;
import dominio.EntidadeDominio;
import dominio.Fornecedor;


public class EmpresaDAO extends AbstractJdbcDAO{
	
	public EmpresaDAO(Connection cx){
		super(cx, "tab_empresas", "emp_id");
	}

    public EmpresaDAO() {
        super("tab_empresas", "emp_id");
    }

    @Override
    public void salvar(EntidadeDominio entidade) throws SQLException {
    	if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
        	Empresa empresa = (Empresa)entidade;
            StringBuilder sql = new StringBuilder();
            
            sql.append("INSERT INTO tab_empresas(emp_tipo, emp_tipo_fornecimento,emp_for_id, emp_dtCadastro ) "); 
            sql.append(" VALUES (?, ?, (SELECT MAX(tab_fornecedores.for_id) FROM tab_fornecedores), ?)");
            
            try {
                connection.setAutoCommit(false);

            pst = connection.prepareStatement(sql.toString());
            pst.setString(1, empresa.getTipoEmpresa().toString());
            pst.setString(2, empresa.getTipoFornecimento().toString());
            pst.setTimestamp(3, new Timestamp(empresa.getDtCadastro().getTime()));
            pst.executeUpdate();
            
            
            ResultSet rs = pst.getGeneratedKeys();
			int idEmpresa=0;
			if(rs.next())
                idEmpresa = rs.getInt(1);
			empresa.setId(idEmpresa);

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
		List<EntidadeDominio> listaEmp = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_empresas WHERE emp_for_id = ?");
		
		try {
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaEmp.add(new Empresa(
					rs.getInt("emp_id"),
					rs.getString("emp_tipo"),
					rs.getString("emp_tipo_fornecimento"),
					new Date(rs.getTimestamp("emp_dtcadastro").getTime())
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
		return listaEmp;
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


