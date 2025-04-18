package com.future.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model; 

@Controller
public class HomeController {
	
	@Value("${vapid.publickey}")
	private String publicKey;
	
	
	//인덱스 페이지로 가는거(index.html)
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("vapidPublicKey", publicKey);
		return "index";
	}
	
	//admin.html
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
