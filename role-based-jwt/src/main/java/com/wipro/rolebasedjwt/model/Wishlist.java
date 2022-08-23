package com.wipro.rolebasedjwt.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wishlist")
public class Wishlist {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(targetEntity = DAOUser.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private DAOUser user;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;
    
    public Wishlist(DAOUser user, Product product) {
        this.user = user;
        this.product = product;
        this.createdDate = new Date();
    }
}
