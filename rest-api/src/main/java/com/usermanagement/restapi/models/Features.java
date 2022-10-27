package com.usermanagement.restapi.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "FEATURES")
public class Features {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "feature_name", nullable = false)
    private String feature_name;

    @Column(name = "parent_feature", nullable = false)
    private Long parent_feature;

    @Column(name = "chiled_or_parent", nullable = false)
    private String chiled_or_parent;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "end_point", nullable = false)
    private String end_point;

    @Column(name = "status")
    private String status = "I";

    @Column(name = "create_by", nullable = false)
    private Long create_by;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "update_by")
    private Long update_by;

    @Column(name = "update_date")
    private Date update_date;


}
