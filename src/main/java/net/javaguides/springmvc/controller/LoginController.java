package net.javaguides.springmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import net.javaguides.springmvc.entity.Admin;
import net.javaguides.springmvc.entity.Customer;
import net.javaguides.springmvc.service.AdminService;
import net.javaguides.springmvc.service.CustomerService;

@Controller
@SessionAttributes("username")
@RequestMapping("/customer")
public class LoginController {
	
	@Autowired
	private AdminService adminService; 
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/login")
	public String showLoginPage() {
		
		return "login";
	}
	@PostMapping("/login")
	public String checkuser(@RequestParam String name, @RequestParam String password,Model theModel) {
		List<Admin> uathorisedusers = adminService.getAuthorizedCustomers();
		
		for (Admin admin : uathorisedusers) {
			if (admin.getUsername().equals(name) & admin.getPassword().equals(password)) {
				theModel.addAttribute("username", name);
				return "redirect:/customer/list";
			}

		}
		return "error";

	}
	@RequestMapping("/ajax")
	public String showtestpage() {
		System.out.println("intest  ajax");
		return "getajax";
	}
	
	@RequestMapping("getServerTime")
	@ResponseBody
	public String time() {
		Date date=new Date();
		return date.toString();
	}
	
	@RequestMapping(value = { "/ajaxget"}, method = RequestMethod.GET)
	@ResponseBody
	public  List<Customer> listCustomers() {
		
		List<Customer> theCustomers = customerService.getCustomers();

		
		return theCustomers;
		
	}
	
	@GetMapping("/ajaxpost")
	public String showpostajaxpage() {
		//here we can get data from database and display on tha page too
		
		return "postajax";
	}
	
	
	@PostMapping("/addCustomer.lti")
	@ResponseBody
	public void addRetailer(@RequestBody Customer customer) {
		System.out.println("whole object"+customer);
		System.out.println("first name"+customer.getFirstName());
		System.out.println("last name"+customer.getLastName());
		System.out.println("email "+customer.getEmail());
		customerService.saveCustomer(customer);
	}
	
	@GetMapping("/pageajax")
	@ResponseBody
	public List<Customer> readEntireDataByPagination(@RequestParam int pgnum, @RequestParam int pgsize, Model themodel) {
		System.out.println("pageenummmmmmmmmb" + pgnum);
		System.out.println("pagesizzzzzzzzzzzzze" + pgsize);
		List<Customer> pagecustomer = customerService.readEntireDataByPagination(pgnum, pgsize);
		System.out.println("ppppppppppppaaaaaaaaaaagggggggggggggeeeeeeeeeiiiiiiiiiiiinnnnnnnnnnaaaaaaaation");
		for (Customer customers : pagecustomer) {
			System.out.println("controllelr mein hu  bhai" + customers);
		}
		themodel.addAttribute("customers", pagecustomer);
		System.out.println("inpage");
		return pagecustomer;
	}
	
	@GetMapping("/jquerdatatable")	
public String showjqueryDataTable(ModelMap theModel) {
		List<Customer> theCustomers = customerService.getCustomers();
		System.out.println("inside jquery datatable");
		theModel.addAttribute("customers", theCustomers);
		
		return "data-table";
	}
	
	@GetMapping("/testdt")
	public void testingdata() {
		System.out.println("///////////////////////////////////////////////////////////////");
		System.out.println("ajax call");
	}
}
