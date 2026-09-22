package service;

import dao.CursoDAO;
import model.Curso;

import java.util.List;

public class CursoService {

    private final CursoDAO dao;

    public CursoService() {
        this.dao = new CursoDAO();
    }

    public void cadastrar(Curso curso) {
        validar(curso);
        dao.salvar(curso);
    }

    public void atualizar(Curso curso) {
        validar(curso);
        dao.atualizar(curso);
    }

    public List<Curso> listarTodos() {
        return dao.listarTodos();
    }

    public Curso buscarPorId(int id) {
        return dao.buscarPorId(id);
    }

    public void excluir(int id) {
        dao.excluir(id);
    }

    private void validar(Curso curso) {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }
        if (curso.getCargaHoraria() <= 0) {
            throw new IllegalArgumentException("Carga horária inválida");
        }
    }
}