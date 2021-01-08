package net.javaguides.springmvc.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.dao.CustomerDAO;
import net.javaguides.springmvc.entity.Admin;
import net.javaguides.springmvc.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List < Customer > getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerDAO.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDAO.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDAO.deleteCustomer(theId);
    }

	@Override
	@Transactional
	public List<Customer> getByAscOrder() {
		System.out.println("============================================================in service");
		// TODO Auto-generated method stub
		return customerDAO.getByAscOrder();
	}
	
	@Override
	@Transactional
	public List<Customer> startsWith(String keyword) {
	return	customerDAO.startsWith(keyword);
		
	}

	@Override
	@Transactional
	public  Long getTotalRecord(){
	return	customerDAO.getTotalRecord();
		
	}
	
	//test pagination
	public List<Customer> readEntireDataByPagination(int pgNumber,int pgSize) {
		
	List<Customer> pagecustomers= customerDAO.readEntireDataByPagination(pgNumber,pgSize);
	System.out.println("service mein hu bhai"+pagecustomers);
		
		return pagecustomers;
		
	}
	
	
		
	
}