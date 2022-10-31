package com.usermanagement.restapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GLOBALRULES")
public class GlobalRules {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand_name")
    private String brand_name;

    @Column(name = "banner", length = 100000)
    private byte[] banner;
}
