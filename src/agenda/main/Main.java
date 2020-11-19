package agenda.main;

import java.util.Date;

import agenda.Contato;
import agenda.ContatoAgendaCompleto;
import agenda.Endereco;
import agenda.Pessoa;
import regras.dao.ContatoAgendaCompletoDAO;
import regras.dao.ContatoDAO;
import regras.dao.EnderecoDAO;
import regras.dao.PessoaDAO;

public class Main {

	public static void main(String[] args) {
		

		
//		Pessoa pessoa = new Pessoa("Gabi", 28, 3088, new Date());
//		Endereco endereco = new Endereco("Rua A", "Porto Alegre", "RS", "Brasil");
//		Contato contato = new Contato(995582616, "emiliano@gmail.com");
//		
//		PessoaDAO pessoaDAO = new PessoaDAO();
//		EnderecoDAO enderecoDAO = new EnderecoDAO();
//		ContatoDAO contatoDAO = new ContatoDAO();
//		
//		pessoaDAO.savePessoa(pessoa);
//		enderecoDAO.saveEndereco(endereco, pessoa);
//		contatoDAO.saveContato(contato, pessoa);
//		
//		ContatoAgendaCompleto contatinho1 = new ContatoAgendaCompleto(contato, endereco, pessoa);
		
		ContatoAgendaCompletoDAO contatoCompletoDAO = new ContatoAgendaCompletoDAO();
		
		
		System.out.println(contatoCompletoDAO.getContatos().toString());
		
	}
}
