package com.usermanagement.restapi.payloads;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "Feature Name Cannot be Enpty.")
    @Size(min = 2, max = 20)
    private String feature_name;
    @NotNull(message = "Parent Feature Id. Cannot be Empty.")
    @Size(max = 3)
    private Long parent_feature;
    @NotNull(message = "Feture Type Cannot be Empty.")
    private String chiled_or_parent;
    @NotNull(message = "Feature Level Cannot be Empty.")
    private int level;
    @NotNull(message = "Feature Url Cannot be Empty.")
    private String end_point;
    private String status;
    @NotNull(message = "Created User Id Cannot be Empty.")
    private Long create_by;
    private Date create_date;
    private String res_code;
    private String res_message;
    // private Set<Roles> roles = new HashSet<>();
}
