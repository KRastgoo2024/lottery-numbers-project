package com.hamburg.springtests.logintest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hamburg.springtests.logintest.kafkatest.service.LottoService;
import com.hamburg.springtests.logintest.kafkatest.service.LottoServiceForHTML;

@RestController
@RequestMapping("/lottozahlen")
public class LottoRestController {
	
	@Autowired
	private LottoServiceForHTML lottoService;
	
	@GetMapping("/")
	@ResponseBody
	public String getLottozahlen() {
		return lottoService.getLottoZahlenHtml();
	}

}
