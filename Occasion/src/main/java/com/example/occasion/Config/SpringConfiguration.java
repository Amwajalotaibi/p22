package com.example.occasion.Config;

import com.example.occasion.Service.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringConfiguration {

 private final MyUserDetailsService myUserDetailsService;
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationProvider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authenticationProvider(authenticationProvider())
                .authenticationProvider(authenticationProvider())
                .authorizeHttpRequests()
//                .requestMatchers("/api/v1/company/add").permitAll()
//                .requestMatchers("/api/v1/customer/add").permitAll()
                .requestMatchers("/api/v1/customer/**").permitAll()
                .requestMatchers("/api/v1/company/**").permitAll()
//                .requestMatchers("/api/v1/myorder/add/{serviceId}/{companyId}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myservice/add").hasAuthority("COMPANY")

                //service type
//                .requestMatchers("/api/v1/servicetype/add").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/servicetype/update/{id}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/servicetype/delete/{id}").hasAuthority("COMPANY")
//                .requestMatchers("//api/v1/servicetype/get-name/{name}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/servicetype/get-price/{servicetype_id}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/servicetype/get-details/{servicetype_id}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/servicetype/discount/{amount}").hasAuthority("COMPANY")


                //myOrder
//                .requestMatchers("/api/v1/myorder/add/{serviceId}/{companyId}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/update/{myorderId}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/delete/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/get-id/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/get-day/{day}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/get-status/{status}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myorder/subscription/{category}").hasAuthority("CUSTOMER")


                //myService
//                .requestMatchers("/api/v1/myService").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myService/get").permitAll()
//                .requestMatchers("/api/v1/myService/add").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myService/update/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myService/delete/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/myService/subscription/{category}").hasAuthority("CUSTOMER")


                //Rating
//                .requestMatchers("/api/v1/rating").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/rating/get").permitAll()
//                .requestMatchers("/api/v1/rating/add").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/rating/update/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/rating/delete/{id}").hasAuthority("CUSTOMER")


                //Customer
//                .requestMatchers("/api/v1/customer").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/customer/get").permitAll()
//                .requestMatchers("/api/v1/customer/update/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/customer/delete/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/customer/get-myOrder/{id}").hasAuthority("CUSTOMER")
//                .requestMatchers("/api/v1/customer/loyalty/{id}").hasAuthority("CUSTOMER")


                //Company
//                .requestMatchers("/api/v1/company").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/company/get").permitAll()
//                .requestMatchers("/api/v1/company/update/{id}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/company/delete/{id}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/company/get-company/{city}").hasAuthority("COMPANY")
//                .requestMatchers("/api/v1/company/get-company/{timecatgory}").hasAuthority("COMPANY")



                .requestMatchers("/api/v1/auth/login").hasAuthority("COMPANY")
                .requestMatchers("/api/v1/auth/login").hasAuthority("CUSTOMER")
                .anyRequest().authenticated()
                //.anyRequest().permitAll()
                .and()
                .logout().logoutUrl("/api/v1/auth/logout")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
        return http.build();
    }

}
