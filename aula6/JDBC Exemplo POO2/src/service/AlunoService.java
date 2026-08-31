package service;

import dao.AlunoDAO;
import model.Aluno;

import java.util.List;

public class AlunoService {

    private final AlunoDAO dao;

    public AlunoService() {

        this.dao = new AlunoDAO();
    }

    public void matricular(Aluno aluno) {

        validar(aluno);

        dao.salvar(aluno);
    }

    public void atualizar(Aluno aluno) {

        validar(aluno);

        dao.atualizar(aluno);
    }

    public List<Aluno> listarTodos() {

        return dao.listarTodos();
    }

    public Aluno buscarPorId(int id) {

        return dao.buscarPorId(id);
    }

    public void excluir(int id) {

        dao.excluir(id);
    }

    private void validar(Aluno aluno) {

        if (aluno.getNome() == null || aluno.getNome().isBlank()) {

            throw new IllegalArgumentException("Nome obrigatório");
        }

        if (aluno.getIdade() < 16) {

            throw new IllegalArgumentException("Idade mínima é 16 anos");
        }
    }
}	