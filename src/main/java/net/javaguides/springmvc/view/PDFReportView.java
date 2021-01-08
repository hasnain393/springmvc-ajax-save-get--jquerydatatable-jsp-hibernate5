package net.javaguides.springmvc.view;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import net.javaguides.springmvc.entity.Customer;

public class PDFReportView extends AbstractPdfView {

 @Override
 protected void buildPdfDocument(Map<String, Object> model, Document document,
		 PdfWriter writer, HttpServletRequest request,
   HttpServletResponse response) throws Exception {
  
  response.setHeader("Content-Disposition", "attachment; filename=\"customer_list.pdf\"");
  
  @SuppressWarnings("unchecked")
  List<Customer> customerList = (List<Customer>) model.get("customersList");
  
  Table table = new Table(4);
  table.addCell(" ID ");
  table.addCell(" FIRST NAME ");
  table.addCell(" LAST NAME  ");
  table.addCell(" EMAIL ");
  
  for(Customer customers:customerList){
   table.addCell(String.valueOf(" "+customers.getId()+" "));
   table.addCell(" "+customers.getFirstName()+" ");
   table.addCell(" "+customers.getLastName()+" ");
   table.addCell(" "+customers.getEmail()+" ");
  }
  
  document.add(table);
 }

}
