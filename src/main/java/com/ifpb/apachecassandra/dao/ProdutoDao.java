package com.ifpb.apachecassandra.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.ifpb.apachecassandra.modelo.Produto;

@Dao
public interface ProdutoDao {

    @Insert
    void salvar(Produto produto);

    @Select
    Produto buscarPorCodigo(int codigo);

}
