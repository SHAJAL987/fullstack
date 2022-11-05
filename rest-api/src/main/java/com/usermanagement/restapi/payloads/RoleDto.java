package com.usermanagement.restapi.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotEmpty
    @Size(min = 2, message = "Role name should be 2 characters.")
    private String role_name;
    @NotEmpty
    @Size(max = 100, message = "Role description not be Bigger than 100 characters." )
    private String role_desc;
    private String role_privilage;
    @NotNull(message = "Status must not be empty.")
    private String status;
    @NotNull(message = "Create by filed must not be empty.")
    private Long create_by;
    private Date create_date;
    private Set<Features> features = new HashSet<>();
}
