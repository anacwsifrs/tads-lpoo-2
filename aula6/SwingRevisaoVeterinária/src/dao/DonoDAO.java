package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Dono;
import util.ConnectionFactory;

public class DonoDAO {

    public void salvar(Dono dono) {
        String sql = "INSERT INTO dono (nome, telefone) VALUES (?, ?)";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, dono.getNome());
            stmt.setString(2, dono.getTelefone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar dono: " + e.getMessage(), e);
        }
    }

    public List<Dono> listarTodos() {
        List<Dono> donos = new ArrayList<>();
        String sql = "SELECT * FROM dono";

        try (Connection con = ConnectionFactory.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Dono dono = new Dono(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("telefone")
                );
                donos.add(dono);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar donos: " + e.getMessage(), e);
        }

        return donos;
    }
}