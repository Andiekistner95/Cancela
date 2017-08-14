package br.com.Andiara.Cancela.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Andiara.Cancela.model.Cancela;

public class CancelaDAO {

	private final Connection con;

	public CancelaDAO(Connection con) {
		this.con = con;

	}

	public List<Cancela> lista() throws SQLException {
		List<Cancela> lCancela = new ArrayList<>();

		String sql = "select * from CANCELA";

		try (PreparedStatement stmt = con.prepareStatement(sql)) {

			stmt.execute();

			try (ResultSet rs = stmt.getResultSet()) {

				while (rs.next()) {

					boolean situacao = rs.getBoolean("Situacao");
					int codigo = rs.getInt("Codigo");
					Cancela cancela = new Cancela(situacao, codigo );
					lCancela.add(cancela);
				}
			}
		}

		return lCancela;

	}
	
	public boolean alterarSituacaoAbrir(Cancela cancela) throws SQLException{
		String sql = "UPDATE CANCELA SET SITUACAO = ? WHERE CODIGO = ?";
		 
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setBoolean(1,cancela.isSituacao());
		statement.setInt(2, cancela.getCodigo());
		 
		return statement.executeUpdate() > 0;
	}
	
	public boolean alterarSituacaoFechar(Cancela cancela) throws SQLException{
		String sql = "UPDATE CANCELA SET SITUACAO = ? WHERE CODIGO = ?";
		
		PreparedStatement sttm = con.prepareStatement(sql);
		sttm.setBoolean(1, cancela.isSituacao());
		sttm.setInt(2, cancela.getCodigo());
		
		return sttm.executeUpdate() > 0;
	}
	
	public Cancela buscarCancelaCOD(int codigo) throws SQLException{
		Cancela cancela = new Cancela();
		String sql = "select * from CANCELA where CODIGO = ?" ;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, codigo);
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					int cod = rs.getInt("codigo");
					boolean situacao = rs.getBoolean("situacao");
					cancela.setCodigo(cod);
					cancela.setSituacao(situacao);
				}
			}
		}
		return cancela;
	}
	
}









