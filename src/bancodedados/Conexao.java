package bancodedados;

import java.sql.*;

public class Conexao {

    public static Connection conexao() {
        java.sql.Connection conexao = null;
        String link = "jdbc:mysql://localhost:3306/restaurante";
        String usuario = "root";
        String senha = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection(link, usuario, senha);
            System.out.println("Conexão com o Banco de Dados criada com sucesso!");
            return conexao;
        } catch (Exception e) {
            System.out.println("Erro ao criar a conexão com o Banco de Dados!\nMensagem de erro: " + e.getMessage());
            return null;

        }
    }
}