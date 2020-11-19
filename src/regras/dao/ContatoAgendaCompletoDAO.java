package regras.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import agenda.Contato;
import agenda.ContatoAgendaCompleto;
import agenda.Endereco;
import agenda.Pessoa;
import conexao.factory.ConnectionFactory;

public class ContatoAgendaCompletoDAO {
	
	public List<ContatoAgendaCompleto> getContatos(){
		
		String sql = "select p.id, p.nome, p.idade, p.rg, p.dataCadastrato, e.rua, e.cidade, e.estado, e.pais, c.telefone, c.email from pessoa as p, endereco as e, contato as c where p.id = e.idPessoa AND p.id = c.idPessoa";
		
		List<ContatoAgendaCompleto> listaContatosCompleto = new ArrayList<ContatoAgendaCompleto>();
		
		Connection conexao = null;
		PreparedStatement prepare = null;
		ResultSet result = null;
		
		try {
			conexao = ConnectionFactory.createConnectionToMySQL();
			prepare = (PreparedStatement) conexao.prepareCall(sql);
			result = prepare.executeQuery();
			
			while (result.next()) {
				Pessoa pessoa = new Pessoa();
				Endereco endereco = new Endereco();
				Contato contato = new Contato();
				
				pessoa.setId(result.getInt("id"));
				pessoa.setName(result.getString("nome"));
				pessoa.setAge(result.getInt("idade"));
				pessoa.setRg(result.getInt("rg"));
				pessoa.setDataDeCadastro(result.getDate("dataCadastrato"));
				
				endereco.setRua(result.getString("rua"));
				endereco.setCidade(result.getString("cidade"));
				endereco.setEstado(result.getString("estado"));
				endereco.setPais(result.getString("pais"));

				contato.setTelefone(result.getInt("telefone"));
				contato.setEmail(result.getString("email"));
				
				ContatoAgendaCompleto contatoCompleto = new ContatoAgendaCompleto(contato, endereco, pessoa);
				
				listaContatosCompleto.add(contatoCompleto);				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if (result != null) {
					result.close();
				}
				
				if(prepare != null) {
					prepare.close();
				}
				
				if(conexao != null) {
					conexao.close();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}	
		return listaContatosCompleto;		
	}

}
