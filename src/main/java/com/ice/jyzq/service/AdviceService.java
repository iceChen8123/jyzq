package com.ice.jyzq.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ice.jyzq.common.UserUtil;
import com.ice.server.bean.Advice;
import com.ice.server.dao.AdviceDao;

@Service
public class AdviceService {

	@Autowired
	private AdviceDao adviceDao;

	@Autowired
	private UserUtil userUtil;

	public void save(String title, String advice) {
		Advice adv = new Advice();
		adv.setUserName(userUtil.getCurrentUserName());
		adv.setTitle(title);
		adv.setAdvice(advice);
		adv.setCreateTime(new Date());
		adviceDao.save(adv);
	}

	public List<Advice> findLatestAdvices(int pageNo, int pageSize) {
		Pageable pageable = new PageRequest(pageNo, pageSize, Direction.DESC, "id");
		Iterator<Advice> choiseIterator = adviceDao.findAll(pageable).iterator();
		List<Advice> rtnList = new ArrayList<Advice>();
		while (choiseIterator.hasNext()) {
			rtnList.add(choiseIterator.next());
		}
		return rtnList;
	}

}
