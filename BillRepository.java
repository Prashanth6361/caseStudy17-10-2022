package com.gl.caseStudy4.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.caseStudy4.bean.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	@Query("select max(transactionId) from Bill")
	public Long findMaxtransactionId();

}
