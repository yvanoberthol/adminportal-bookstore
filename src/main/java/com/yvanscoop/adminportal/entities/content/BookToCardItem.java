package com.yvanscoop.adminportal.entities.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class BookToCardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBookCardItem;

    @ManyToOne
    @JoinColumn(name = "cart_item_id")
    private CartItem cartItem;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
