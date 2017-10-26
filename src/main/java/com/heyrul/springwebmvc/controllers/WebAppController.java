/*
 * @Author Rully Andhika a.k.a jarul
 * www.heyrul.com-2017
 */
package com.heyrul.springwebmvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.heyrul.springwebmvc.models.Karyawan;
import com.heyrul.springwebmvc.services.KaryawanService;

@Controller
public class WebAppController {
	
	@Autowired
	private KaryawanService karyawanService;
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/datalist", method=RequestMethod.GET)
	public ModelAndView getAllKaryawanData() {
		ModelAndView mav = new ModelAndView("showdata");
		
		List<Karyawan> data = karyawanService.getAllDataKaryawan();
		mav.addObject("karyawanData", data);
		return mav;
	}
	
	@RequestMapping(value = "/insertkaryawandata", method=RequestMethod.POST)
	public String insertKaryawan(@ModelAttribute("karyawan") Karyawan karyawan) {
		karyawanService.insertKaryawan(karyawan);
		return "redirect:datalist";
	}
	
	@RequestMapping(value = "/updatekaryawandata", method=RequestMethod.POST)
	public String updateKaryawan(@ModelAttribute("karyawan") Karyawan karyawan) {
		karyawanService.updateKaryawan(karyawan);
		return "redirect:datalist";
	}
	
	@RequestMapping(value = "/deletekaryawandata", method=RequestMethod.GET)
	public String deleteKaryawan(@RequestParam(value = "nip", required = false) String nip) {
		karyawanService.deleteKaryawan(nip);
		return "redirect:datalist";
	}

}
