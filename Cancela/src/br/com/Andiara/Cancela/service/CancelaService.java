package br.com.Andiara.Cancela.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Andiara.Cancela.dao.CancelaDAO;
import br.com.Andiara.Cancela.jdbc.oracle.ConnectionPoolOracle;
import br.com.Andiara.Cancela.model.Cancela;

public class CancelaService {
	
	public void abrir(Cancela cancela) throws SQLException {
		cancela.setSituacao(true);
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			CancelaDAO cancelaDAO = new CancelaDAO(con);
			cancelaDAO.alterarSituacaoAbrir(cancela);
		}
		System.out.println("Cancela Aberta");
	}
	
	public void fechar(Cancela cancela) throws SQLException {
		cancela.setSituacao(false);
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			CancelaDAO cancelaDAO = new CancelaDAO(con);
			cancelaDAO.alterarSituacaoFechar(cancela);
		}
		System.out.println("Cancela Fechada");
		
	}
	
	public Cancela buscarCancelaCOD(int codigo) throws SQLException{
		try (Connection con = new ConnectionPoolOracle().getConnection()) {
			CancelaDAO cancelaDAO = new CancelaDAO(con);
		
			return cancelaDAO.buscarCancelaCOD(codigo);
		
		}
		
	}

}
