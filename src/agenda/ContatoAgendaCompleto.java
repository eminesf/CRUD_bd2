package agenda;

public class ContatoAgendaCompleto {
	
	private Contato contato;
	private Endereco endereco;
	private Pessoa pessoa;
	
	public ContatoAgendaCompleto(Contato contato, Endereco endereco, Pessoa pessoa) {
		this.contato = contato;
		this.endereco = endereco;
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "ContatoAgendaCompleto [contato=" + contato + ", endereco=" + endereco + ", pessoa=" + pessoa + "]";
	}
	
	
}
