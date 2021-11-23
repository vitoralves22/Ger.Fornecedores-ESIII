package core.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
	
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Connection conexao = Conexao.getConnectionPostgres();
		 
		if(conexao!= null) {
			System.out.println("Conectado!!!");
		}else {
			System.out.println("NAO CONECTADO =(");
		}
			
	}

}
