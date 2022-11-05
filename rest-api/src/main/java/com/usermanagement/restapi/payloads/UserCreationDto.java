package com.usermanagement.restapi.payloads;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.usermanagement.restapi.models.UserRoles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    private Long user_id;
    @NotNull(message = "User code must not be empty.")
    private String user_code;
    @NotNull(message = "User name must not be empty.")
    private String user_name;
    @NotNull(message = "Password must not be empty.")
    private String password;
    private String mobile;
    private String status;
    @NotNull(message = "Created user must not be empty.")
    private Long create_by;
    private Date create_date;
    private Set<UserRoles> userRoles;
}
