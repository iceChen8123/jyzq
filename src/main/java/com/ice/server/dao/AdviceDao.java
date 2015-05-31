package com.ice.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.Advice;

@Repository
public interface AdviceDao extends PagingAndSortingRepository<Advice, Long>, JpaSpecificationExecutor<Advice> {

}
