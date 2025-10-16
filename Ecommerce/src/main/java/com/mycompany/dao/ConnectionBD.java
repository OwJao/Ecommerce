/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;

/**
 *
 * @author joao.aassuncao
 */
public interface ConnectionBD {

    Connection obterConexao() throws Exception;
    
    void fecharConexao(Connection conexao);
}
