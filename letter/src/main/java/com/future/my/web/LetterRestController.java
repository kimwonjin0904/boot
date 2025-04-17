package com.future.my.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.future.my.service.LetterService;
import com.future.my.vo.LetterVO;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*") //모두 허용 aws
public class LetterRestController {
	@Autowired
	LetterService service;
	
	@PostMapping("/getCard")		//화면에서 카드받기시 
	public LetterVO getLetter(LetterVO vo) {
		System.out.println(vo);
		LetterVO msg = service.getLetter(vo);
		return msg;
		
	}

}
