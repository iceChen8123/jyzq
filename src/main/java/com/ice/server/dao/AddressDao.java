package com.ice.server.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.Address;

@Repository
public interface AddressDao extends PagingAndSortingRepository<Address, Long>, JpaSpecificationExecutor<Address> {

}
