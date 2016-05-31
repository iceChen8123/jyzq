//package com.ice.jyzq.service;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.List;
//
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Path;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//
//import com.ice.jyzq.common.UserUtil;
//import com.ice.jyzq.util.Cn2SpellUtil;
//import com.ice.server.bean.Address;
//import com.ice.server.bean.Choise;
//import com.ice.server.bean.ChoiseItem;
//import com.ice.server.bean.UserVote;
//import com.ice.server.dao.AddressDao;
//import com.ice.server.dao.ChoiseDao;
//import com.ice.server.dao.ChoiseItemDao;
//import com.ice.server.dao.UserVoteDao;
//
//@Service
//public class ChoiseService {
//
//	public static final String CHOISE_SEPARATOR = "|";
//	public static final String CHOISES_SPLIT_SEPARATOR = "\\|";
//	public static final String VOTE_SEPARATOR = CHOISE_SEPARATOR;
//	public static final String VOTE_SPLIT_SEPARATOR = CHOISES_SPLIT_SEPARATOR;
//
//	Logger logger = LoggerFactory.getLogger(getClass());
//
//	@Autowired
//	private UserUtil userUtil;
//	@Autowired
//	private UserVoteDao userVoteDao;
//	@Autowired
//	private ChoiseDao choiseDao;
//	@Autowired
//	private ChoiseItemDao choiseItemDao;
//	@Autowired
//	private AddressDao addressDao;
//
//	public Choise save(String title, String choiseCode, Long subjectId, List<String> choiseList, String choiseDesc,
//			String userName, Integer cityId, String address) {
//		saveChoiseItem(choiseCode, subjectId, choiseList);
//		Choise choise = new Choise();
//		choise.setUserName(userName);
//		choise.setTitle(title);
//		choise.setChoiseCode(choiseCode);
//		choise.setSubjectId(subjectId);
//		choise.setCityId(cityId);
//		if (StringUtils.isNotBlank(address)) {
//			boolean isexist = false;
//			List<Address> temps = addressDao.findByAddressPy(Cn2SpellUtil.converterToSpell(address));
//			if (temps != null && !temps.isEmpty()) {
//				for (Address tempAddress : temps) {
//					if (address.equals(tempAddress.getAddress())) {
//						isexist = true;
//						choise.setAddressId(tempAddress.getId());
//					}
//				}
//				if (!isexist) {
//					Address entity = createAddress(cityId, address);
//					Long addressId = addressDao.save(entity).getId();
//					choise.setAddressId(addressId);
//				}
//			}
//		}
//		StringBuilder choises = new StringBuilder();
//		for (String choiseString : choiseList) {
//			choises.append(CHOISE_SEPARATOR).append(choiseString);
//		}
//		choise.setChoises(choises.toString().substring(1));
//		choise.setVotes(getInitVotes(choiseList.size()));
//		choise.setChoiseDesc(choiseDesc);
//		choise.setCreateTime(new Date());
//		return choiseDao.save(choise);
//	}
//
//	private Address createAddress(Integer cityId, String address) {
//		Address entity = new Address();
//		entity.setCityId(cityId);
//		entity.setAddressPy(Cn2SpellUtil.converterToSpell(address));
//		entity.setAddress(address);
//		entity.setCreateTime(new Date());
//		return entity;
//	}
//
//	private void saveChoiseItem(String choiseCode, Long subjectId, List<String> choiseList) {
//		try {
//			for (String choise : choiseList) {
//				ChoiseItem temp = new ChoiseItem();
//				temp.setChoiseCode(choiseCode);
//				temp.setSubjectId(subjectId);
//				temp.setChoiseName(Cn2SpellUtil.converterToSpell(choise));
//				temp.setChoiseCnName(choise);
//				temp.setCreateNum(1L);
//				temp.setVoteNum(0L);
//				choiseItemDao.save(temp);
//			}
//		} catch (Exception e) {
//			logger.warn("saveChoiseItem: ", e);
//		}
//	}
//
//	private String getInitVotes(int choiseNum) {
//		StringBuilder votes = new StringBuilder();
//		for (int a = 0; a < choiseNum; a++) {
//			votes.append(VOTE_SEPARATOR).append(0);
//		}
//		return votes.toString().substring(1);
//	}
//
//	public List<Choise> findLatestChoises(final String choiseType, int pageNo, int pageSize) {
//		Pageable pageable = new PageRequest(pageNo, pageSize, Direction.DESC, "id");
//		Iterator<Choise> choiseIterator = choiseDao.findAll(new Specification<Choise>() {
//
//			public Predicate toPredicate(Root<Choise> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				Path<String> choiseTypePath = root.get("choiseCode");
//				if (StringUtils.isNotBlank(choiseType)) {
//					query.where(cb.equal(choiseTypePath, choiseType)); // 这里可以设置任意条查询条件
//				}
//				return null;
//			}
//		}, pageable).iterator();
//		List<Choise> rtnList = new ArrayList<Choise>();
//		while (choiseIterator.hasNext()) {
//			rtnList.add(choiseIterator.next());
//		}
//		return rtnList;
//	}
//
//	public Choise findById(long id) {
//		return choiseDao.findOne(id);
//	}
//
//	public void vote(Long subjectId, String choiseId, String choise) {
//		voteChoise(choiseId, choise);
//		recordVote(choiseId, choise);
//		voteSummary(subjectId, choise);
//	}
//
//	private void recordVote(String choiseId, String choise) {
//		UserVote entity = new UserVote();
//		entity.setUserName(userUtil.getCurrentUserName());
//		entity.setChoiseId(Long.parseLong(choiseId));
//		entity.setVoteChoise(choise);
//		userVoteDao.save(entity);
//	}
//
//	private void voteSummary(Long subjectId, String choise) {
//		choiseItemDao.incrVoteNum(subjectId, choise);
//	}
//
//	private void voteChoise(String choiseId, String choise) {
//		Choise choisetemp = choiseDao.findOne(Long.parseLong(choiseId));
//		String[] choiseTemps = choisetemp.getChoises().split(ChoiseService.CHOISES_SPLIT_SEPARATOR);
//		String[] voteTemps = choisetemp.getVotes().split(ChoiseService.VOTE_SPLIT_SEPARATOR);
//		int index = 0;
//		for (String choiseTemp : choiseTemps) {
//			if (choise.equals(choiseTemp)) {
//				voteTemps[index] = Integer.parseInt(voteTemps[index]) + 1 + "";
//				break;
//			}
//			index++;
//		}
//		StringBuilder votes = new StringBuilder();
//		for (int a = 0; a < voteTemps.length; a++) {
//			votes.append(VOTE_SEPARATOR).append(voteTemps[a]);
//		}
//		choisetemp.setVotes(votes.toString().substring(1));
//		choiseDao.updateVote(Long.parseLong(choiseId), votes.toString().substring(1));
//	}
//
//	public boolean checkHasVote(String choiseId, String choise) {
//		UserVote userVote = userVoteDao
//				.findByChoiseIdAndChoise(userUtil.getCurrentUserName(), Long.parseLong(choiseId));
//		return (userVote != null) && StringUtils.isNotBlank(userVote.getUserName());
//	}
//
//	public List<Choise> findMyChoises(final String choiseType, int pageNo, int pageSize) {
//		final String username = userUtil.getCurrentUserName();
//		Pageable pageable = new PageRequest(pageNo, pageSize, Direction.DESC, "id");
//		Iterator<Choise> choiseIterator = choiseDao.findAll(new Specification<Choise>() {
//
//			public Predicate toPredicate(Root<Choise> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				Predicate userPredicate = cb.equal(root.get("userName"), username);
//				Path<String> choiseTypePath = root.get("choiseCode");
//				if (StringUtils.isNotBlank(choiseType)) {
//					query.where(cb.and(userPredicate, cb.equal(choiseTypePath, choiseType))); // 这里可以设置任意条查询条件
//				} else {
//					query.where(userPredicate);
//				}
//				return query.getRestriction();
//			}
//		}, pageable).iterator();
//		List<Choise> rtnList = new ArrayList<Choise>();
//		while (choiseIterator.hasNext()) {
//			rtnList.add(choiseIterator.next());
//		}
//		return rtnList;
//	}
//
//	public Integer getlatestCityId() {
//		Choise choise = getlatestChoise(userUtil.getCurrentUserName());
//		if (choise == null) {
//			return 0;
//		}
//		return choise.getCityId();
//	}
//
//	public String getlatestaddress() {
//		Choise choise = getlatestChoise(userUtil.getCurrentUserName());
//		if (choise == null || choise.getAddressId() == null) {
//			return "";
//		}
//		String latestaddress = addressDao.findOne(choise.getAddressId()).getAddress();
//		return latestaddress;
//	}
//
//	private Choise getlatestChoise(String currentUserName) {
//		Pageable pageable = new PageRequest(0, 1, Direction.DESC, "id");
//		Iterator<Choise> choiseIterator = choiseDao.findAll(new Specification<Choise>() {
//			public Predicate toPredicate(Root<Choise> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//				Predicate userPredicate = cb.equal(root.get("userName"), userUtil.getCurrentUserName());
//				query.where(userPredicate);
//				return query.getRestriction();
//			}
//		}, pageable).iterator();
//		if (choiseIterator.hasNext()) {
//			return choiseIterator.next();
//		}
//		return null;
//	}
//
//}
