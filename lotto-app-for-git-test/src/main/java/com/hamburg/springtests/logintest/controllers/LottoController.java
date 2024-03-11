package com.hamburg.springtests.logintest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hamburg.springtests.logintest.kafkatest.service.LottoService;
import com.hamburg.springtests.logintest.models.LottoModel;

@Controller
@RequestMapping("/lotto")
public class LottoController {

	@Autowired
	private LottoService lottoService;

	@GetMapping("/")
	public String displayLottoForm(Model model) {
		model.addAttribute("lottoModel", new LottoModel());
		return "lottoForm.html";
	}

	@PostMapping("/processLotto")
	public String processLogin(@Valid LottoModel lottoModel, BindingResult bindingResult, Model model) {

		lottoModel.setLottoZahlen(lottoService.getLottoZahlen());

		System.out.println("============================in LottoController in processLogin========================");
		model.addAttribute("lottoModel", lottoModel);
		return "lottoForm.html";
	}

}
