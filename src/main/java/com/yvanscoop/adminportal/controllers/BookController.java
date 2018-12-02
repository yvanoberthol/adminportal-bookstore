package com.yvanscoop.adminportal.controllers;

import com.yvanscoop.adminportal.entities.content.Book;
import com.yvanscoop.adminportal.services.content.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/formBook")
    public String formBook(Model model){
        model.addAttribute("book",new Book());
        return "addBook";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);

        MultipartFile bookImage = book.getBookImage();
        try {
            byte[] bytes = bookImage.getBytes();
            String name = book.getId()+".png";
            BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream("src/main/resources/static/images/books/"+name));
            stream.write(bytes);
            stream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/book/bookList";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book") Book book){
        bookService.addBook(book);

        MultipartFile updateBookImage = book.getBookImage();
        if (!updateBookImage.isEmpty()){
            try {
                byte[] bytes = updateBookImage.getBytes();
                /*bookImage's name*/
                String name = book.getId()+".png";

                /*delete old bookImage*/
                Files.delete(Paths.get("src/main/resources/static/images/books/"+name));

                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream("src/main/resources/static/images/books/"+name));
                stream.write(bytes);
                stream.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return "redirect:/book/bookInfo?id="+book.getId();
    }

    @RequestMapping("/formUpdate")
    public String updateBook(@RequestParam("id") Long id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book",book);
        return "updateBook";
    }
    @RequestMapping("/bookInfo")
    public String bookInfo(@RequestParam("id") Long id, Model model){
        Book book = bookService.getBook(id);
        model.addAttribute("book",book);
        return "bookInfo";
    }
    @RequestMapping("/bookList")
    public String bookList(Model model){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);
        return "bookList";
    }

    @RequestMapping(value = "/deleteBook",method = RequestMethod.POST)
    public String addBook(@ModelAttribute("id") String id, Model model) {
        Long idBook = Long.parseLong(id.substring(8));
        bookService.removeOne(idBook);
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList);

        return "redirect:/book/bookList";
    }
}
