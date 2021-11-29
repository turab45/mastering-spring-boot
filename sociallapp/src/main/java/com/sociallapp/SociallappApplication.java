package com.sociallapp;

import com.sociallapp.daoimpl.PostDaoImpl;
import com.sociallapp.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SociallappApplication{

    public static void main(String[] args) {

        SpringApplication.run(SociallappApplication.class, args);
    }

}
