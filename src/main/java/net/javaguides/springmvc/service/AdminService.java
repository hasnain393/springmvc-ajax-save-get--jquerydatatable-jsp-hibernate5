package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Admin;

public interface AdminService {
	
	  //FOR LOGIN
    public List<Admin> getAuthorizedCustomers();

}
