package net.javaguides.springmvc.service;

import java.util.List;

import net.javaguides.springmvc.entity.Admin;
import net.javaguides.springmvc.entity.Customer;

public interface CustomerService {

    public List < Customer > getCustomers();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(int theId);

    public void deleteCustomer(int theId);

    public List <Customer> getByAscOrder();
    
    public List<Customer> startsWith(String keyword);
    
    public  Long getTotalRecord();
    
    //test pagination
    public  List<Customer> readEntireDataByPagination(int pgNumber,int pgSize);
    

}
