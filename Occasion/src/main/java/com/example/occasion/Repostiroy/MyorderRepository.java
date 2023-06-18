package com.example.occasion.Repostiroy;

import com.example.occasion.Model.Company;
import com.example.occasion.Model.Customer;
import com.example.occasion.Model.MyUser;
import com.example.occasion.Model.Myorder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MyorderRepository extends JpaRepository<Myorder,Integer> {
    Myorder findMyOrderById(Integer id);
    List<Myorder> findMyOrderByDay(Integer day);

    List<Myorder> findMyOrderByStutas(String stutas);


}
