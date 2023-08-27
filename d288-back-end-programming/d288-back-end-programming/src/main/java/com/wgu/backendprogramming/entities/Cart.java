package com.wgu.backendprogramming.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_ID")
    private Long id;

    @Column(name = "Order_Tracking_Number")
    private String orderTrackingNumber;

    @Column(name = "Package_Price")
    private BigDecimal package_price;

    @Column(name = "Party_Size")
    private int party_size;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status")
    private StatusType status;

    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "Customer_ID", nullable = false)
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItem = new HashSet<>();

    public void addItem (CartItem item) {
        if (item != null) {
            if (cartItem == null) {
                cartItem = new HashSet<>();
            }
        }

        cartItem.add(item);
        item.setCart(this);
    }
    public Cart() {
    }
}
