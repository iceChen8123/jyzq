package com.ice.server.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {

	@Query("select u from User u where u.userName = :username")
	public User findByUserName(@Param("username") String userName);

//	public void updateUserLoginInfo(@Param("id") Long id);

}
