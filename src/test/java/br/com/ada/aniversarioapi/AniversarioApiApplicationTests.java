package br.com.ada.aniversarioapi;

import br.com.ada.aniversarioapi.service.AniversarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AniversarioApiApplicationTests {


	@Autowired
	private AniversarioService aniversarioService;


	@Test
	void contextLoads() {
	}

}
