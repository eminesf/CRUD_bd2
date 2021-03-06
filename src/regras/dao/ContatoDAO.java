package regras.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import agenda.Contato;
import agenda.Pessoa;
import conexao.factory.ConnectionFactory;

public class ContatoDAO {
	
	public void saveContato(Contato contato, Pessoa pessoa) {
		
		String sql = "INSERT INTO contato(telefone, email, idPessoa) VALUES(?,?,?)";
		
		Connection conexao = null;
		PreparedStatement prepare = null;
		
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepare = (PreparedStatement) conexao.prepareStatement(sql);
			
			prepare.setInt(1, contato.getTelefone());
			prepare.setString(2, contato.getEmail());
			prepare.setInt(3, pessoa.getId());
			
			prepare.execute();
			
			System.out.println("Contato de " + pessoa.getName() + " salvo com sucesso");
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
}
