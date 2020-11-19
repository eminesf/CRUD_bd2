package agenda;

import java.util.Date;

public class Pessoa {

	private int id;
	private String name;
	private int age;
	private Date dataDeCadastro;


	public Pessoa(int id, String name, int age, Date dataDeCadastro) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.dataDeCadastro = dataDeCadastro;
	}
	





	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", name=" + name + ", age=" + age + ", dataDeCadastro=" + dataDeCadastro + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

}
