package br.com.Andiara.Cancela.teste;

import java.sql.SQLException;
import br.com.Andiara.Cancela.model.Cancela;
import br.com.Andiara.Cancela.service.CancelaService;

public class CancelaTeste {

	public static void main(String[] args) throws SQLException {

		CancelaService cs = new CancelaService();
		Cancela cancela = cs.buscarCancelaCOD(1);
		cs.abrir(cancela);

	}
}
