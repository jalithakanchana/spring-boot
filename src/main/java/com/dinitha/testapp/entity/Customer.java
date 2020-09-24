package com.dinitha.testapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @SequenceGenerator(name="generator", sequenceName="CUSTOMERS_SEQ",allocationSize=1)
    @GeneratedValue(generator = "generator")
    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "email")
    private String email;


    @Column(name = "pwd_hash")
    private String pwdHash;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_1")
    private String phone1;

}