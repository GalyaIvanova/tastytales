package com.example.tastytales.users.module.dao;

import com.example.tastytales.users.module.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface GuestDao extends JpaRepository<Guest, Long> {

}

