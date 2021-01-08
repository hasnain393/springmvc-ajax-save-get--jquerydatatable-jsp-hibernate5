package net.javaguides.springmvc.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import net.javaguides.springmvc.entity.Customer;


 
 
public class ExcelReportView extends AbstractXlsView{
 
 @Override
 protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
 HttpServletResponse response) throws Exception {
  
 response.setHeader("Content-Disposition", "attachment;filename=\"customers.xls\"");
 List<Customer> customerList = (List<Customer>) model.get("customersList");
 Sheet sheet = workbook.createSheet("Student Data");
 Row header = sheet.createRow(0);
 header.createCell(0).setCellValue("Customer ID");
 header.createCell(1).setCellValue("Customer first_name");
 header.createCell(2).setCellValue("Customer last_name");
 header.createCell(3).setCellValue("Customer  email");
  
 int rowNum = 1;
 for(Customer customers:customerList){
 Row row = sheet.createRow(rowNum++);
 row.createCell(0).setCellValue(customers.getId());
 row.createCell(1).setCellValue(customers.getFirstName());
 row.createCell(2).setCellValue(customers.getLastName());
 row.createCell(3).setCellValue(customers.getEmail());
 }
 }
}