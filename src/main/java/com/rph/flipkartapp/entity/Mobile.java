package com.rph.flipkartapp.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "MOBILES")
@ToString
public class Mobile {
    @Id
    @Column(name = "MOBILE_ID")
    private Integer mobileId;

    @Column(name = "MOBILE_NAME")
    private String brand;

    @Column(name = "MOBILE_PRICE")
    private Double price;

    @Column(name = "MOBILE_RAM")
    private Integer ram;

    @Column(name = "MOBILE_RATING")
    private Integer rating;
}
