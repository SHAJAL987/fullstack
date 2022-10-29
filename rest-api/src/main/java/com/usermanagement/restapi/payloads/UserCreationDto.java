package com.usermanagement.restapi.payloads;

import java.util.Date;
import java.util.Set;

import com.usermanagement.restapi.models.UserRoles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationDto {
    private Long user_id;
    private String user_code;
    private String user_name;
    private String password;
    private String mobile;
    private String status;
    private Long create_by;
    private Date create_date;
    private Set<UserRoles> userRoles;
}
