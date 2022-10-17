package com.gl.caseStudy4.dao;

import java.util.List;

import com.gl.caseStudy4.bean.Offer;

public interface OfferDao {
	public void offerSave(Offer offer);
	public Long generateId();
	public List<Offer> findAllOffers();
	public Offer findAOffer(Long id);

}
