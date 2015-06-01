package com.ice.server.dao.sys;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ice.server.bean.sys.ChoiseType;

@Repository
public interface ChoiseTypeDao extends CrudRepository<ChoiseType, Long> {

	@Modifying
	@Transactional
	@Query("update ChoiseType ct set ct.valid = 0 where id = :choiseTypeId")
	void invalid(@Param("choiseTypeId") Long choiseTypeId);

	@Modifying
	@Transactional
	@Query("update ChoiseType ct set ct.valid = 1 where id = :choiseTypeId")
	void valid(@Param("choiseTypeId")Long choiseTypeId);

}
