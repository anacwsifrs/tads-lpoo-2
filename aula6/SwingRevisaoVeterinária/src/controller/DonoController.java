package controller;

import java.util.ArrayList;
import java.util.List;

import model.Dono;

public class DonoController {
	int proxId=0;
	private List<Dono> donos;
	
	public DonoController() {
	    donos = new ArrayList<>();
	}
	
	public Dono cadastrar( String nome,String telefone){
		
		Dono dono = new Dono(proxId,nome,telefone);
		
		donos.add(dono);
		
		proxId++;
		
		return dono;
	}
	
	public List<Dono> listar(){
	    return donos;
	}
	
	public Dono buscarPorId(int id){
	
		for (Dono dono : donos){
		
			if (dono.getId() == id) {
			    return dono;
			}
		}
		
		return null;
	}
	
	public void excluir(int id) {
	
		Dono tutor = buscarPorId(id);
		
		if (tutor != null) {
		    donos.remove(tutor);
		}
	}
}