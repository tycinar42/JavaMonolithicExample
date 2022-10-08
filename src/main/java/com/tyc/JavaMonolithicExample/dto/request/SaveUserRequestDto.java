package com.tyc.JavaMonolithicExample.dto.request;

import com.tyc.JavaMonolithicExample.repository.entity.EUserGender;
import com.tyc.JavaMonolithicExample.repository.entity.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SaveUserRequestDto {
    private String name;
    private String surname;
    private String email;
    private String password;
    private EUserGender userGender;
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EUserType userType = EUserType.USER;
}
