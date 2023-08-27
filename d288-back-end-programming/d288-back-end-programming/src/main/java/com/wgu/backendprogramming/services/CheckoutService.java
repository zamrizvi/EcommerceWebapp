package com.wgu.backendprogramming.services;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
