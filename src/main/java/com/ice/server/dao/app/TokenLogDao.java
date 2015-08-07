package com.ice.server.dao.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.app.TokenLog;

@Repository
public interface TokenLogDao extends CrudRepository<TokenLog, Long> {

}
