package main.java.mvc.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import main.java.mvc.model.domain.Telefone;
import main.java.mvc.model.domain.EntidadeDominio;

public class TelefoneDAO extends AbstractJdbcDAO {
	

	public TelefoneDAO(Connection cx){
		super(cx, "tab_telefones", "tel_id");
	}
	
	public TelefoneDAO(){
		super("tab_telefones", "tel_id");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Telefone tel = (Telefone)entidade;
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("INSERT INTO tab_telefones(tel_dddTelefone, tel_ddiTelefone, tel_numeroTelefone, tel_dtCadastro, tel_ctt_id)");
		sql.append(" VALUES (?, ?, ?, ?, (SELECT MAX(tab_contatos.ctt_id) FROM tab_contatos))");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, tel.getDdd());
            pst.setString(2, tel.getDdd());
            pst.setString(3, tel.getDdd());

			Timestamp time = new Timestamp(tel.getDtCadastro().getTime());
            pst.setTimestamp(4, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idTel=0;
			if(rs.next())
				idTel = rs.getInt(1);
			tel.setId(idTel);
			
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
					// TODO Auto-generated catch block
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
