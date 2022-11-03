package com.usermanagement.restapi.payloads;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
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
    // private Set<Roles> roles = new HashSet<>();
}
