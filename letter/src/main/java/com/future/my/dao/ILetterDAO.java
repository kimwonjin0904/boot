package com.future.my.dao;

import org.apache.ibatis.annotations.Mapper;

import com.future.my.vo.LetterVO;

@Mapper
public interface ILetterDAO {
	
	public LetterVO getLetter(LetterVO vo);
	//편지 보내기
	public int sendLetter(LetterVO vo);
	
}
	