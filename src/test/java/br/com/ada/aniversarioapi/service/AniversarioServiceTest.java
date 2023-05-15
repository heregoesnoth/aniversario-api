package br.com.ada.aniversarioapi.service;

import br.com.ada.aniversarioapi.repository.AniversarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class) //Runner
public class AniversarioServiceTest {

    @InjectMocks
    private AniversarioService aniversarioService;

    @Mock
    private AniversarioRepository aniversarioRepository;

    @Test
    @DisplayName("Testa se o atributo de aniversário é nulo")
    void testSeAniversarioNull() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            aniversarioService.getAniversarioValido(null);
        });

        String mensagemEsperada = "Deve incluir aniversarioString";
        String mensagemAtual = runtimeException.getMessage();

        assertTrue(mensagemAtual.contains(mensagemEsperada));

    }

    @Test
    @DisplayName("Quando formato for inválido, lança RuntimeException")
    void whenFormatoInvalidoThrowsRuntimeException() {
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            aniversarioService.getAniversarioValido("16/12/1993");
        });

        String mensagemEsperada = "Deve incluir dia de aniversario no formato dd-MM-yyyy";
        String mensagemAtual = runtimeException.getMessage();

        assertTrue(mensagemAtual.contains(mensagemEsperada));
    }


    @Test
    @DisplayName("Testa parse de data")
    void testParseDate() {
        LocalDate data = aniversarioService.getAniversarioValido("16-12-1993");
        assertTrue(data.isEqual(LocalDate.of(1993, 12, 16)));
    }
 }
