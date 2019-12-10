package com.ifpb.apachecassandra.visao;

import com.ifpb.apachecassandra.dao.ProdutoDaoStatements;

public class App {

    public static void main(String[] args) {

        ProdutoDaoStatements produtoDao = new ProdutoDaoStatements();

//        System.out.println(produtoDao
//            .salvar(new Produto(1,"Arroz Parbolizado",
//                    3.5f)));

        System.out.println(produtoDao.buscarPorCodigo(0));


    }

}
