/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ecommerce;

import com.mycompany.dao.ConnectionProdutos;
import com.mycompany.dao.Produto;
import java.util.List;

/**
 *
 * @author joao.aassuncao
 */
public class Ecommerce {

    public static void main(String[] args) {
        
        ConnectionProdutos buscarProdutos = new ConnectionProdutos();
        
        System.out.println("Buscando produtos no banco de dados...");
        
        List<Produto> produtosEncontrados = buscarProdutos.listarProdutos();
        
        System.out.println("--Resultado da Pesquisa--");

        if (produtosEncontrados != null && !produtosEncontrados.isEmpty()) {
            
            for (Produto produto : produtosEncontrados) {
                String informacoes = "ID: " + produto.getId() + " | Nome: " + produto.getNome() + " | Preco: R$" + produto.getPreco() + " | Estoque: " + produto.getQuantidadeEstoque();
                //coloquei a descricao não pq ficaria muito grande o print
                System.out.println(informacoes);
            }
        } else {
            System.out.println("Nenhum produto foi encontrado.");
        }
    }
}
