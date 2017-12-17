package com.airwire.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.airwire.model.HotelInfo;
import com.airwire.model.PrepaidCode;
import com.airwire.model.User;
import com.airwire.service.HotelService;
import com.airwire.service.PrepaidCodeService;
import com.airwire.service.UserService;

import au.com.bytecode.opencsv.CSVReader;
/**
 * 
 * @author ShivshankerMhadiwale
 *
 */
@Controller
public class UploadController {

	@Autowired
	PrepaidCodeService prepaidCodeService;

	@Autowired
	UserService userService;

	@Autowired
	HotelService hotelService;

	private CSVReader reader;

	private BufferedOutputStream stream;

	@RequestMapping("importcsv")
	public String uploadcsv(Model model, Principal principal) {
		model.addAttribute("userName", principal.getName());
		model.addAttribute("hotelInfoList", hotelService.findAll());
		return "admin/importcsv";
	}

	@RequestMapping(value = "uploadprepaidcodeexcelfile", method = RequestMethod.POST)
	public String uploadprepaidCodeExcelFile(Principal principal, ModelMap model,
			@RequestParam("file") MultipartFile file, @RequestParam(required = false) Long hotelId,
			@RequestParam("days") int plan, @RequestParam("amount") int amount, HttpServletRequest request) {
		if (file.isEmpty()) {
			model.put("msg", "failed to upload file because its empty");
			return "mainpage";
		}
		String rootPath = request.getSession().getServletContext().getRealPath("/");
		File dir = new File(rootPath + File.separator + "uploadedfile");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
		try {
			InputStream is = file.getInputStream();
			stream = new BufferedOutputStream(new FileOutputStream(serverFile));
			int i;
			while ((i = is.read()) != -1) {
				stream.write(i);
			}
			stream.flush();

		} catch (IOException e) {
			model.put("msg", "failed to process file because : " + e.getMessage());
			return "admin/importcsv";
		}
		String[] nextLine;
		try {
			FileReader fileReader = new FileReader(serverFile);
			reader = new CSVReader(fileReader, ';', '\'', 1);
			User user = userService.findByUsername(principal.getName());
			HotelInfo hotelInfo = null;
			if (hotelId != null && hotelId > 0) {
				hotelInfo = hotelService.findById(hotelId);
			} else {
				hotelInfo = user.getHotelInfo();
			}

			while ((nextLine = reader.readNext()) != null) {
				StringTokenizer t = new StringTokenizer(nextLine[0]);
				PrepaidCode prepaidCode = new PrepaidCode();
				if (hotelInfo.getControllerName().equalsIgnoreCase("WIFISOFT")) {
					String prepaidCodeTemp = t.nextToken(",");
					prepaidCodeTemp = prepaidCodeTemp.replaceAll("\"", "");
					prepaidCode.setPrepaidCode(prepaidCodeTemp);
				} else {
					String wuserid = t.nextToken(",");
					String wpassword = t.nextToken(",");
					wuserid = wuserid.replaceAll("\"", "");
					wpassword = wpassword.replaceAll("\"", "");
					prepaidCode.setWuserid(wuserid);
					prepaidCode.setWpassword(wpassword);
				}

				prepaidCode.setHotelInfo(hotelInfo);
				prepaidCode.setAmount(amount);
				prepaidCode.setDays(plan);
				prepaidCode.setStatus("1");
				prepaidCode.setUser(user);
				Date date = new Date();
				prepaidCode.setDate(date);
				prepaidCodeService.savePrepaidCode(prepaidCode);
			}

		} catch (IOException e) {
			model.put("msg", "error while reading csv andprocess : " + e.getMessage());
		}
		model.put("msg", "File successfully uploaded and processed");
		return "admin/importcsv";
	}
}
