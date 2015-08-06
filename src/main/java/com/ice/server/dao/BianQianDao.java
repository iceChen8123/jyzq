package com.ice.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ice.server.bean.BianQian;

@Repository
public interface BianQianDao extends PagingAndSortingRepository<BianQian, Long>, JpaSpecificationExecutor<BianQian> {

	@Modifying
	@Transactional
	@Query("update BianQian b set b.bqStatus = :bqStatus where b.id = :bqId")
	public void updateBQ(@Param("bqId") Long bqId, @Param("bqStatus") Integer bqStatus);

}
