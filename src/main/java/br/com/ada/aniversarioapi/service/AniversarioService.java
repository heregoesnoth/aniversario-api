package br.com.ada.aniversarioapi.service;

import br.com.ada.aniversarioapi.repository.AniversarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class AniversarioService {

    private final AniversarioRepository aniversarioRepository;
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public LocalDate getAniversarioValido(String aniversarioString) {
        if (aniversarioString == null) {
            throw new RuntimeException("Deve incluir aniversarioString");
        }

        try {
            return LocalDate.parse(aniversarioString, formato);
        } catch (Exception e) {
            throw new RuntimeException("Deve incluir dia de aniversario no formato dd-MM-yyyy");
        }
    }

    
    public String getDiaDaSemanaDoAniversario(LocalDate aniversario) {
        return aniversario.getDayOfWeek().toString();
    }

    
    public String getZodiacoChines(LocalDate aniversario) {
        int ano = aniversario.getYear();
        switch (ano % 12) {
            case 0:
                return "Macaco";
            case 1:
                return "Galo";
            case 2:
                return "Cachorro";
            case 3:
                return "Porco";
            case 4:
                return "Rato";
            case 5:
                return "Boi";
            case 6:
                return "Tigre";
            case 7:
                return "Coelho";
            case 8:
                return "Dragão";
            case 9:
                return "Cobra";
            case 10:
                return "Cavalo";
            case 11:
                return "Ovelha";
            default:
                return "";
        }

    }

    
    public String getSigno(LocalDate aniversario) {
        int dia = aniversario.getDayOfMonth();
        int mes = aniversario.getMonthValue();

        if (mes == 12 && dia >= 22 || mes == 1 && dia < 20) {
            return "Capricónio";
        } else if (mes == 1 && dia >= 20 || mes == 2 && dia < 19) {
            return "Aquário";
        } else if (mes == 2 && dia >= 19 || mes == 3 && dia < 21) {
            return "Peixes";
        } else if (mes == 3 && dia >= 21 || mes == 4 && dia < 20) {
            return "Áries";
        } else if (mes == 4 && dia >= 20 || mes == 5 && dia < 21) {
            return "Touro";
        } else if (mes == 5 && dia >= 21 || mes == 6 && dia < 21) {
            return "Gêmeos";
        } else if (mes == 6 && dia >= 21 || mes == 7 && dia < 23) {
            return "Câncer";
        } else if (mes == 7 && dia >= 23 || mes == 8 && dia < 23) {
            return "Leão";
        } else if (mes == 8 && dia >= 23 || mes == 9 && dia < 23) {
            return "Virgem";
        } else if (mes == 9 && dia >= 23 || mes == 10 && dia < 23) {
            return "Libra";
        } else if (mes == 10 && dia >= 23 || mes == 11 && dia < 22) {
            return "Escorpião";
        } else if (mes == 11 && dia >= 22 || mes == 12 && dia < 22) {
            return "Sagitário";
        }
        return "";
    }

}
