package com.sw5.spring.travel.plan.dto;

import lombok.*;

@Builder
@Getter
@AllArgsConstructor
public class UserDto {
    private String id;
    private String email;
    private String name;
    private String password;
}
