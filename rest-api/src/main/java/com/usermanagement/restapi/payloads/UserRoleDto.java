package com.usermanagement.restapi.payloads;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {
    private Long id;
    @NotNull(message = "User id must not be enpty.")
    private Long user_id_pk;
    @NotNull(message = "Role id must not be empty.")
    private Long role_id_pk;
    @NotNull(message = "Create by user must not be empty.")
    private Long create_by;
    private Date create_date;
    private String status;
    private String resCode;
    private String resMessage;
}
