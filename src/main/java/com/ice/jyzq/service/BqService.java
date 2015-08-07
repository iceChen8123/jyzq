package com.ice.jyzq.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ice.jyzq.constant.BianQianStatus;
import com.ice.server.bean.BianQian;
import com.ice.server.dao.app.BianQianDao;

@Service
public class BqService {

	@Autowired
	private BianQianDao bianQianDao;

	public List<BianQian> getSome(final String userNameFromToken, String bqStatus, int pageNo) {
		Pageable pageable = new PageRequest(pageNo, 20, Direction.DESC, "id");
		Iterator<BianQian> biaoQianIterator = bianQianDao.findAll(new Specification<BianQian>() {

			public Predicate toPredicate(Root<BianQian> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> userNamePath = root.get("userName");
				query.where(cb.equal(userNamePath, userNameFromToken));
				return null;
			}
		}, pageable).iterator();
		List<BianQian> rtnList = new ArrayList<BianQian>();
		while (biaoQianIterator.hasNext()) {
			rtnList.add(biaoQianIterator.next());
		}
		return rtnList;
	}

	public void addBq(String userNameFromToken, String title, String content) {
		BianQian bianQian = new BianQian();
		bianQian.setUserName(userNameFromToken);
		bianQian.setTitle(title);
		bianQian.setContent(content);
		bianQian.setBqStatus(BianQianStatus.BIANQIAN_OPEN);
		bianQian.setCreateTime(new Date());
		bianQianDao.save(bianQian);
	}

	public void closeBq(String userNameFromToken, Long bqId) {
		bianQianDao.updateBQ(bqId, BianQianStatus.BIANQIAN_CLOSED);
	}

	public void reopenBq(String userNameFromToken, Long bqId) {
		bianQianDao.updateBQ(bqId, BianQianStatus.BIANQIAN_REOPEN);
	}

	public List<BianQian> find(String userNameFromToken, String content) {
		// TODO Auto-generated method stub
		return null;
	}

}
