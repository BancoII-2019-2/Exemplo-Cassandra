package com.ifpb.apachecassandra.visao;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.ifpb.apachecassandra.dao.ProdutoDao;
import com.ifpb.apachecassandra.dao.ProdutoDaoStatements;
import com.ifpb.apachecassandra.mapper.AulaMapper;
import com.ifpb.apachecassandra.mapper.AulaMapperBuilder;
import com.ifpb.apachecassandra.modelo.Produto;

public class App {

    public static void main(String[] args) {

//        ProdutoDaoStatements produtoDao = new ProdutoDaoStatements();
//        System.out.println(produtoDao
//            .salvar(new Produto(1,"Arroz Parbolizado",
//                    3.5f)));
//        System.out.println(produtoDao.buscarPorCodigo(0));

        try(CqlSession session = new CqlSessionBuilder()
                .withKeyspace("aula").build()){

            AulaMapper mapper = new AulaMapperBuilder(session)
                    .build();
            ProdutoDao dao = mapper.produtoDao();

//            System.out.println(
//                dao
//                .salvar(new Produto(5,"Feijão",6)));

//            System.out.println(dao.buscarPorCodigo(5));

            System.out.println(dao.deletarPorCodigo(5));

        }


    }

}
