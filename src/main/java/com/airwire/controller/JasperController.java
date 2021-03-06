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
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Controller
public class JasperController {

	@Autowired
	PrepaidCodeService prepaidCodeService;

	@RequestMapping("myReport")
	public void myReport(@RequestParam(required = true) String prepaidCode,@RequestParam(required = false) Long orgId, HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, Principal principal) {

		List<UsedPlanInfoDTO> list = new ArrayList<UsedPlanInfoDTO>();
		try {
			UsedPlanInfoDTO usedPlanInfoDTO = prepaidCodeService.getUsedPlanDTOByPrepaidCode(prepaidCode,
					principal.getName(),orgId);
			if (usedPlanInfoDTO.getPrepaidCode() == null) {
				usedPlanInfoDTO
						.setPrepaidCode(usedPlanInfoDTO.getWuserid() + ", Password :" + usedPlanInfoDTO.getWpassword());
			}
			list.add(usedPlanInfoDTO);
			System.out.println("Called Jasper");
			String jasperFilePath = "";
			try {
				jasperFilePath = httpServletRequest.getSession().getServletContext()
						.getRealPath("WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper");
			} catch (Exception e) {
				System.out.println("In Exception");
				e.printStackTrace();
				jasperFilePath = "/usr/local/apache-tomcat-9.0.4/webapps/airwire/WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper";
			}
			System.out.println("Path Loaded" + jasperFilePath);
			if (jasperFilePath == null) {
				jasperFilePath = "/usr/local/apache-tomcat-9.0.4/webapps/airwire/WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper";
				System.out.println("Mannually assign ::" + jasperFilePath);
			}

			ByteArrayOutputStream resultOutputStream = new ByteArrayOutputStream();
			HashMap<String, Object> params = new HashMap<String, Object>();
			JasperReport jr = (JasperReport) JRLoader.loadObject(new File(jasperFilePath));
			// InputStream
			// is=this.getClass().getResourceAsStream("/com/medicam/servlets/Invoice.jrxml")
			JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(list));
			JRPdfExporter jrPdfExporter = new JRPdfExporter();
			jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resultOutputStream);
			jrPdfExporter.exportReport();

			DateFormat formatter = new SimpleDateFormat("EEEE_dd_MM_yyyy_hh_mm_ss_SSS_a");
			Date date = Calendar.getInstance().getTime();
			String today = formatter.format(date);

			ServletOutputStream outputStream = httpServletResponse.getOutputStream();
			System.out.println("OK");
			if (resultOutputStream != null) {
				System.out.println("Final");
				httpServletResponse.setHeader("Content-Disposition",
						"inline; filename=\"" + "PrepaidCode_" + today + "." + "pdf" + "\"");
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
	public void bulkPrepaidcode(@RequestParam(required = true) Long plan, @RequestParam(required = true) int count,
			@RequestParam(required = false) Long orgId,
			HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Principal principal) {

		List<UsedPlanInfoDTO> list;
		try {
			list = prepaidCodeService.getBulkPrepaidCode(plan, count, principal.getName(),orgId);
			if (list != null && list.size() > 0) {
				System.out.println("Called Jasper");
				String jasperFilePath = "";
				try {
					jasperFilePath = httpServletRequest.getSession().getServletContext()
							.getRealPath("WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper");
				} catch (Exception e) {
					System.out.println("In Exception");
					e.printStackTrace();
					jasperFilePath = "/usr/local/apache-tomcat-9.0.4/webapps/airwire/WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper";
				}
				System.out.println("Path Loaded" + jasperFilePath);
				if (jasperFilePath == null) {
					jasperFilePath = "/usr/local/apache-tomcat-9.0.4/webapps/airwire/WEB-INF/view/jasper/Blank_A4_with_HotelName.jasper";
					System.out.println("Mannually assign ::" + jasperFilePath);
				}
				ByteArrayOutputStream resultOutputStream = new ByteArrayOutputStream();
				HashMap<String, Object> params = new HashMap<String, Object>();
				JasperReport jr = (JasperReport) JRLoader.loadObject(new File(jasperFilePath));
				JasperPrint jp = JasperFillManager.fillReport(jr, params, new JRBeanCollectionDataSource(list));
				JRPdfExporter jrPdfExporter = new JRPdfExporter();
				jrPdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
				jrPdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, resultOutputStream);
				jrPdfExporter.exportReport();

				DateFormat formatter = new SimpleDateFormat("EEEE_dd_MM_yyyy_hh_mm_ss_SSS_a");
				Date date = Calendar.getInstance().getTime();
				String today = formatter.format(date);

				ServletOutputStream outputStream = httpServletResponse.getOutputStream();

				if (resultOutputStream != null) {
					httpServletResponse.setHeader("Content-Disposition",
							"inline; filename=\"" + "PrepaidCode_" + today + "." + "pdf" + "\"");
					httpServletResponse.setContentType("application/pdf");
					outputStream.write(resultOutputStream.toByteArray());
				}
				outputStream.flush();
				outputStream.close();
			}
					if((list==null) ||(list.size()==0)){
						PrintWriter out = httpServletResponse.getWriter();
						out.write("Selected Prepaide Code Plan Is not Available Please Upload File to Generate Prepaid Code");
					}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
