package com.usermanagement.restapi.payloads;

import java.util.Date;
import java.util.Set;

import com.usermanagement.restapi.models.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDto {
    private Long id;
    private String feature_name;
    private Long parent_feature;
    private String chiled_or_parent;
    private int level;
    private String end_point;
    private String status;
    private Long create_by;
    private Date create_date;
    private Set<Roles> roles;
}
