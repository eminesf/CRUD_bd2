package regras.dao;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import agenda.Pessoa;
import conexao.factory.ConnectionFactory;

public class PessoaDAO {

	public void savePessoa(Pessoa pessoa) {

		String sql = "INSERT INTO pessoa(nome, idade, dataCadastrato) VALUES(?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			pstm.setString(1, pessoa.getName());
			pstm.setInt(2, pessoa.getAge());
			pstm.setDate(3, new Date(pessoa.getDataDeCadastro().getTime()));

			pstm.execute();

			System.out.println("Pessoa salva com sucesso!");
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

//	public List<Pessoa> getContatos() {
//
//		String sql = "SELECT * FROM pessoa";
//
//		List<Pessoa> pessoa = new ArrayList<Pessoa>();
//
//		Connection conn = null;
//		PreparedStatement pstm = null;
//		ResultSet rset = null;
//
//		try {
//			conn = ConnectionFactory.createConnectionToMySQL();
//			pstm = (PreparedStatement) conn.prepareStatement(sql);
//			rset = pstm.executeQuery();
//
//			while (rset.next()) {
//				Pessoa contato = new Pessoa();
//
//				contato.setId(rset.getInt("id"));
//				contato.setName(rset.getString("nome"));
//				contato.setAge(rset.getInt("idade"));
//				contato.setDataDeCadastro(rset.getDate("dataCadastrato"));
//
//				pessoa.add(contato);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//
//			try {
//				if (rset != null) {
//					rset.close();
//				}
//
//				if (pstm != null) {
//					pstm.close();
//				}
//
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return pessoa;
//	}

}
