package br.com.Andiara.Cancela.teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.Andiara.Cancela.dao.CancelaDAO;
import br.com.Andiara.Cancela.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Cancela.model.Cancela;
import br.com.Andiara.Cancela.service.CancelaService;

public class CancelaTeste {

	public static void main(String[] args) throws SQLException {

		CancelaService cs = new CancelaService();
		Cancela cancela = cs.buscarCancelaCOD(1);
		cs.abrir(cancela);

	}
}
