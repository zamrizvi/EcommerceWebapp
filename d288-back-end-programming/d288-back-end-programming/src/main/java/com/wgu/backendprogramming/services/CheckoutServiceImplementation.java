package com.wgu.backendprogramming.services;

import com.wgu.backendprogramming.dao.CartRepository;
import com.wgu.backendprogramming.dao.CustomerRepository;
import com.wgu.backendprogramming.entities.Cart;
import com.wgu.backendprogramming.entities.CartItem;
import com.wgu.backendprogramming.entities.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImplementation implements CheckoutService{

    private CustomerRepository customerRepository;

    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImplementation(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {


            //retrieve order info
            Cart cart = purchase.getCart();

            //generate tracking number
            String orderTrackingNumber = generateOrderTrackingNumber();
            cart.setOrderTrackingNumber(orderTrackingNumber);

            //populate with cartItems
            Set<CartItem> cartItems = purchase.getCartItems();
            cartItems.forEach(item -> cart.addItem(item));

            //save to database
            cartRepository.save(cart);

            //return a response
            return new PurchaseResponse(orderTrackingNumber);

    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    private String generateOrderTrackingNumber() {
        //generate random UUID number
        return UUID.randomUUID().toString();
    }
}
