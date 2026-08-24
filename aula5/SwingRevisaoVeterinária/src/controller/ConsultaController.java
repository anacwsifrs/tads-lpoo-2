package controller;

import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Consulta;
import model.Veterinario;

public class ConsultaController {
	int proxId=0;
    private List<Consulta> consultas;

    public ConsultaController() {
        consultas = new ArrayList<>();
    }

    public Consulta cadastrar(Animal animal,String data,Veterinario veterinario,String descricao) {

        Consulta consulta = new Consulta(proxId,animal,data,veterinario,descricao);

        consultas.add(consulta);

        proxId++;

        return consulta;
    }

    public List<Consulta> listar() {
        return consultas;
    }

    public Consulta buscarPorId(int id) {

        for (Consulta consulta : consultas) {

            if (consulta.getId() == id) {
                return consulta;
            }
        }

        return null;
    }

    public void excluir(int id) {

        Consulta consulta = buscarPorId(id);

        if (consulta != null) {
            consultas.remove(consulta);
        }
    }
}