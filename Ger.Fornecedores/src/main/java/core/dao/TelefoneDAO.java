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

import dominio.*;

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
		
		
		sql.append("INSERT INTO tab_telefones(tel_dddTelefone, tel_ddiTelefone, tel_numeroTelefone, tel_for_id, tel_dtCadastro)");
		sql.append(" VALUES (?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, tel.getDdd());
            pst.setString(2, tel.getDdi());
            pst.setString(3, tel.getNumero());
            pst.setInt(4, tel.getForId());

			Timestamp time = new Timestamp(tel.getDtCadastro().getTime());
            pst.setTimestamp(5, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()){
				tel.setId(rs.getInt(1));
			}
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

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Telefone tel = (Telefone)entidade;
		StringBuilder sql = new StringBuilder();
		
		
		sql.append("UPDATE tab_telefones SET tel_dddTelefone=?, tel_ddiTelefone=?, tel_numeroTelefone=?");
        sql.append("WHERE tel_for_id=? AND tel_id=?");

		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, tel.getDdd());
            pst.setString(2, tel.getDdi());
            pst.setString(3, tel.getNumero());
            pst.setInt(4, tel.getForId());
            pst.setInt(5, tel.getId());
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


	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
		List<EntidadeDominio> listaTelefones = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_telefones WHERE tel_for_id = ?");
		
		try {				
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
            ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaTelefones.add(new Telefone(
					rs.getInt("tel_id"),
					rs.getString("tel_dddtelefone"),
					rs.getString("tel_dditelefone"),
					rs.getString("tel_numerotelefone"),
					new Date(rs.getTimestamp("tel_dtcadastro").getTime()),
					rs.getInt("tel_for_id")
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
		return listaTelefones;
	}

}

