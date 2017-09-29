package com.airwire.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.airwire.dto.UsedPlanInfoDTO;
import com.airwire.service.PrepaidCodeService;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

@Controller
public class JasperController {

	@Autowired
	PrepaidCodeService prepaidCodeService;

	@RequestMapping("myReport")
	public void myReport(@RequestParam(required=true) String prepaidCode, HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Principal principal){

		List<UsedPlanInfoDTO>list=new ArrayList<UsedPlanInfoDTO>();
		try {
			UsedPlanInfoDTO usedPlanInfoDTO = prepaidCodeService.getUsedPlanDTOByPrepaidCode(prepaidCode);
			if(usedPlanInfoDTO.getPrepaidCode()==null){
				usedPlanInfoDTO.setPrepaidCode(usedPlanInfoDTO.getWuserid()+", Password :"+usedPlanInfoDTO.getWpassword());
			}
			list.add(usedPlanInfoDTO);
			String jasperFilePath = httpServletRequest.getServletContext().getRealPath("WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper");//Blank_A4_Shivshanker.jrxml
			ByteArrayOutputStream resultOutputStream =  new ByteArrayOutputStream();
			HashMap<String, Object> params = new HashMap<String, Object>();
			JasperReport jr = (JasperReport)JRLoader.loadObject(new File(jasperFilePath));
			JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(list));
			JRPdfExporter jrPdfExporter=new JRPdfExporter();
			jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resultOutputStream);
			jrPdfExporter.exportReport();

			DateFormat formatter = new SimpleDateFormat("EEEE_dd_MM_yyyy_hh_mm_ss_SSS_a");
			Date date = Calendar.getInstance().getTime();
			String today = formatter.format(date);

			ServletOutputStream outputStream = httpServletResponse.getOutputStream();

			if(resultOutputStream != null){
				httpServletResponse.setHeader("Content-Disposition", "inline; filename=\"" + "PrepaidCode_"+today+"."+ "pdf" + "\"");
				httpServletResponse.setContentType("application/pdf");
				outputStream.write(resultOutputStream.toByteArray());
			}
			outputStream.flush();
			outputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@RequestMapping("bulkprepaidcode")
	public void bulkPrepaidcode(@RequestParam(required=true) String plan, @RequestParam(required=true) int count,  HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse,Principal principal){

		List<UsedPlanInfoDTO>list;
		try {
			list=prepaidCodeService.getBulkPrepaidCode(plan,count);
			if(list!=null && list.size()>0){
			String jasperFilePath = httpServletRequest.getServletContext().getRealPath("WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper");//Blank_A4_Shivshanker.jrxml
			ByteArrayOutputStream resultOutputStream =  new ByteArrayOutputStream();
			HashMap<String, Object> params = new HashMap<String, Object>();
			JasperReport jr = (JasperReport)JRLoader.loadObject(new File(jasperFilePath));
			JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(list));
			JRPdfExporter jrPdfExporter=new JRPdfExporter();
			jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resultOutputStream);
			jrPdfExporter.exportReport();

			DateFormat formatter = new SimpleDateFormat("EEEE_dd_MM_yyyy_hh_mm_ss_SSS_a");
			Date date = Calendar.getInstance().getTime();
			String today = formatter.format(date);

			ServletOutputStream outputStream = httpServletResponse.getOutputStream();

			if(resultOutputStream != null){
				httpServletResponse.setHeader("Content-Disposition", "inline; filename=\"" + "PrepaidCode_"+today+"."+ "pdf" + "\"");
				httpServletResponse.setContentType("application/pdf");
				outputStream.write(resultOutputStream.toByteArray());
			}
			outputStream.flush();
			outputStream.close();
			}
			
			PrintWriter out=httpServletResponse.getWriter();
			out.write("Selected Prepaide Code Plan Is not Available Please Upload File to Generate Prepaid Code");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
