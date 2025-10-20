/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joao.aassuncao
 */
public class ConnectionMySQL implements ConnectionBD{
    
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";

    @Override
    public Connection obterConexao() throws Exception {
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException erro) {
            System.out.println("Erro ao obter conexão com o banco de dados!");
            erro.printStackTrace();
            return null;
        }
    }

    @Override
    public void fecharConexao(Connection conexao) {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException erro) {
                System.out.println("Erro ao fechar conexão!");
                erro.printStackTrace();
            }
        }
    }
    
}
