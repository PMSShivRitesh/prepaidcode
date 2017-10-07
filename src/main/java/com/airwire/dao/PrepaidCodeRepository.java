package com.airwire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airwire.model.HotelInfo;
import com.airwire.model.PrepaidCode;

public interface PrepaidCodeRepository extends JpaRepository<PrepaidCode,Long>{

	@Query("Select p from PrepaidCode p where p.days=?1 and p.status=?2 and p.hotelInfo=?3")
	List<PrepaidCode> findByDays(Integer days,String status,HotelInfo hotelInfo);

	@Query("Select p from PrepaidCode p where p.prepaidCode=?1 and p.hotelInfo=?2")
	PrepaidCode findByPrepaidCode(String prepaidCode,HotelInfo hotelInfo);
	
	@Query("Select p from PrepaidCode p where p.wuserid=?1 and p.hotelInfo=?2")
	PrepaidCode findByWuserid(String wuserid,HotelInfo hotelInfo);

}
