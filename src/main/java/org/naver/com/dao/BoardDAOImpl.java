package org.naver.com.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements HomeDAO {
	
/*	@Autowired
	private SqlSessionTemplate SqlSession;
	*/

	@Override
	public int getaaa() {
		
		System.out.println("aaa");
		// int getCnt = SqlSession.selectOne("org.naver.com.HomeDAO.selectData");
		return 0;
		
	}
}
