package org.naver.com.service;

import org.naver.com.dao.BoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BoardServiceImpl implements BoardSerivce {


	@Autowired
	private BoardDAO boardDAO;
	
	
	public int getaaa(){
			int abilityUnitRegCnt = 0;
			abilityUnitRegCnt = this.boardDAO.getaaa();
			return abilityUnitRegCnt;
	};
}
