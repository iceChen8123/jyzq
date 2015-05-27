package com.ice.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.ChoiseItem;

@Repository
public interface ChoiseItemDao extends CrudRepository<ChoiseItem, Long> {

}
