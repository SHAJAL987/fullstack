package com.usermanagement.restapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "ROLES")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", nullable = false)
    private String role_name;

    @Column(name = "role_desc", nullable = true)
    private String role_desc;

    @Column(name = "role_privilage")
    private String role_privilage;

    @Column(name = "status")
    private String status = "I";

    @Column(name = "create_by", nullable = false)
    private Long create_by;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "approved_by")
    private Long approved_by;

    @UpdateTimestamp
    @Column(name = "approved_date")
    private Date approved_date;

}
