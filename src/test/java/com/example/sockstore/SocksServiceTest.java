package com.example.sockstore;

import com.example.sockstore.dto.SocksDto;
import com.example.sockstore.entity.Socks;
import com.example.sockstore.mapper.SocksMapper;
import com.example.sockstore.repository.SocksRepository;
import com.example.sockstore.service.SocksService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

public class SocksServiceTest {

    @Mock
    SocksRepository repository;
    @Mock
    SocksMapper mapper;
    SocksService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.service = new SocksService(repository, mapper);
    }


    @Test
    void testAddSocks() {
        SocksDto dto = new SocksDto();
        Socks entity = mapper.toEntity(dto);
        when(repository.save(entity)).thenReturn(entity);
    }

    @Test
    void testFindCountSocks() {
    when(repository.countSocksByCottonPartGreaterThan(20)).thenReturn(20);
        Assertions.assertEquals(20,20);
    when(repository.countSocksByCottonPartEquals(50)).thenReturn(50);
        Assertions.assertEquals(50,50);
    when(repository.countSocksByCottonPartLessThan(30)).thenReturn(30);
        Assertions.assertEquals(30,30);
    }

    @Test
    void testOutcomeSocks() {
        SocksDto dto = new SocksDto();
        Socks entity = mapper.toEntity(dto);
        when(repository.save(entity)).thenReturn(entity);
    }
}