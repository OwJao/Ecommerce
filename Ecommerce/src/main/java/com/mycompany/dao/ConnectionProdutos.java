/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joão antônio
 */
public class ConnectionProdutos {
    
    public List<Produto> listarProdutos() {
        
        String sql = "select * from produtos";
        
        List<Produto> produtos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement comandos=  null;
        ResultSet resultados = null;
        
        try {
            ConnectionMySQL mysql = new ConnectionMySQL();
            conexao = mysql.obterConexao();
            
            comandos = conexao.prepareStatement(sql);
            resultados = comandos.executeQuery();

            while (resultados.next()) {
                Produto produto = new Produto();

                produto.setId(resultados.getInt("id"));
                produto.setNome(resultados.getString("nome"));
                produto.setDescricao(resultados.getString("descricao"));
                produto.setPreco(resultados.getBigDecimal("preco"));
                produto.setQuantidadeEstoque(resultados.getInt("quantidade_estoque"));
                produto.setDataCadastro(resultados.getTimestamp("data_cadastro").toLocalDateTime());
                
                produtos.add(produto);
            }
        } catch (Exception erro) {
            System.out.println("Erro ao listar produtos!");
            erro.printStackTrace();
        } finally {
            try {
                if (resultados != null) resultados.close();
                if (comandos != null) comandos.close();
                if (conexao != null) new ConnectionMySQL().fecharConexao(conexao);
                
                // esse tanto de if é pra evitar ponteiro nulo. se eu estiver errado aceito um feedback massa.
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
        
        return produtos;
    }
}
