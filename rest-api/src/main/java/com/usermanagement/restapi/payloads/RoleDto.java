package com.usermanagement.restapi.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.usermanagement.restapi.models.Features;

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
public class RoleDto {
    private Long id;
    private String role_name;
    private String role_desc;
    private String role_privilage;
    private String status;
    private Long create_by;
    private Date create_date;
    private Set<Features> features = new HashSet<>();
}
