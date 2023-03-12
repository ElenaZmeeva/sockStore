package com.example.sockstore.controller;

import com.example.sockstore.SocksEnum;
import com.example.sockstore.entity.Socks;
import com.example.sockstore.servise.SocksService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/socks")
public class SocksController {

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

@PostMapping("/income")
    public Socks addSocks(@RequestBody String color,
                          @RequestBody int cottonPart,
                          @RequestBody int quantity){
    return socksService.addSocks(color,cottonPart, quantity);
}

@PostMapping("/outcome")
    public Socks outcomeSocks(@RequestBody String color,
                              @RequestBody int cottonPart,
                              @RequestBody int quantity){
    return socksService.outcomeSocks(color,cottonPart,quantity);
}

@GetMapping
    public Integer getSocks(@RequestBody String color,
                            @RequestBody SocksEnum socksEnum,
                            @RequestBody Integer cottonPart){
        return socksService.findCountSocks(color,socksEnum,cottonPart);
}

}
