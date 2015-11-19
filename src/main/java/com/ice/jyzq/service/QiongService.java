package com.ice.jyzq.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ice.jyzq.constant.QiongConst;
import com.ice.server.bean.QiongUpload;
import com.ice.server.dao.QiongUploadDao;

@Service
public class QiongService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private QiongUploadDao qiongUploadDao;

	public QiongUpload findById(long id) {
		return qiongUploadDao.findOne(id);
	}

	public void save(QiongUpload qiongUpload) {
		qiongUploadDao.save(qiongUpload);
	}

	public List<QiongUpload> findLatestQiongRen(int pageNo) {
		Pageable pageable = new PageRequest(pageNo, 20, Direction.DESC, "id");
		Iterator<QiongUpload> qiongUploadIterator = qiongUploadDao.findAll(new Specification<QiongUpload>() {

			public Predicate toPredicate(Root<QiongUpload> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> status = root.get("status");
				query.where(cb.equal(status, QiongConst.QIONG_CHECKED)); // 这里可以设置任意条查询条件
				return null;
			}
		}, pageable).iterator();
		List<QiongUpload> rtnList = new ArrayList<QiongUpload>();
		while (qiongUploadIterator.hasNext()) {
			rtnList.add(qiongUploadIterator.next());
		}
		return rtnList;
	}
}
