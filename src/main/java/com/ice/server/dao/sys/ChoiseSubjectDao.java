package com.ice.server.dao.sys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ice.server.bean.sys.ChoiseSubject;

@Repository
public interface ChoiseSubjectDao extends PagingAndSortingRepository<ChoiseSubject, Long>,
		JpaSpecificationExecutor<ChoiseSubject> {

	@Modifying
	@Transactional
	@Query("update ChoiseSubject cs set cs.valid = 0 where id = :choiseSubjectId")
	void invalid(@Param("choiseSubjectId") Long choiseSubjectId);

	@Modifying
	@Transactional
	@Query("update ChoiseSubject cs set cs.valid = 1 where id = :choiseSubjectId")
	void valid(@Param("choiseSubjectId") Long choiseSubjectId);

	@Query("select cs from ChoiseSubject cs where choiseCode = :choiseCode and valid = 1")
	List<ChoiseSubject> findByChoiseCode(@Param("choiseCode") String choiseCode);

}
