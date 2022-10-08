package com.tyc.JavaMonolithicExample.mapper;

import com.tyc.JavaMonolithicExample.dto.request.SaveUserRequestDto;
import com.tyc.JavaMonolithicExample.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(final SaveUserRequestDto requestDto);

}
