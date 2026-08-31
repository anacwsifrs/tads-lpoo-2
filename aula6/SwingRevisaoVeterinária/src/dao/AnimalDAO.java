package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Dono;
import util.ConnectionFactory;

public class AnimalDAO {

    public void salvar(Animal animal) {
        String sql = "INSERT INTO animal (nome, especie, raca, dono_id) VALUES (?, ?, ?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, animal.getNome());
            stmt.setString(2, animal.getEspecie());
            stmt.setString(3, animal.getRaca());
            stmt.setInt(4, animal.getDono().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar animal: " + e.getMessage(), e);
        }
    }

    public List<Animal> listarTodos() {
        List<Animal> animais = new ArrayList<>();
        String sql = "SELECT a.id, a.nome, a.especie, a.raca, d.id AS dono_id, d.nome AS dono_nome, d.telefone " +
                     "FROM animal a JOIN dono d ON a.dono_id = d.id";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dono dono = new Dono(
                    rs.getInt("dono_id"),
                    rs.getString("dono_nome"),
                    rs.getString("telefone")
                );

                Animal animal = new Animal(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("especie"),
                    rs.getString("raca"),
                    dono
                );

                animais.add(animal);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar animais: " + e.getMessage(), e);
        }

        return animais;
    }
}