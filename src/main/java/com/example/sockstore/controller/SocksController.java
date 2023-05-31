package com.example.sockstore.controller;
import com.example.sockstore.SocksEnum;
import com.example.sockstore.dto.SocksDto;
import com.example.sockstore.service.SocksService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Socks controller")
@RestController
@RequestMapping(path = "/api/socks")
public class SocksController {

    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

@Operation(
    summary = "Добавление носков",
    description = "Позволяет добавить носки на склад",
    operationId="addSocks",
    responses = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not Found")
                    }
)
    @PostMapping("/income")
    public SocksDto addSocks(@RequestBody SocksDto socksDto){
        return socksService.addSocks(socksDto);
    }

    @Operation(
            summary = "Отпуск носков",
            description = "Позволяет забрать носки со склада",
            operationId="outcomeSocks",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Done"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @PostMapping("/outcome")
    public SocksDto outcomeSocks(@RequestBody SocksDto socksDto){
        return socksService.outcomeSocks(socksDto);
    }

    @Operation(
            summary = "Количество носков",
            description = "Позволяет узнать количество носков на складе",
            operationId="getSocks",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Done"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Forbidden"),
                    @ApiResponse(responseCode = "404", description = "Not Found")
            }
    )
    @GetMapping
    public Integer getSocks(@RequestParam(required = false) String color,
                            @RequestParam(defaultValue = "equal") SocksEnum socksEnum,
                            @RequestParam(required = false)@Min(0) @Max(100) Integer cottonPart){
        return socksService.findCountSocks(color,socksEnum,cottonPart);
    }

}

