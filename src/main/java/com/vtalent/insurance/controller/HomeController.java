package com.vtalent.insurance.controller;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vtalent.insurance.dao.ZipRepository;
import com.vtalent.insurance.model.UsaZipInfo;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private ZipRepository zipRepo;

	@GetMapping
	public String init(HttpServletRequest request, HttpServletResponse response) {
		return "home";
	}

	@GetMapping("/xlToDb")
	public String xlToDb() {
		
		List<UsaZipInfo> listofDetails = new ArrayList<>();
		try {
			String excelFilePath = "C:\\Users\\Anjaneyulu\\Downloads\\usazipcode-1512j.xlsx";
			FileInputStream input = new FileInputStream(excelFilePath);

			try (XSSFWorkbook workbook = new XSSFWorkbook(input)) {
				XSSFSheet sheet = workbook.getSheet("usazipcode");
				Iterator<Row> iterator = sheet.iterator();
				iterator.next();

				while (iterator.hasNext()) {
					Row nextrow = iterator.next();
					Iterator<Cell> cells = nextrow.iterator();
					int coloumnid = 0;
					UsaZipInfo zp = new UsaZipInfo();

					while (cells.hasNext()) {
						Cell coloumn = cells.next();
						switch (coloumnid) {
						case 0:
							zp.setZip(String.format("%05d", (int) coloumn.getNumericCellValue()));
							break;
						case 2:
							zp.setCity(coloumn.getStringCellValue());
							break;
						case 3:
							zp.setState(coloumn.getStringCellValue());
							break;
						default:
							break;
						}
						coloumnid++;
					}
					listofDetails.add(zp);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		zipRepo.saveAll(listofDetails);
		
		return "Saved Successfully";

	}

}
