package controller;

import java.util.List;
import dao.DonoDAO;
import model.Dono;

public class DonoController {
    private DonoDAO dao;

    public DonoController() {
        this.dao = new DonoDAO();
    }

    public Dono cadastrar(String nome, String telefone) {
        Dono dono = new Dono(0, nome, telefone);
        dao.salvar(dono);
        return dono;
    }

    public List<Dono> listar() {
        return dao.listarTodos();
    }
}