package com.ifpb.apachecassandra.mapper;

import com.datastax.oss.driver.api.mapper.annotations.DaoFactory;
import com.datastax.oss.driver.api.mapper.annotations.Mapper;
import com.ifpb.apachecassandra.dao.ProdutoDao;

@Mapper
public interface AulaMapper {

    @DaoFactory
    ProdutoDao produtoDao();

}
