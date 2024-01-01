package org.grostarin.springboot.demorest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//ForbiddenBook.java

@Entity
public class ForbiddenBook {

 @Id
 @Column(nullable = false, unique = true)
 private Long id;

 @Column(nullable = false, unique = true)
 private String title;

 @Column(nullable = false)
 private String author;
 
 
 public ForbiddenBook() {
     super();
 }

 public ForbiddenBook(String title, String author) {
     super();
     this.title = title;
     this.author = author;
 }

 public long getId() {
     return id;
 }

 public void setId(long id) {
     this.id = id;
 }

 public String getTitle() {
     return title;
 }

 public void setTitle(String title) {
     this.title = title;
 }

 public String getAuthor() {
     return author;
 }

 public void setAuthor(String author) {
     this.author = author;
 }
 
	@Override
 public String toString() {
     return "ForbiddenBook: [id=" + id + ", title=" + title + ", author=" + author + "]";
 }
	
}

