package model;

public class Animal {
	
	String nome;
	String especie;
	String raca;
	Dono dono;
	int id;
	
	public Animal(int id,String nome, String especie, String raca, Dono dono) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.dono = dono;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public Dono getDono() {
		return dono;
	}
	public void setDono(Dono dono) {
		this.dono = dono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return nome;
	}
}