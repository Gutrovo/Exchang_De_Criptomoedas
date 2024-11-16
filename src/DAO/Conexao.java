/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luana
 */
public class Conexao {
    public Connection getConnection() throws SQLException {
        System.out.println("Tentando conectar ao banco de dados...");
        Connection conexao = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/postgres", "postgres", "fei");
        System.out.println("Conexão bem-sucedida!");
        return conexao;
    }
}