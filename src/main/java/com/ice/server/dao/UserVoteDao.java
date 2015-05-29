package com.ice.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.UserVote;

@Repository
public interface UserVoteDao extends PagingAndSortingRepository<UserVote, Long>, JpaSpecificationExecutor<UserVote> {

	@Query("select uv from UserVote uv where userName = :userName and choiseId = :choiseId")
	UserVote findByChoiseIdAndChoise(@Param("userName") String currentUserName, @Param("choiseId") Long choiseId);

}
