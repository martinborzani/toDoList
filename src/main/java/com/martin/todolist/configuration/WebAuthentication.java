package com.martin.todolist.configuration;


import com.martin.todolist.models.Person;
import com.martin.todolist.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    PersonRepository personRepository;


    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception{


        auth.userDetailsService(inputEmail ->{
            Person person = personRepository.findByEmail(inputEmail);


            if(person != null){
                return new User(person.getEmail(),person.getPassword(),AuthorityUtils.createAuthorityList("CLIENT"));
            }else{
                throw new UsernameNotFoundException("Unknown client: " + inputEmail);
            }

        });


    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return PasswordEncoderFactories.createDelegatingPasswordEncoder();

    }


}
