package br.edu.ifpb.dac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //private static final String url = "jdbc:postgresql://localhost:5433/dac-jsf-docker";
    private static final String url = "jdbc:postgresql://host-banco:5432/dac-jsf-docker";
    private static final String password = "dac";
    private static final String user = "postgres";

    public static Connection getConnection() throws SQLException, ClassNotFoundException{

        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);

    }
}
