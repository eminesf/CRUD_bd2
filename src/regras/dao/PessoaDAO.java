package regras.dao;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import agenda.Pessoa;
import conexao.factory.ConnectionFactory;

public class PessoaDAO {

	public void savePessoa(Pessoa pessoa) {

		String sql = "INSERT INTO pessoa(nome, idade, rg, dataCadastrato) VALUES(?,?,?,?)";
		String sql2= "SELECT * FROM pessoa";
		
		Connection conexao = null;
		PreparedStatement prepare = null;
		ResultSet resultId = null;
		
		

		try {
			conexao = ConnectionFactory.createConnectionToMySQL();

			prepare = (PreparedStatement) conexao.prepareStatement(sql);

			prepare.setString(1, pessoa.getName());
			prepare.setInt(2, pessoa.getAge());
			prepare.setInt(3, pessoa.getRg());			
			prepare.setDate(4, new Date(pessoa.getDataDeCadastro().getTime()));

			prepare.execute();
			
			try {
				prepare = (PreparedStatement) conexao.prepareStatement(sql2);
				resultId = prepare.executeQuery();
				
				while(resultId.next()) {
					int resultado = resultId.getInt("rg");
					
					if(pessoa.getRg() == resultado) {
						pessoa.setId(resultId.getInt("id"));
					}
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(resultId != null) {
						resultId.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.println("Pessoa salva com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (prepare != null) {
					prepare.close();
				}

				if (conexao != null) {
					conexao.close();
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
