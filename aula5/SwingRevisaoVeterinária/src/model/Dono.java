package model;

public class Dono extends Pessoa{

	public Dono(int id,String nome, String telefone) {
		super(id, nome, telefone);
		
	}
    @Override // utili para os comboboxes
    public String toString() {
        return nome;
    }
}
