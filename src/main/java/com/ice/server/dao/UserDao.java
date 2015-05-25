package com.ice.server.dao;

import org.springframework.data.repository.CrudRepository;

import com.ice.server.bean.User;

public interface UserDao extends CrudRepository<User, Long> {

}
