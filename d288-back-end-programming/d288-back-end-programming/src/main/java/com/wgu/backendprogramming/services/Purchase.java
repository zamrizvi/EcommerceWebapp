package com.wgu.backendprogramming.services;

import com.wgu.backendprogramming.entities.Cart;
import com.wgu.backendprogramming.entities.CartItem;
import com.wgu.backendprogramming.entities.Customer;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}
