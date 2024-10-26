package com.kapil.springbootmvc.Controller;

import com.kapil.springbootmvc.DTO.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class BookController {

    private List<Book> bookList=new ArrayList<>();
//    bookList.add();

    @GetMapping("/books")
    public String getBooks(Model model){
//        bookList.addAll(Arrays.asList(
//                new Book("Math", "Kapil"),
//                new Book("Science", "Anjali"),
//                new Book("History", "Raj"),
//                new Book("English", "Sonia")
//        ));

        model.addAttribute("books",bookList);
        return "bookList";
    }

    @PostMapping("add-book")
    public String addBook(@ModelAttribute Book book){
        bookList.add(book);
        return "redirect:/books";
    }

    @GetMapping("add-book")
    public String showAllBooks(Model model){
        model.addAttribute("book",new Book());
        return "addBook";
    }

}
