package com.ice.jyzq.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ice.jyzq.util.Cn2SpellUtil;
import com.ice.server.bean.Choise;
import com.ice.server.bean.ChoiseItem;
import com.ice.server.dao.ChoiseDao;
import com.ice.server.dao.ChoiseItemDao;

@Service
public class ChoiseService {

	public static final String CHOISE_SEPARATOR = "|";
	public static final String CHOISES_SPLIT_SEPARATOR = "\\|";
	public static final String VOTE_SEPARATOR = CHOISE_SEPARATOR;
	public static final String VOTE_SPLIT_SEPARATOR = CHOISES_SPLIT_SEPARATOR;

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChoiseDao choiseDao;
	@Autowired
	private ChoiseItemDao choiseItemDao;

	public Choise save(String title, String choiseType, List<String> choiseList, String choiseDesc, String userName) {
		saveChoiseItem(choiseType, choiseList);
		Choise choise = new Choise();
		choise.setUserName(userName);
		choise.setTitle(title);
		choise.setChoiseType(choiseType);
		StringBuilder choises = new StringBuilder();
		for (String choiseString : choiseList) {
			choises.append(CHOISE_SEPARATOR).append(choiseString);
		}
		choise.setChoises(choises.toString().substring(1));
		choise.setVotes(getInitVotes(choiseList.size()));
		choise.setChoiseDesc(choiseDesc);
		return choiseDao.save(choise);
	}

	private void saveChoiseItem(String choiseType, List<String> choiseList) {
		try {
			for (String choise : choiseList) {
				ChoiseItem temp = new ChoiseItem();
				temp.setChoiseType(choiseType);
				temp.setChoiseName(Cn2SpellUtil.converterToSpell(choise));
				temp.setChoiseCnName(choise);
				temp.setCreateNum(1L);
				temp.setVoteNum(0L);
				choiseItemDao.save(temp);
			}
		} catch (Exception e) {
			logger.warn("saveChoiseItem: ", e);
		}
	}

	private String getInitVotes(int choiseNum) {
		StringBuilder votes = new StringBuilder();
		for (int a = 0; a < choiseNum; a++) {
			votes.append(VOTE_SEPARATOR).append(0);
		}
		return votes.toString().substring(1);
	}

	public List<Choise> findLatestChoises(String choiceType, int pageNo, int pageSize) {
		Pageable pageable = new PageRequest(pageNo, pageSize, Direction.DESC, "id");
		Iterator<Choise> choiseIterator = choiseDao.findAll(pageable).iterator();
		List<Choise> rtnList = new ArrayList<Choise>();
		while (choiseIterator.hasNext()) {
			rtnList.add(choiseIterator.next());
		}
		return rtnList;
	}

	public Choise findById(long id) {
		return choiseDao.findOne(id);
	}

	public void vote(String id, String choise) {
		// TODO Auto-generated method stub
		voteChoise(id, choise);
		voteSummary(choise);
	}

	private void voteSummary(String choise) {
		// TODO Auto-generated method stub

	}

	private void voteChoise(String id, String choise) {
		Choise choisetemp = choiseDao.findOne(Long.parseLong(id));
		String[] choiseTemps = choisetemp.getChoises().split(ChoiseService.CHOISES_SPLIT_SEPARATOR);
		String[] voteTemps = choisetemp.getVotes().split(ChoiseService.VOTE_SPLIT_SEPARATOR);
		int index = 0;
		for (String choiseTemp : choiseTemps) {
			if (choise.equals(choiseTemp)) {
				voteTemps[index] = Integer.parseInt(voteTemps[index]) + 1 + "";
				break;
			}
			index++;
		}
		StringBuilder votes = new StringBuilder();
		for (int a = 0; a < voteTemps.length; a++) {
			votes.append(VOTE_SEPARATOR).append(voteTemps[a]);
		}
		choisetemp.setVotes(votes.toString().substring(1));
		choiseDao.updateVote(Long.parseLong(id), votes.toString().substring(1));
	}

}
