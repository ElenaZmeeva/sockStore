package com.example.sockstore.service;

import com.example.sockstore.SocksEnum;
import com.example.sockstore.dto.SocksDto;
import com.example.sockstore.entity.Socks;
import com.example.sockstore.mapper.SocksMapper;
import com.example.sockstore.repository.SocksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * Сервис
 * Методы добавления, отпуска носков
 * Метод определения количества носков
 */
@Slf4j
@Service
public class SocksService {

    private final SocksRepository socksRepository;

    private final SocksMapper mapper;

    public SocksService(SocksRepository socksRepository, SocksMapper mapper) {
        this.socksRepository = socksRepository;
        this.mapper = mapper;
    }

    /**
     * Определение количества носок на складе
     * Color - цвет
     * SocksEnum - оператор сравнения
     * CottonPart - количество хлопка в составе
     */
    public Integer findCountSocks(String color, SocksEnum socksEnum, Integer cottonPart) {
        if (socksEnum.equals(SocksEnum.moreThan)) {
            socksRepository.countSocksByCottonPartGreaterThan(cottonPart);
        }
        if (socksEnum.equals(SocksEnum.equal)) {
            socksRepository.countSocksByCottonPartEquals(cottonPart);
        }
        if (socksEnum.equals(SocksEnum.lessThan)) {
            socksRepository.countSocksByCottonPartLessThan(cottonPart);
        }
        return socksRepository.countSocks(socksEnum);
    }

    /**
     * Добавление носков на склад
     */
    public SocksDto addSocks(SocksDto socksDto){
        Socks socks=socksRepository.findByColorAndCottonPart(socksDto.getColor(), socksDto.getCottonPart())
                .orElse(new Socks(socksDto.getId(), socksDto.getColor(), socksDto.getCottonPart(), socksDto.getQuantity()));
        socksRepository.save(socks);
        log.info("Socks added");
        return mapper.toDto(socks);
    }

    /**
     * Отпуск носков со склада
     */
    public SocksDto outcomeSocks(SocksDto socksDto){
        Socks socks=socksRepository.findByColorAndCottonPart(socksDto.getColor(), socksDto.getCottonPart()).orElse(null);
        if (socks!=null & socks.getQuantity()<socksDto.getQuantity()){
            throw new RuntimeException("Такого количества носков нет на складе!");
        }
        socks.setQuantity(socks.getQuantity()- socksDto.getQuantity());
        socksRepository.save(socks);
        log.info("Socks are given away from warehouse");

        return mapper.toDto(socks);
    }
}
