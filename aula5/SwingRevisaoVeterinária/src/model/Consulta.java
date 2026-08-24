package model;

public class Consulta {

	private int id;
    private Animal animal;
    private String data;
    private Veterinario veterinario;
    private String descricao;

    public Consulta(int id,Animal animal,String data,Veterinario veterinario,String descricao) {
        this.id = id;
        this.animal = animal;
        this.data = data;
        this.veterinario = veterinario;
        this.descricao = descricao;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}