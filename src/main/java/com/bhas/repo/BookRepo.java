package com.bhas.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhas.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long>
{

}
