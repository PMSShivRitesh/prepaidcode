package com.airwire.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.airwire.model.PrepaidCode;
import com.airwire.model.UsedPlanInfo;

public interface UsedPlanInfoRepository extends JpaRepository<UsedPlanInfo,Long>{
	UsedPlanInfo getUsedPlanInfoByPrepaidCode(PrepaidCode prepaidCode);

	@Query("Select u from UsedPlanInfo u where u.date>=?1 and u.date<=?2")
	List<UsedPlanInfo> getReportByDate(Date fromDate, Date toDate);
}
