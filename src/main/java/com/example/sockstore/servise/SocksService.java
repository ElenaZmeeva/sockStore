package com.example.sockstore.servise;

import com.example.sockstore.SocksEnum;
import com.example.sockstore.entity.Socks;
import com.example.sockstore.repository.SocksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocksService {

    private final SocksRepository socksRepository;

    public SocksService(SocksRepository socksRepository) {
        this.socksRepository = socksRepository;
    }

    public Integer findCountSocks(String color, SocksEnum socksEnum, Integer cottonPart){
        if(socksEnum.equals(SocksEnum.moreThan)){
            socksRepository.countSocksByCottonPartGreaterThan(cottonPart);
        }
        if(socksEnum.equals(SocksEnum.equal)){
            socksRepository.countSocksByCottonPartEquals(cottonPart);
        }
        if (socksEnum.equals(SocksEnum.lessThan)){
            socksRepository.countSocksByCottonPartLessThan(cottonPart);
        }
       return socksRepository.countSocks(socksEnum);
    }

    public Socks addSocks(String color, int cottonPart, int quantity){
        Socks socks= socksRepository.findByColorAndCottonPart(color, cottonPart).orElse(null);
        Socks addedSocks= new Socks();
        assert socks != null;
        addedSocks.setQuantity(socks.getQuantity()+quantity);
        addedSocks.setColor(color);
        addedSocks.setCottonPart(cottonPart);

        return socksRepository.save(addedSocks);
    }

    public Socks outcomeSocks(String color, int cottonPart, int quantity){
        Socks socks= socksRepository.findByColorAndCottonPart(color, cottonPart).orElse(null);
        Socks outcomeSocks= new Socks();
        assert socks != null;
        outcomeSocks.setQuantity(socks.getQuantity()-quantity);

        return socksRepository.save(outcomeSocks);
    }

    public List<Socks> findAllSocks(){
      return  socksRepository.findAll();
    }
}
