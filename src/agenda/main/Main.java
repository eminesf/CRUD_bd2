package agenda.main;

import java.util.Date;

import agenda.Contato;
import agenda.Endereco;
import agenda.Pessoa;
import regras.dao.ContatoDAO;
import regras.dao.EnderecoDAO;
import regras.dao.PessoaDAO;

public class Main {

	public static void main(String[] args) {
		
		/*Contato contato = new Contato();
		
		contato.setName("Gabriela");
		contato.setAge(27);
		contato.setDataDeCadastro(new Date());
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		contatoDao.save(contato);*/
		
		Pessoa pessoa = new Pessoa("Gabi", 28, 3088, new Date());
		Endereco endereco = new Endereco("Rua A", "Porto Alegre", "RS", "Brasil");
		Contato contato = new Contato(995582616, "emiliano@gmail.com");
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		ContatoDAO contatoDAO = new ContatoDAO();
		
		pessoaDAO.savePessoa(pessoa);
		enderecoDAO.saveEndereco(endereco, pessoa);
		contatoDAO.saveContato(contato, pessoa);
		
		
		
//		for(Pessoa c : contatoDao.getContatos()) {
//			System.out.println("Contato: " + c.getName());
//			System.out.println("Idade: " + c.getAge());
//			System.out.println("Data de cadastro: " + c.getDataDeCadastro()+ "\n");
//			
//		};
		
	}
}
