package net.javaguides.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.dao.AdminDAO;
import net.javaguides.springmvc.dao.CustomerDAO;
import net.javaguides.springmvc.entity.Admin;

@Service
public class AdminServiceImpl  implements AdminService {
	@Autowired
	private AdminDAO adminDAO;


	//FOR LOGIN
		@Transactional
		public List<Admin> getAuthorizedCustomers(){
			List <Admin> authorisedusers=adminDAO.getAuthorizedCustomers();
			return authorisedusers;

}}
