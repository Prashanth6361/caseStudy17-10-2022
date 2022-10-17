package com.gl.caseStudy4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gl.caseStudy4.bean.Bill;
import com.gl.caseStudy4.bean.Offer;
import com.gl.caseStudy4.dao.BillDao;
import com.gl.caseStudy4.dao.OfferDao;
import com.gl.caseStudy4.dao.RechargeService;

@RestController
public class RechargeController {
	@Autowired
	private  BillDao billDao;
	@Autowired
	private  OfferDao offerDao;
	@Autowired
	private RechargeService service;
	
	@GetMapping("/welcome")
	public ModelAndView showWelcomePage() {
		ModelAndView mv=new ModelAndView("welcomePage");
		List<Offer> offerList=offerDao.findAllOffers();
		mv.addObject("offerList",offerList);
		return mv;
	}
	
	@GetMapping("/performRecharge")
	public ModelAndView showACourse(@PathVariable long id) {
		Offer of=offerDao.findAOffer(id);
		Bill bi=billDao.findABill(id);
		ModelAndView mv=new ModelAndView("billReportPage");
		mv.addObject("offer",of);
		mv.addObject("bill",bi);
		return mv;
	}
	
	@PostMapping("/performRecharge")
	public ModelAndView selectRadio(@ModelAttribute("offerId") Offer offer) {
		Long id=offerDao.generateId();
		offer.setId(id);
		offerDao.offerSave(offer);
		return new ModelAndView("redirect:/welcome");
	}
	
	@GetMapping("/performRech")
	public ModelAndView saveNewBill(@RequestParam("mobileNumber") String m,@RequestParam("offerId") long offerId) {
		long id = service.generateId();
		Bill bill = new Bill();
		Integer n=Integer.parseInt(m);
		bill.setMobileNumber(n);
		bill.setOfferId(offerId);
		bill.setTransactionId(id);
		service.billSave(bill);
		Offer offer = service.findAOffer(offerId);
		ModelAndView mv = new ModelAndView("transactionReport");
		mv.addObject("offer",offer);
		mv.addObject("bill",bill);
		return mv;
	}

}
