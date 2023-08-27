package com.wgu.backendprogramming.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="divisions")
@Getter
@Setter
public class Division {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Division_ID")
    private Long id;

    @Column(name = "Division")
    private String division_name;

    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date last_update;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customer = new HashSet<>();

    @Column(name = "country_id")
    private long country_id;



 public void setCountry(Country country) {
     setCountry_id(country.getId());
     this.country = country;
    }

    public Division() {

    }

   
}
