package br.com.ada.aniversarioapi.controller;

import br.com.ada.aniversarioapi.service.AniversarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/aniversario")
public class AniversarioController {

    private final AniversarioService aniversarioService;


    @GetMapping("/dia-da-semana")
    public String getDiaDaSemana(@RequestParam(value = "aniversario", required = false) String aniversarioString) {
        LocalDate birthday = aniversarioService.getAniversarioValido(aniversarioString);
        return aniversarioService.getDiaDaSemanaDoAniversario(birthday);
    }

    @GetMapping("/zodiaco-chines")
    public String getZodiacoChines(@RequestParam(value = "aniversario", required = false) String aniversarioString) {
        LocalDate birthday = aniversarioService.getAniversarioValido(aniversarioString);
        return aniversarioService.getZodiacoChines(birthday);
    }

    @GetMapping("/signo")
    public String getSigno(@RequestParam(value = "aniversario", required = false) String aniversarioString) {
        LocalDate birthday = aniversarioService.getAniversarioValido(aniversarioString);
        return aniversarioService.getSigno(birthday);
    }
}
