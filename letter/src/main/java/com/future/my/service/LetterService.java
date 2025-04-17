package com.future.my.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.my.dao.ILetterDAO;
import com.future.my.vo.LetterVO;

@Service
public class LetterService {
	
	@Autowired
	ILetterDAO dao;
	
	public LetterVO getLetter(LetterVO vo) {
		return dao.getLetter(vo);
	}
	
	//letterform
	public void sendLetter(LetterVO vo) throws Exception {
		int result = dao.sendLetter(vo);
		if(result == 0) {
			throw new Exception();
		}
	}

}
