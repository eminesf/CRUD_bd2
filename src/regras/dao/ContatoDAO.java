package regras.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

			System.out.println("Contato salvo com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<Contato> getContatos() {

		String sql = "SELECT * FROM contato";

		List<Contato> contatos = new ArrayList<Contato>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Contato contato = new Contato();

				contato.setId(rset.getInt("id"));
				contato.setName(rset.getString("nome"));
				contato.setAge(rset.getInt("idade"));
				contato.setDataDeCadastro(rset.getDate("dataCadastrato"));

				contatos.add(contato);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}

}
