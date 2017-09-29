package com.airwire.service;

import java.util.Date;
import java.util.List;

import com.airwire.dto.PrepaidCodeDeatail;
import com.airwire.dto.UsedPlanInfoDTO;
import com.airwire.model.PrepaidCode;
import com.airwire.model.UsedPlanInfo;

public interface PrepaidCodeService {

	boolean savePrepaidCode(PrepaidCode prepaidCode);
	UsedPlanInfo saveRecord(UsedPlanInfo usedPlanInfo);
	PrepaidCodeDeatail getPrepaidCode(String days);
	UsedPlanInfo getUsedPlanInfoByCode(String code);
	UsedPlanInfoDTO getUsedPlanDTOByPrepaidCode(String code);
	List<UsedPlanInfoDTO> getBulkPrepaidCode(String days, int count);
	List<UsedPlanInfoDTO> getReportByDate(Date fromDate, Date toDate);
}
