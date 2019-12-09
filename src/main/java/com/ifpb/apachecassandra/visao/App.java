package com.ifpb.apachecassandra.visao;

import com.ifpb.apachecassandra.dao.ProdutoDao;
import com.ifpb.apachecassandra.modelo.Produto;

public class App {

    public static void main(String[] args) {

        ProdutoDao produtoDao = new ProdutoDao();

//        System.out.println(produtoDao
//            .salvar(new Produto(1,"Arroz Parbolizado",
//                    3.5f)));

        System.out.println(produtoDao.buscarPorCodigo(0));


    }

}
