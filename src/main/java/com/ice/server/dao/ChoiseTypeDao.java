package com.ice.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.ChoiseType;

@Repository
public interface ChoiseTypeDao extends CrudRepository<ChoiseType, Long> {

}
