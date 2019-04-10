package org.naver.com.service;

import org.naver.com.dao.HomeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class HomeServiceImpl implements HomeService {


	@Autowired
	private HomeDAO homeDAO;
	
	
	public int getaaa(){
			int abilityUnitRegCnt = 0;
			abilityUnitRegCnt = this.homeDAO.getaaa();
			return abilityUnitRegCnt;
	};
}
