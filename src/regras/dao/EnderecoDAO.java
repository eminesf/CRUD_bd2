package regras.dao;

import java.sql.Connection;

import com.mysql.jdbc.PreparedStatement;

import agenda.Endereco;
import agenda.Pessoa;
import conexao.factory.ConnectionFactory;

public class EnderecoDAO {
	
	public void saveEndereco(Endereco endereco, Pessoa pessoa) {

		String sql = "INSERT INTO endereco(rua, cidade, estado, pais, idPessoa) VALUES(?,?,?,?,?)";

		Connection conexao = null;
		PreparedStatement prepare = null;

		try {
			conexao = ConnectionFactory.createConnectionToMySQL();

			prepare = (PreparedStatement) conexao.prepareStatement(sql);

			prepare.setString(1, endereco.getRua());
			prepare.setString(2, endereco.getCidade());
			prepare.setString(3, endereco.getEstado());
			prepare.setString(4, endereco.getPais());
			prepare.setInt(5, pessoa.getId());
			
			prepare.execute();

			System.out.println("Endereço de " + pessoa.getName() + " salvo com sucesso!");
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
