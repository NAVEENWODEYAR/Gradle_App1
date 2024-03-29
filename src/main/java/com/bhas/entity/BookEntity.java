package com.bhas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book_Table")
public class BookEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long bookId;
	
	private String bookName;
	private String bookAuthor;
	private int bkYearOfPublished;
}
