package com.ice.server.dao.app;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.app.AppUserToken;

@Repository
public interface AppUserTokenDao extends CrudRepository<AppUserToken, Long> {

	@Query("select au from AppUserToken au where au.token = :token")
	List<AppUserToken> findByToken(@Param("token") String token);
}
