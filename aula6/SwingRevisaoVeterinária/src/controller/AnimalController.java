package controller;

import java.util.List;
import dao.AnimalDAO;
import model.Animal;
import model.Dono;

public class AnimalController {
    private AnimalDAO dao;

    public AnimalController() {
        this.dao = new AnimalDAO();
    }

    public Animal cadastrar(String nome, String especie, String raca, Dono dono) {
        Animal animal = new Animal(0, nome, especie, raca, dono);
        dao.salvar(animal);
        return animal;
    }

    public List<Animal> listar() {
        return dao.listarTodos();
    }
}