package com.usermanagement.restapi.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_code"}),
    @UniqueConstraint(columnNames = {"user_name"})
})
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "user_code", nullable = false)
    private String user_code;

    @Column(name = "user_name", nullable = false)
    private String user_name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "status")
    private String status = "I";

    @Column(name = "create_by", nullable = false)
    private Long create_by;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "approved_by")
    private Long approved_by;

    @Column(name = "approved_date")
    private Date approved_date;

    @OneToMany(mappedBy = "users",orphanRemoval=true, cascade=CascadeType.PERSIST)
    private Set<UserRoles> userRoles;

}
