package com.heyrul.springwebmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.heyrul.springwebmvc.services.KaryawanService;

@Controller
public class WebAppController {
	
	@Autowired
	private KaryawanService karyawanService;
	
	public String index() {
		return "index";
	}

}
