package com.example.tastytales.users.module.dao;

import com.example.tastytales.users.module.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {

}
