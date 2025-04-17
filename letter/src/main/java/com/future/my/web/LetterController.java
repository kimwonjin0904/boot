package com.future.my.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.future.my.service.LetterService;
import com.future.my.vo.LetterVO;

@Controller
public class LetterController {
	@Autowired
	LetterService service;
	
	@GetMapping("/")
	public String index() {
		return "letter";
	}
	
	//letter.html letterform으로 화면 넘어가는 거
	@GetMapping("/letterForm")
	public String letterForm() {
		return "letterForm";
	}
	@PostMapping("/sendLetter")
	public String sendLetter(LetterVO vo) {
		System.out.println(vo);
		try {
			service.sendLetter(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

}
