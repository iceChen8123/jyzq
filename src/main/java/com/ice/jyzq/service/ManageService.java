package com.ice.jyzq.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ice.server.bean.sys.ChoiseSubject;
import com.ice.server.bean.sys.ChoiseType;
import com.ice.server.dao.sys.ChoiseSubjectDao;
import com.ice.server.dao.sys.ChoiseTypeDao;

@Service
public class ManageService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseTypeDao choiseTypeDao;

	@Autowired
	private ChoiseSubjectDao choiseSubjectDao;

	public List<ChoiseType> getChoiseTypes() {
		return Lists.newArrayList(choiseTypeDao.findAll().iterator());
	}

	public List<ChoiseSubject> getSubjects() {
		return Lists.newArrayList(choiseSubjectDao.findAll().iterator());
	}

	public void saveChoiseType(String choiseCode, String choiseName) {
		ChoiseType entity = new ChoiseType();
		entity.setChoiseCode(choiseCode);
		entity.setChoiseName(choiseName);
		entity.setCreateTime(new Date());
		entity.setValid(1);
		choiseTypeDao.save(entity);
	}

	public void saveSubject(String choiseCode, String subjectName, Long expiredTime, String voteArea) {
		ChoiseSubject choiseSubject = new ChoiseSubject();
		choiseSubject.setChoiseCode(choiseCode);
		choiseSubject.setSubjectName(subjectName);
		choiseSubject.setExpiredTime(expiredTime);
		choiseSubject.setVoteArea(voteArea);
		choiseSubject.setCreateTime(new Date());
		choiseSubject.setValid(1);
		choiseSubjectDao.save(choiseSubject);
	}

	public void deleteChoiseType(Long choiseTypeId) {
		choiseTypeDao.invalid(choiseTypeId);
	}

	public void deleteSubject(Long choiseSubjectId) {
		choiseSubjectDao.invalid(choiseSubjectId);
	}

	public void renewChoiseType(Long choiseTypeId) {
		choiseTypeDao.valid(choiseTypeId);
	}

	public void renewSubject(Long choiseSubjectId) {
		choiseSubjectDao.valid(choiseSubjectId);
	}
}
