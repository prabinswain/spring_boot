package com.jpa.LibraryManagement;

import com.jpa.LibraryManagement.dao.LibraryDao;
import com.jpa.LibraryManagement.dao.impl.LibraryDaoImpl;
import com.jpa.LibraryManagement.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class LibraryManagementApplication{

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementApplication.class, args);
	}

    // command line runner runs after the spring beans have been loaded
    @Bean
    CommandLineRunner commandLineRunner(LibraryDao libraryDao){

        return authers -> {
            log.info("Starting command line runner");

            // add a new author in DB
//            addAnAuthor(libraryDao);
            findAuthorById(libraryDao);
        };


    }

    private void addAnAuthor(LibraryDao libraryDao) {

        log.info("Add an author details");
        Author author = new Author ("Prabin " , " poem "); // create object
        libraryDao.save(author); // save
        log.info("New author details added . authorId{} " , author.getAuthorId());// display the new added obj ID
    }

    private void findAuthorById(LibraryDao libraryDao) {
        log.info("Add an author details");
        Author author = new Author ("Prabin " , " Stories "); // create object
        libraryDao.save(author); // save
        log.info("fetch the Author by id ");

        Author author1 =    libraryDao.findById(author.getAuthorId()); // save
        log.info("fetched user author1{}" , author1);
        log.info("New author details added . authorId{} " , author.getAuthorId());// display the new added obj ID
    }

}
