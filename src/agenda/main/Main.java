package agenda.main;

import java.util.Date;

import agenda.Contato;
import regras.dao.ContatoDAO;

public class Main {

	public static void main(String[] args) {
		
		/*Contato contato = new Contato();
		
		contato.setName("Gabriela");
		contato.setAge(27);
		contato.setDataDeCadastro(new Date());
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		contatoDao.save(contato);*/
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		System.out.println(contatoDao.getContatos().toString());
		
		
	}
}
