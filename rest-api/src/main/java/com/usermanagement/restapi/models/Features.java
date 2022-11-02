package com.usermanagement.restapi.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name = "FEATURES")
public class Features {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "feature_name")
    private String feature_name;

    @Column(name = "parent_feature")
    private Long parent_feature;

    @Column(name = "chiled_or_parent",nullable = true)
    private String chiled_or_parent;

    @Column(name = "level")
    private int level;

    @Column(name = "end_point")
    private String end_point;

    @Column(name = "status")
    private String status = "I";

    @Column(name = "create_by")
    private Long create_by;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "update_by")
    private Long update_by;

    @Column(name = "update_date")
    private Date update_date;

    @ManyToMany(mappedBy = "features",fetch = FetchType.LAZY)
    private Set<Roles> roles = new HashSet<>();

}
