package com.airwire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airwire.model.PrepaidCode;

public interface PrepaidCodeRepository extends JpaRepository<PrepaidCode,Long>{

	@Query("Select p from PrepaidCode p where p.days=?1 and p.status=?2")
	List<PrepaidCode> findByDays(Integer days,String status);

	PrepaidCode findByPrepaidCode(String prepaidCode);
	
	PrepaidCode findByWuserid(String wuserid);

}
