package app;
import model.Aluno;
import service.AlunoService;

public class Main {

    public static void main(String[] args) {

        AlunoService service = new AlunoService();

        service.matricular(new Aluno("Sofia",20));

        service.listarTodos().forEach(System.out::println);
    }
}

/*
Create escola;
USE escola;
CREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INT NOT NULL
);
*/