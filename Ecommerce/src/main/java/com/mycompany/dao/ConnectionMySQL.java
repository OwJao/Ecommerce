/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;

/**
 *
 * @author joao.aassuncao
 */
public class ConnectionMySQL implements ConnectionBD{
    
    private static final String URL = "jdbc:msql://localhost:3307/ecommerce";
    private static final String USUARIO = "root";
    private static final String SENHAR = "catolica";
     

    @Override
    public Connection obterConexao() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void fecharConexao(Connection conexao) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
