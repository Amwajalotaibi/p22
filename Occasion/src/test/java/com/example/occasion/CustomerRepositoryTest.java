package com.example.occasion;

import com.example.occasion.Model.Customer;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Repostiroy.AuthRepository;
import com.example.occasion.Repostiroy.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    Customer customer;

    Customer customer1,customer2,customer3;

    List<Customer> customerList;
    @BeforeEach
    void setUp() {
       customer =new Customer(null,"Sara","0590498378","am@gmail.com","1234",false,0,null,null);
       customer1 =new Customer(null,"Asma","0590498378","am@gmail.com","1234",false,0,null,null);
       customer2 =new Customer(null,"may","0590498378","am@gmail.com","1234",false,0,null,null);
       customer3 =new Customer(null,"jood","0590498378","am@gmail.com","1234",false,0,null,null);
    }

//
//    @Test
//    public void getCustomerById (){
//        customerRepository.save(customer1);
//        customer2=customerRepository.getCustomerById(customer1.getId());
//        Assertions.assertThat(customer2).isEqualTo(customer1);
//    }
//
//    @Test
//    public void findCustomerByUsername(){
//        customerRepository.save(customer1);
//        List<Customer> customerList1 =  customerRepository.findAllByMyUser(customer1.getMyUser());
//        Assertions.assertThat(customer1.getMyUser()).isEqualTo(customerList1.get(customer.getId()));
//    }

}
