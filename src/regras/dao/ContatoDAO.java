package regras.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import agenda.Contato;
import conexao.factory.ConnectionFactory;

public class ContatoDAO {

	public void save(Contato contato) {

		String sql = "INSERT INTO contato(nome, idade, dataCadastrato) VALUES(?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, contato.getName());
			pstm.setInt(2, contato.getAge());
			pstm.setDate(3, new Date(contato.getDataDeCadastro().getTime()));

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if (conn!= null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
