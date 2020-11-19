package agenda;

import java.util.Date;

public class Pessoa {

	private int id;
	private String name;
	private int age;
	private int rg;
	private Date dataDeCadastro;

	

	public Pessoa() {

	}

	public Pessoa(String name, int age, int rg, Date dataDeCadastro) {
		this.name = name;
		this.age = age;
		this.rg = rg;
		this.dataDeCadastro = dataDeCadastro;
	}
	
	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", name=" + name + ", age=" + age + ", dataDeCadastro=" + dataDeCadastro + "]\n";
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
