package com.gl.caseStudy4.dao;

import java.util.List;

import com.gl.caseStudy4.bean.Bill;

public interface BillDao {
	public void billSave(Bill bill);
	public Bill findABill(Long id);
	public List<Bill> showAllBill();
	public Long generateTransactionId();

}
