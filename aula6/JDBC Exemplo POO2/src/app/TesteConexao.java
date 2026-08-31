package app;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

	public void test(){
        String url ="jdbc:mysql://localhost:3306/teste";

        String usuario = "root";

        String senha = "root";

        try {

            Connection conexao =DriverManager.getConnection(url,usuario,senha);

            System.out.println("Conectado com sucesso!");

            conexao.close();

        } catch (Exception e) {

            System.out.println("Erro ao conectar");

            e.printStackTrace();
        }
    }
}