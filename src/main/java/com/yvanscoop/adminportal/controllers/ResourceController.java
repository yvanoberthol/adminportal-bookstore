package com.yvanscoop.adminportal.controllers;


import com.yvanscoop.adminportal.services.content.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ResourceController {
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/book/deleteBookList", method = RequestMethod.POST)
    public String removeList(
            @RequestBody ArrayList<String> bookIdList
            ){

        for (String id: bookIdList){
            String bookid = id.substring(8);
            bookService.removeOne(Long.parseLong(bookid));
        }
        return "delete success";
    }
}
