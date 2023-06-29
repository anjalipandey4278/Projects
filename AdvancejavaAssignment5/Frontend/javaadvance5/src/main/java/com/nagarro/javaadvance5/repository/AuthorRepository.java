package com.nagarro.javaadvance5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.javaadvance5.model.Author;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
