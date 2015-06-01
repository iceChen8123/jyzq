package com.ice.server.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.ChoiseItem;

@Repository
public interface ChoiseItemDao extends CrudRepository<ChoiseItem, Long> {

	@Modifying
	@Transactional
	@Query("update ChoiseItem ci set ci.voteNum = ci.voteNum +1  where subjectId = :subjectId and choise = :choise")
	void incrVoteNum(@Param("subjectId") Long subjectId, @Param("choise") String choise);

}
