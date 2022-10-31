package com.usermanagement.restapi.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },
        mappedBy = "features"
    )
    @JsonIgnore
    private Set<Roles> roles = new HashSet<>();

}
