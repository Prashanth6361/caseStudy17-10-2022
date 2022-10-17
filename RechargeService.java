package com.gl.caseStudy4.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gl.caseStudy4.bean.Bill;
import com.gl.caseStudy4.bean.Offer;
@Repository
@Service
public class RechargeService implements BillDao, OfferDao {
	@Autowired
	private BillRepository repository1;
	@Autowired
	private OfferRepository repository2;

	@Override
	public void offerSave(Offer offer) {
		Offer off=new Offer();
		repository2.save(off);
	}

	@Override
	public Long generateId() {
		Long val=repository2.findMaxofferId();
		if(val==null)
			val=1L;
		else
			val=val+1;
		
		return val;
	}

	@Override
	public List<Offer> findAllOffers() {
		List<Offer> offerList=repository2.findAll();
		return offerList;
	}

	@Override
	public Offer findAOffer(Long id) {
		Offer off=repository2.getById(id);
		return off;
	}

	@Override
	public void billSave(Bill bill) {
		repository1.save(bill);
	}

	@Override
	public Bill findABill(Long id) {
		return repository1.getById(id);
	}

	@Override
	public List<Bill> showAllBill() {
		return repository1.findAll();
	}

	@Override
	public Long generateTransactionId() {
		Long val=repository1.findMaxtransactionId();
		if(val==null)
			val=100001L;
		else
			val=val+1;
		return val;
	}

}
