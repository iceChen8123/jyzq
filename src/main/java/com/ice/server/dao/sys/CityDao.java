package com.ice.server.dao.sys;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ice.server.bean.sys.City;

@Repository
public interface CityDao extends PagingAndSortingRepository<City, Long>, JpaSpecificationExecutor<City> {

}
