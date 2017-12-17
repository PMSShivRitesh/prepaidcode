package com.airwire.service;

import java.util.Date;
import java.util.List;

import com.airwire.dto.PrepaidCodeDeatail;
import com.airwire.dto.UsedPlanInfoDTO;
import com.airwire.model.PrepaidCode;
import com.airwire.model.UsedPlanInfo;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
public interface PrepaidCodeService {

	boolean savePrepaidCode(PrepaidCode prepaidCode);
	UsedPlanInfo saveRecord(UsedPlanInfo usedPlanInfo,Long orgId);
	/*PrepaidCodeDeatail getPrepaidCode(String days, String userName);*/
	UsedPlanInfo getUsedPlanInfoByCode(String code,String userName,Long orgId);
	UsedPlanInfoDTO getUsedPlanDTOByPrepaidCode(String code,String userName,Long orgId);
	List<UsedPlanInfoDTO> getBulkPrepaidCode(String days, int count,String userName,Long orgId);
	List<UsedPlanInfoDTO> getReportByDate(Date fromDate, Date toDate);
	PrepaidCodeDeatail getPrepaidCode(String days, String userName, Long orgId);
}
