package dao;

import model.Aluno;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    public void salvar(Aluno aluno) {

        String sql ="INSERT INTO aluno(nome, idade) VALUES (?, ?)";

        try (
                Connection con = ConnectionFactory.getConnection();

                PreparedStatement stmt = con.prepareStatement(sql)
        ) {

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());

            stmt.executeUpdate();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }

    public List<Aluno> listarTodos() {

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM aluno";

        try (
                Connection con = ConnectionFactory.getConnection();

                PreparedStatement stmt = con.prepareStatement(sql);

                ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                alunos.add(new Aluno(rs.getInt("id"),rs.getString("nome"),rs.getInt("idade")));
            }

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

        return alunos;
    }

    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Aluno(rs.getInt("id"),rs.getString("nome"),rs.getInt("idade"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void atualizar(Aluno aluno) {
        String sql ="UPDATE aluno SET nome = ?, idade = ? WHERE id = ?";
        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setInt(3, aluno.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        try (
                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = con.prepareStatement(sql)
        ) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}