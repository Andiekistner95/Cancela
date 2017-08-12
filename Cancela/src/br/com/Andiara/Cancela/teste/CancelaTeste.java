package br.com.Andiara.Cancela.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Cancela.dao.CancelaDAO;
import br.com.Andiara.Cancela.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Cancela.model.Cancela;

public class CancelaTeste {
	
	public static void main(String[] args) throws SQLException {
		
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			CancelaDAO cancelaDAO = new CancelaDAO(con);
			List<Cancela> cancelas = cancelaDAO.lista();
			for (Cancela cancela : cancelas) {
				System.out.println(cancela.getCodigo());
			}
		}
	}
}
