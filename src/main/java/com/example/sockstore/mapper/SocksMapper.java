package com.example.sockstore.mapper;


import com.example.sockstore.dto.SocksDto;
import com.example.sockstore.entity.Socks;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Маппинг из дто в сущность
 * Маппинг из сущности в дто
 */
@ComponentScan
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SocksMapper {

    SocksDto toDto(Socks socks);

    Socks toEntity(SocksDto socksDto);
}
