package com.changwook.boardservice.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AddMemberDto {
    private String email;
    private String password;
    private String name;
    private String nickName;
}
