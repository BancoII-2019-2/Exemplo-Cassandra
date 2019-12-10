package com.ifpb.apachecassandra.dao;

import com.datastax.oss.driver.api.mapper.annotations.Dao;
import com.datastax.oss.driver.api.mapper.annotations.Delete;
import com.datastax.oss.driver.api.mapper.annotations.Insert;
import com.datastax.oss.driver.api.mapper.annotations.Select;
import com.ifpb.apachecassandra.modelo.Produto;

@Dao
public interface ProdutoDao {

    @Insert(ifNotExists = true)
    boolean salvar(Produto produto);

    @Select
    Produto buscarPorCodigo(int codigo);

    @Delete
    void deletar(Produto produto);

    @Delete(ifExists = true, entityClass = Produto.class)
    boolean deletarPorCodigo(int codigo);

}
