//package com.ice.jyzq.controller.util;
//
//import java.lang.reflect.InvocationTargetException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.beanutils.BeanUtils;
//import org.apache.commons.lang.StringUtils;
//
//import com.ice.jyzq.controller.vo.ChoiseVo;
//import com.ice.jyzq.service.ChoiseService;
//import com.ice.server.bean.Choise;
//
//public class ChoiseConvertUtil {
//
//	public static List<ChoiseVo> convertToChoiseVos(List<Choise> choises) {
//		List<ChoiseVo> rtnList = new ArrayList<ChoiseVo>();
//		for (Choise choise : choises) {
//			ChoiseVo choiseVo = convertToChoiseVo(choise);
//			rtnList.add(choiseVo);
//		}
//		return rtnList;
//	}
//
//	public static ChoiseVo convertToChoiseVo(Choise choise) {
//		ChoiseVo choiseVo = new ChoiseVo();
//		try {
//			BeanUtils.copyProperties(choiseVo, choise);
//		} catch (IllegalAccessException e) {
//			e.printStackTrace();
//		} catch (InvocationTargetException e) {
//			e.printStackTrace();
//		}
//		String[] choiseTemps = choise.getChoises().split(ChoiseService.CHOISES_SPLIT_SEPARATOR);
//		String[] voteTemps = choise.getVotes().split(ChoiseService.VOTE_SPLIT_SEPARATOR);
//		int index = 0;
//		for (String choiseTemp : choiseTemps) {
//			if (StringUtils.isNotBlank(choiseTemp)) {
//				choiseVo.addChoiseAndVote(choiseTemp, voteTemps[index]);
//			}
//			index++;
//		}
//		return choiseVo;
//	}
//
//}
