package com.example.occasion;

import com.example.occasion.ApiResponse.ApiResponse;
import com.example.occasion.Controller.MyServiceController;
import com.example.occasion.Model.MyService;
import com.example.occasion.Model.Myorder;
import com.example.occasion.Service.MyServiceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static java.nio.file.Files.delete;
import static jdk.internal.jimage.ImageReaderFactory.get;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MyServiceController.class , excludeAutoConfiguration = {SecurityAutoConfiguration.class})
public class MyServiceControllerTest {
    @MockBean
    MyServiceService myServiceService;

    @Autowired
    MockMvc mockMvc;

    MyService myService1,myService2,myService3;
    Myorder myorder;

    ApiResponse apiResponse;

    List<MyService> myServices,myServiceList;

    @BeforeEach
    void setUp() {
        myorder=new Myorder(null,12,"12/2/2023","10:pm",200,"new","weekly",4,null,null,null,null);
        myService1 = new MyService(1,"myservice1","weekly",myorder,null,null);
        myService2 = new MyService(1,"myservice2","weekly",myorder,null,null);
        myService3 = new MyService(1,"myservice3","weekly",myorder,null,null);
        myServices= Arrays.asList(myService1);
        myServiceList=Arrays.asList(myService2);



    }

//    @Test
//    public void GetAllMyservice() throws Exception {
//        Mockito.when(myServiceService.getAll()).thenReturn(myServices);
//        mockMvc.perform(get("/api/v1/myService/get"))
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("myservice1"));
//    }

//    @Test
//    public void testAddTodo() throws  Exception {
//        mockMvc.perform(post("/api/v1/myService")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content( new ObjectMapper().writeValueAsString(myService1)))
//                .andExpect(status().isOk());
//
//    }
//
//    @Test
//    public void testDeletemyservice() throws Exception{
//        mockMvc.perform(delete("/api/v1/myService/delete/{id}",myService1.getId()))
//                .andExpect(status().isOk());
//
//    }


//    public void testupdatemyservice() throws Exception{
//        mockMvc.perform(delete("/api/v1/myService/delete/{id}",myService1.getId()))
//                .andExpect(status().isOk());

}
