package com.ifpb.apachecassandra.dao;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.ifpb.apachecassandra.modelo.Produto;

import java.util.List;

public class ProdutoDao {

    public boolean salvar(Produto produto){
        try(CqlSession session = new CqlSessionBuilder()
                .withKeyspace("aula").build()){

            PreparedStatement preparedStatement = session
                    .prepare("INSERT INTO produto " +
                        "(codigo,descricao,preco) VALUES (?,?,?)");

            BoundStatement boundStatement = preparedStatement
                    .bind(produto.getCodigo(), produto.getDescricao(),
                            produto.getPreco());

            ResultSet resultSet = session.execute(boundStatement);
            return resultSet.wasApplied();
        }
    }

    public Produto buscarPorCodigo(int codigo){
        try(CqlSession session = new CqlSessionBuilder()
                .withKeyspace("aula").build()){

            PreparedStatement preparedStatement = session.prepare(
                    "SELECT * FROM produto WHERE codigo=?");

            ResultSet resultSet = session.execute(
                    preparedStatement.bind(codigo));

            List<Row> rowList = resultSet.all();
            if(rowList.isEmpty()){
                return null;
            }else{
                Row linha = rowList.get(0);
                String descricao = linha.getString("descricao");
                float preco = linha.getFloat("preco");
                return new Produto(codigo, descricao, preco);
            }

        }
    }

}
