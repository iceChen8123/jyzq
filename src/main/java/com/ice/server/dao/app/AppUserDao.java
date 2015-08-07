package com.ice.server.dao.app;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ice.server.bean.app.AppUser;

@Repository
public interface AppUserDao extends CrudRepository<AppUser, Long> {

	@Modifying
	@Transactional
	@Query("update AppUser au set au.lastLogin = now() where au.userName = :userName")
	void updateLastLogin(@Param("userName") String userName);

}
