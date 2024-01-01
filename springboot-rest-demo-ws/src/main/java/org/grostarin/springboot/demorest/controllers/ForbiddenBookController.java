package org.grostarin.springboot.demorest.controllers;
import javax.validation.Valid;


import org.grostarin.springboot.demorest.domain.ForbiddenBook;
import org.grostarin.springboot.demorest.services.ForbiddenBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//ForbiddenBookController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/forbidden-books")
public class ForbiddenBookController {

 @Autowired
 private ForbiddenBookService forbiddenBookService;

 @PostMapping
 public void addForbiddenBook(@RequestBody ForbiddenBook forbiddenBook) {
     forbiddenBookService.addForbiddenBook(forbiddenBook);
 }
}

