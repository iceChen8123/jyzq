package com.ice.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ice.server.bean.QiongUpload;

@Repository
public interface QiongUploadDao extends PagingAndSortingRepository<QiongUpload, Long>, JpaSpecificationExecutor<QiongUpload> {

	@Modifying
	@Transactional
	@Query("update Choise c set c.votes = :votes where c.id = :id")
	public int updateVote(@Param("id") Long id, @Param("votes") String votes); // TODO

}
