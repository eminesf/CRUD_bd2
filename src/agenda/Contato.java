package agenda;

public class Contato {

	private int idContato;
	private int telefone;
	private String email;

	public Contato(int telefone, String email) {
		this.telefone = telefone;
		this.email = email;
	}

	public int getIdContato() {
		return idContato;
	}

	public void setIdContato(int idContato) {
		this.idContato = idContato;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
