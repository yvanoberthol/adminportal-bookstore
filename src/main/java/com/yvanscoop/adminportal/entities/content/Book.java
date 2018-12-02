package com.yvanscoop.adminportal.entities.content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private String format;

    @Column(columnDefinition = "text")
    private String description;

    private int numberOfPages;
    private int isbn;
    private double shippingWeight;

    private double listPrice;
    private double ourPrice;
    private boolean status = true;

    private int stockNumber;

    @Transient
    private MultipartFile bookImage;

    @OneToMany(mappedBy = "book")
    @JsonIgnore
    private List<BookToCardItem> bookToCardItemList;
}
