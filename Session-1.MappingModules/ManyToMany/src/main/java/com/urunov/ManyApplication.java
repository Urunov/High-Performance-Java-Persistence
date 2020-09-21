package com.urunov;

import com.urunov.model.Post;
import com.urunov.model.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyApplication.class, args);

        Post post1 = new Post("JPA with Hibernate need to practice");

        Post post2 = new Post("Native Hibernate process");

        Tag tag1= new Tag("Java");
        Tag tag2 = new Tag("Hibernate");


        post1.getTags().add(tag1);
        post2.getTags().add(tag1);
        post1.getTags().add(tag2);


    }




}
