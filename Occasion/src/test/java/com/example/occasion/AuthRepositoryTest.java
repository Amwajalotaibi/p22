package com.example.occasion;

import com.example.occasion.Model.MyUser;
import com.example.occasion.Repostiroy.AuthRepository;
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
public class AuthRepositoryTest {
   @Autowired
    AuthRepository authRepository;
    MyUser myUser;

    MyUser myUser1,myUser2,myUser3;

    List<MyUser> myUserList;
    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Amwaj","1234","customer",null,null);
        myUser1=new MyUser(null,"occ","1234","company",null,null);
        myUser2=new MyUser(null,"Asma","1234","customer",null,null);
        myUser3=new MyUser(null,"mayar","1234","customer",null,null);


    }

    @Test
    public void findMyUserById(){
        authRepository.save(myUser1);
        myUser2=authRepository.findMyUserById(myUser1.getId());
        Assertions.assertThat(myUser2).isEqualTo(myUser1);
    }

//    @Test
//    public void findMyUserByUsername(){
//        authRepository.save(myUser1);
//        myUser=authRepository.findMyUserByUsername(myUser1.getUsername());
//        Assertions.assertThat(myUser.getUsername()).isEqualTo(myUser1.getUsername());
//    }


}
