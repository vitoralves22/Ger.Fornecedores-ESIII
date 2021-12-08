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
		
		sql.append("INSERT INTO tab_contatos(ctt_nome, ctt_dpto, ctt_email, ctt_dddtelefone, ctt_dditelefone, ctt_numerotelefone, ctt_dtCadastro, ctt_for_id) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, ctt.getNome());
            pst.setString(2, ctt.getDepartamento());
			pst.setString(3, ctt.getEmail());
			pst.setString(4, ctt.getTelefone().getDdd());
			pst.setString(5, ctt.getTelefone().getDdi());
			pst.setString(6, ctt.getTelefone().getNumero());
			Timestamp time = new Timestamp(ctt.getDtCadastro().getTime());
            pst.setTimestamp(7, time);
            pst.setInt(8, ctt.getForId());
            
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			if(rs.next()){
				ctt.setId(rs.getInt(1));
			}
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		} finally {
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
		
		Contato ctt = (Contato)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE tab_contatos SET ctt_nome=?, ctt_dpto=?, ctt_email=?, ctt_dddtelefone=?, ctt_dditelefone=?, ctt_numerotelefone=?");
		sql.append("WHERE ctt_for_id=? AND ctt_id=?");
		
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, ctt.getNome());
            pst.setString(2, ctt.getDepartamento());
			pst.setString(3, ctt.getEmail());
			pst.setString(4, ctt.getTelefone().getDdd());
			pst.setString(5, ctt.getTelefone().getDdi());
			pst.setString(6, ctt.getTelefone().getNumero());
			pst.setInt(7, ctt.getForId());
			pst.setInt(8, ctt.getId());
			pst.executeUpdate();		
					
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		} finally {
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
		List<EntidadeDominio> listaContatos = new ArrayList<EntidadeDominio>();
		openConnection();
		PreparedStatement pst=null;
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT * FROM tab_contatos WHERE ctt_for_id = ?");
		
		try {
			pst = connection.prepareStatement(sql.toString());
            pst.setInt(1, fornecedor.getId());
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				listaContatos.add(new Contato(
					rs.getInt("ctt_id"),
					rs.getString("ctt_nome"),
					rs.getString("ctt_dpto"),
					rs.getString("ctt_email"),
					new Telefone(
					rs.getString("ctt_dddtelefone"),
					rs.getString("ctt_dditelefone"),
					rs.getString("ctt_numerotelefone")
					),
					new Date(rs.getTimestamp("ctt_dtcadastro").getTime()),
					rs.getInt("ctt_for_id")
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
		//listaContatos.set(fornecedor.getContatos());
		return listaContatos;
	}

}



