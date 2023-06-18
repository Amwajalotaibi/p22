package com.example.occasion;


import com.example.occasion.Model.MyService;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Repostiroy.MyServiceRepository;
import com.example.occasion.Repostiroy.MyorderRepository;
import com.example.occasion.Service.MyServiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class MyServiceServiceTest {
    @InjectMocks
    MyServiceService myServiceService;


    @Mock
    MyServiceRepository myServiceRepository;

    @Mock
    MyorderRepository myorderRepository;

    Myorder myorder;

    MyService myService1, myService2, myService3;

    List<MyService> myServiceList;

    @BeforeEach
    void setUp() {
        myorder = new Myorder(null, 2, "10/11/2023", "9AM", 200, "NEW", "weekly", 0, null, null, null, null);
        myService1 = new MyService(null, "staff", "mediumparty", null, null, null);
        myService2 = new MyService(null, "eat", "bigparty", null, null, null);
        myService3 = new MyService(null, "coordination", "smallparty", null, null, null);

        myServiceList = new ArrayList<>();

        myServiceList.add(myService1);
        myServiceList.add(myService2);
        myServiceList.add(myService3);
    }
    @Test
    public void getMyservice(){
        when(myServiceRepository.findAll()).thenReturn(myServiceList);
        List<MyService> myServices=myServiceService.getAll();
        Assertions.assertEquals(myServices,myServices);
        Assertions.assertEquals(3,myServices.size());
    }

    @Test
    public void deleteMyService(){
        when(myServiceRepository.findMyServiceById(myService1.getId())).thenReturn(myService1);
         myServiceService.deleteMyService(myService1.getId());
        verify(myServiceRepository,times(1)).findMyServiceById(myService1.getId());
    }


    @Test
    public void updateTodo(){

        when(myServiceRepository.findMyServiceById(myorder.getId())).thenReturn(myService1);

        myServiceService.updateMyService(myService1.getId(),myService2);

        verify(myServiceRepository,times(1)).findMyServiceById(myorder.getId());
    }

}
