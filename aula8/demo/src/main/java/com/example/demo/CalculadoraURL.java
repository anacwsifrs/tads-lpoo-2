package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraURL {

    @GetMapping("/calculadora")
    public String welcome() {
        return "instruções";
    }
    
    @GetMapping("/calculadora/mult/{n}/{n2}")
    public long mult(@PathVariable Long n,@PathVariable Long n2) {
        return n*n2;
    }
    
    @GetMapping("/calculadora/add/{n}/{n2}")
    public long add(@PathVariable Long n,@PathVariable Long n2) {
        return n+n2;
    }
    
    @GetMapping("/calculadora/sub/{n}/{n2}")
    public long sub(@PathVariable Long n,@PathVariable Long n2) {
        return n-n2;
    }
    
    @GetMapping("/calculadora/div/{n}/{n2}")
    public Double div(@PathVariable Double n, @PathVariable Double n2) {
        if (n2 == 0) {
            return null;
        }
        return n / n2;
    }

}