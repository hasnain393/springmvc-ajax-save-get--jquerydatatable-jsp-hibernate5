package net.javaguides.springmvc.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.mail.EmailServiceImpl;
import net.javaguides.springmvc.service.CustomerService;
import net.javaguides.springmvc.view.ExcelReportView;
import net.javaguides.springmvc.view.PDFReportView;

@Controller
@RequestMapping("/customer")
@SessionAttributes("username")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private EmailServiceImpl emailServiceImp;

	private LinkedHashMap<String, Object> theModel;

	// the below method will be invoked for following
	// urls:http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/list
	// &&
	// url:http://localhost:8081/springmvc5-hibernate5-jsp-mysql-example/customer/
	@RequestMapping(value = { "/list", "/" }, method = RequestMethod.GET)
	public String listCustomers(ModelMap theModel) {
		
	
		String username = (String) theModel.get("username");
		
		System.out.println("///////list         "+username);

		if (username != null && !username.isEmpty()) {
			
		List<Customer> theCustomers = customerService.getCustomers();
		System.out.println(customerService.getTotalRecord());
		Long count = customerService.getTotalRecord();
		theModel.addAttribute("totalcount", count);
		theModel.addAttribute("customers", theCustomers);
		return "list-customers";
		
	}
		else{
			return "login";
		}
		}

	@GetMapping("/excel")
	public ModelAndView exporttoExcelCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		System.out.println(customerService.getTotalRecord());

		return new ModelAndView(new ExcelReportView(), "customersList", theCustomers);
	}

	@GetMapping("/pdf")
	public ModelAndView exporttoPdfCustomers(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		System.out.println(customerService.getTotalRecord());

		return new ModelAndView(new PDFReportView(), "customersList", theCustomers);
	}

	@GetMapping("/test")
	public void testingcall() {
		System.out.println("+++testing  buttn  in spring =_____)))))))))))(((((((((((((");
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/sortby")
	public String listcustomerbyasc(Model theModel) {
		System.out.println("++++++++++++++test");
		System.out.println("============================================================custome methpd");
		List<Customer> sortedcustomer = customerService.getByAscOrder();

//    	for (Customer customer : sortedcustomer) {
//    		System.out.println(customer);
//		}

		theModel.addAttribute("sortcustomers", sortedcustomer);
		return "fliter-customers";

	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searching(@RequestParam("key") String keyword) {
		System.out.println("value is ==----------------" + keyword);
		System.out.println("seeeeeaaarccccchiiiinnnnnnnnnh the recordd");
		// Customer customer=customerService.getCustomer(theId);
		List<Customer> customers = customerService.startsWith(keyword);
		System.out.println(customers);

		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}

	@GetMapping("/count")
	public void getTotalRecord() {
		System.out.println("=============--------------inside   count");
		System.out.println(customerService.getTotalRecord());

	}

	@GetMapping("/mail")
	public String sendMail(@RequestParam("mailto") String to) {
		System.out.println("emaiiiiillllllllllllllllllllllllllllllll testting");
		System.out.println(to);
		String subject = "welcome to CRM ";
		String text = "stay tuned to get more information of your interest,your feedbackis important to us ";
		emailServiceImp.sendSimpleMessage(to, subject, text);
		return "redirect:/customer/list";

	}

	@GetMapping("/pagedefault")
	public String readEntireDataByPagination(Model themodel) {

		List<Customer> pagecustomer = customerService.readEntireDataByPagination(0, 4);
		System.out.println("ppppppppppppaaaaaaaaaaagggggggggggggeeeeeeeeeiiiiiiiiiiiinnnnnnnnnnaaaaaaaation");
		for (Customer customers : pagecustomer) {
			System.out.println("controllelr mein hu  bhai" + customers);
		}

		themodel.addAttribute("customers", pagecustomer);
		System.out.println("inpage");
		return "pgnation";
	}

	@GetMapping("/page")
	public String readEntireDataByPagination(@RequestParam int pgnum, @RequestParam int pgsize, Model themodel) {
		System.out.println("pageenummmmmmmmmb" + pgnum);
		System.out.println("pagesizzzzzzzzzzzzze" + pgsize);
		List<Customer> pagecustomer = customerService.readEntireDataByPagination(pgnum, pgsize);
		System.out.println("ppppppppppppaaaaaaaaaaagggggggggggggeeeeeeeeeiiiiiiiiiiiinnnnnnnnnnaaaaaaaation");
		for (Customer customers : pagecustomer) {
			System.out.println("controllelr mein hu  bhai" + customers);
		}
		themodel.addAttribute("totol", "10");
		themodel.addAttribute("customers", pagecustomer);
		System.out.println("inpage");
		return "pgnation";
	}

	

}