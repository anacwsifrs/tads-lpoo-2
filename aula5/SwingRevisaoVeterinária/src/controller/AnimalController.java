package controller;

import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Dono;

public class AnimalController {
	int proxId=0;
	private List<Animal> animais;
	
	public AnimalController() {
	    animais = new ArrayList<>();
	}
	
	public Animal cadastrar(String nome,String especie,String raca,Dono dono) {
		
		Animal animal = new Animal(proxId,nome,especie,raca,dono);
		
		animais.add(animal);
		
		proxId++;
		
		return animal;
	}
	
	public List<Animal> listar() {
		return animais;
	}
	
	public Animal buscarPorId(int id) {
	
		for (Animal animal : animais) {
		
			if (animal.getId() == id) {
			    return animal;
			}
		}
		
		return null;
	}
	
	public void excluir(int id) {
	
		Animal animal = buscarPorId(id);
		
		if (animal != null) {
			animais.remove(animal);
		}
	}
}