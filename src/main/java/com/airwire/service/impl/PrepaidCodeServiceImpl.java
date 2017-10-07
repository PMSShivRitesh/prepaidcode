package com.airwire.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.airwire.dao.PrepaidCodeRepository;
import com.airwire.dao.UsedPlanInfoRepository;
import com.airwire.dao.UserRepository;
import com.airwire.dto.PrepaidCodeDeatail;
import com.airwire.dto.UsedPlanInfoDTO;
import com.airwire.model.PrepaidCode;
import com.airwire.model.UsedPlanInfo;
import com.airwire.model.User;
import com.airwire.service.PrepaidCodeService;

@Service("prepaidCodeService")
public class PrepaidCodeServiceImpl implements PrepaidCodeService {

	@Autowired
	PrepaidCodeRepository prepaidCodeRepository;

	@Autowired
	UsedPlanInfoRepository usedPlanInfoRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public boolean savePrepaidCode(PrepaidCode prepaidCode) {
		prepaidCode = prepaidCodeRepository.save(prepaidCode);
		if (prepaidCode != null && prepaidCode.getId() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public PrepaidCodeDeatail getPrepaidCode(String days,String userName) {
		User user = userRepository.findByUsername(userName);
		PrepaidCodeDeatail prepaidCodeDeatail = new PrepaidCodeDeatail();
		Integer day = Integer.parseInt(days);
		List<PrepaidCode> prepaidCodeList = prepaidCodeRepository.findByDays(day, "1",user.getHotlInfo());
		if (prepaidCodeList != null && prepaidCodeList.size()>0) {
			prepaidCodeDeatail.setSize(prepaidCodeList.size());
			prepaidCodeDeatail.setWarnPoint(prepaidCodeList.get(0).getUser().getHotlInfo().getWarnPoint());
			prepaidCodeDeatail.setAmount(prepaidCodeList.get(0).getAmount());
			if(prepaidCodeList.get(0).getPrepaidCode()!=null && !prepaidCodeList.get(0).getPrepaidCode().isEmpty()){
				prepaidCodeDeatail.setPrepaidCode(prepaidCodeList.get(0).getPrepaidCode());
			}else{
				prepaidCodeDeatail.setWuserid(prepaidCodeList.get(0).getWuserid());
				prepaidCodeDeatail.setWpassword(prepaidCodeList.get(0).getWpassword());
			}
		} else {
			prepaidCodeDeatail.setSize(0);
			prepaidCodeDeatail.setAmount(0);
			prepaidCodeDeatail.setPrepaidCode("NO");
		}
		return prepaidCodeDeatail;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
	public UsedPlanInfo saveRecord(UsedPlanInfo usedPlanInfo) {
		PrepaidCodeDeatail prepaidCodeDeatail = getPrepaidCode(usedPlanInfo.getDays(),usedPlanInfo.getUser().getUsername());
		if (prepaidCodeDeatail.getSize() > 0) {
			PrepaidCode prepaidCode = null;
			
			if(prepaidCodeDeatail.getPrepaidCode()!=null && !prepaidCodeDeatail.getPrepaidCode().isEmpty()){
					prepaidCode = prepaidCodeRepository.findByPrepaidCode(prepaidCodeDeatail.getPrepaidCode(),usedPlanInfo.getUser().getHotlInfo());
			}else{
				prepaidCode=prepaidCodeRepository.findByWuserid(prepaidCodeDeatail.getWuserid(),usedPlanInfo.getUser().getHotlInfo());
			}
			
			usedPlanInfo.setPrepaidCode(prepaidCode);
			usedPlanInfo.setHotelInfo(usedPlanInfo.getUser().getHotlInfo());
			//Date date = new Date();
			//usedPlanInfo.setDate(date);
			usedPlanInfo = usedPlanInfoRepository.save(usedPlanInfo);
			prepaidCode.setUsedPlanInfo(usedPlanInfo);
			prepaidCode.setStatus("0");
			prepaidCode = prepaidCodeRepository.save(prepaidCode);
		} 
		return usedPlanInfo;
	}
	
	@Override
	public UsedPlanInfo getUsedPlanInfoByCode(String code,String userName) {
		User user = userRepository.findByUsername(userName);
		PrepaidCode prepaidCode = prepaidCodeRepository.findByPrepaidCode(code,user.getHotlInfo());
		if(prepaidCode==null){
			prepaidCode=prepaidCodeRepository.findByWuserid(code,user.getHotlInfo());
		}
		return usedPlanInfoRepository.getUsedPlanInfoByPrepaidCode(prepaidCode);
	}
	
	@Override
	public UsedPlanInfoDTO getUsedPlanDTOByPrepaidCode(String code,String userName) {
		UsedPlanInfo usedPlanInfo = getUsedPlanInfoByCode(code,userName);
		UsedPlanInfoDTO usedPlanInfoDTO=new UsedPlanInfoDTO();
		usedPlanInfoDTO.setPrepaidCode(usedPlanInfo.getPrepaidCode().getPrepaidCode());
		usedPlanInfoDTO.setWuserid(usedPlanInfo.getPrepaidCode().getWuserid());
		usedPlanInfoDTO.setWpassword(usedPlanInfo.getPrepaidCode().getWpassword());
		if(usedPlanInfo.getDays().equals("7")){
			usedPlanInfoDTO.setPlan("1 Week");
		}if(usedPlanInfo.getDays().equals("30")){
			usedPlanInfoDTO.setPlan("1 Month");
		}else{
			usedPlanInfoDTO.setPlan(usedPlanInfo.getDays());
		}
		usedPlanInfoDTO.setDate(usedPlanInfo.getDate());
		usedPlanInfoDTO.setAmount(usedPlanInfo.getAmount());
		usedPlanInfoDTO.setGuestName(usedPlanInfo.getGuestName());
		usedPlanInfoDTO.setRoomNo(usedPlanInfo.getRoomNo());
		usedPlanInfoDTO.setPhotoIdProof(usedPlanInfo.getPhotoIdProof());
		usedPlanInfoDTO.setPhotoIdProofType(usedPlanInfo.getPhotoIdProofType());
		usedPlanInfoDTO.setMobileNo(usedPlanInfo.getMobileNo());
		usedPlanInfoDTO.setAddress(usedPlanInfo.getAddress());
		usedPlanInfoDTO.setEmailId(usedPlanInfo.getEmailId());
		usedPlanInfoDTO.setHotelName(usedPlanInfo.getUser().getHotlInfo().getHotelName());
		return usedPlanInfoDTO;
	}
	
	@Override
	public List<UsedPlanInfoDTO> getBulkPrepaidCode(String days, int count, String userName) {
		Integer day = Integer.parseInt(days);
		User user = userRepository.findByUsername(userName);
		List<PrepaidCode> prepaidCodeList = prepaidCodeRepository.findByDays(day,"1",user.getHotlInfo());
		List<UsedPlanInfoDTO> usedPlanInfoDTOList = new ArrayList<UsedPlanInfoDTO>(); 
		
		if (prepaidCodeList != null && prepaidCodeList.size()>0) {
			Iterator<PrepaidCode> it = prepaidCodeList.iterator();
			for(int i=0;i<count;i++){
				PrepaidCode prepaidCode = (PrepaidCode) it.next();
				prepaidCode.setStatus("2");
				prepaidCode = prepaidCodeRepository.save(prepaidCode);
				
				UsedPlanInfoDTO usedPlanInfoDTO=new UsedPlanInfoDTO();
				usedPlanInfoDTO.setPrepaidCode(prepaidCode.getPrepaidCode());
				
				if(usedPlanInfoDTO.getPrepaidCode()==null){
					usedPlanInfoDTO.setPrepaidCode(prepaidCode.getWuserid()+", Password :"+prepaidCode.getWpassword());
				}
				
				if(days.equals("7")){
					usedPlanInfoDTO.setPlan("1 Week");
				}if(days.equals("30")){
					usedPlanInfoDTO.setPlan("1 Month");
				}else{
					usedPlanInfoDTO.setPlan(days);
				}
				usedPlanInfoDTO.setAmount(prepaidCode.getAmount());
				usedPlanInfoDTO.setGuestName("");
				usedPlanInfoDTO.setRoomNo("");
				usedPlanInfoDTO.setPhotoIdProof("");
				usedPlanInfoDTO.setPhotoIdProofType("ID Proof");
				usedPlanInfoDTO.setMobileNo("");
				usedPlanInfoDTO.setAddress("");
				usedPlanInfoDTO.setEmailId("");
				usedPlanInfoDTO.setHotelName(prepaidCode.getUser().getHotlInfo().getHotelName());
				usedPlanInfoDTOList.add(usedPlanInfoDTO);
				
			}
		}

		return usedPlanInfoDTOList;
	}

	@Override
	public List<UsedPlanInfoDTO> getReportByDate(Date fromDate, Date toDate) {
		List<UsedPlanInfo> usedPlanInfoList = usedPlanInfoRepository.getReportByDate(fromDate,toDate);
		return null;
	}
}