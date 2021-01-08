package net.javaguides.springmvc.dao;

import java.util.List;

import net.javaguides.springmvc.entity.Admin;

public interface AdminDAO {
	
	//FOR LOGIN
    public List<Admin> getAuthorizedCustomers();
}
