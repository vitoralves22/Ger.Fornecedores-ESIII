package main.java.mvc.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import main.java.mvc.model.domain.Contato;
import main.java.mvc.model.domain.Endereco;
import main.java.mvc.model.domain.EntidadeDominio;
import main.java.mvc.model.domain.Fornecedor;

public class ContatoDAO extends AbstractJdbcDAO {
	

	public ContatoDAO(Connection cx){
		super(cx, "tab_contatos", "ctt_id");
	}
	
	public ContatoDAO(){
		super("tab_contatos", "ctt_id");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		
		Contato ctt = (Contato)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tab_contatos(ctt_nome, ctt_dpto, ctt_email, ctt_dtCadastro, for_id) ");
		sql.append(" VALUES (?, ?, ?, ?, (SELECT MAX(tab_fornecedor.for_id) FROM tab_fornecedor))");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, ctt.getNome());
            pst.setString(2, ctt.getDepartamento().getDescricao());
			pst.setString(3, ctt.getEmail());
            
			Timestamp time = new Timestamp(ctt.getDtCadastro().getTime());
            pst.setTimestamp(4, time);
            
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idContato=0;
			if(rs.next())
				idContato = rs.getInt(1);
			ctt.setId(idContato);
			
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
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
	}

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	/** 
	 * TODO Descricao do Metodo
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}

