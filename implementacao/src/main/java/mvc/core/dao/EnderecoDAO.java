package main.java.mvc.core.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import main.java.mvc.model.domain.Endereco;
import main.java.mvc.model.domain.EntidadeDominio;

public class EnderecoDAO extends AbstractJdbcDAO {
	

	public EnderecoDAO(Connection cx){
		super(cx, "tab_endereco", "end_id");
	}
	
	public EnderecoDAO(){
		super("tab_endereco", "end_id");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO tab_endereco(");
		sql.append("end_tipoEndereco, end_cep, end_tipoLogradouro, end_logradouro,  end_numero, end_bairro, end_complemento, end_cidade, end_uf, end_pais, end_dtCadastro) ");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
								
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
            pst.setString(1, end.getTipoEndereco().getNome());
            pst.setString(2, end.getCep());
            pst.setString(3,end.getTipoLogradouro().getNome());   
            pst.setString(4, end.getLogradouro());     
            pst.setString(5, end.getNumero());
			pst.setString(6, end.getBairro());
            pst.setString(7, end.getComplemento());
			pst.setString(8, end.getCidade().getDescricao());
            pst.setString(9, end.getCidade().getUf().getSigla());
            pst.setString(10, end.getCidade().getUf().getPais().getDescricao());
            
            Timestamp time = new Timestamp(end.getDtCadastro().getTime());
            pst.setTimestamp(11, time);
			
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			end.setId(idEnd);
			
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

