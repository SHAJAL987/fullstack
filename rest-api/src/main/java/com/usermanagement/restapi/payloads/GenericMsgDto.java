package com.usermanagement.restapi.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericMsgDto {
    private String res_code;
    private String res_message;
}
