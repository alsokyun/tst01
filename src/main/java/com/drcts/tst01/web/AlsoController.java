package com.drcts.tst01.web;


import com.drcts.tst01.web.dto.AlsoResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlsoController {

    @GetMapping("/also")
    public String also(){
        return "alsokyun";
    }


    @GetMapping("/also/dto")
    public AlsoResponseDto also_dto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new AlsoResponseDto(name, amount);
    }
}
