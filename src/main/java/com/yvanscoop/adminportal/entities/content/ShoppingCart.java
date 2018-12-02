package com.yvanscoop.adminportal.entities.content;


import com.yvanscoop.adminportal.entities.security.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class ShoppingCart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idShoppingCart;
    private BigDecimal grandTotal;

    @OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartItem> cartItemList;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


}
