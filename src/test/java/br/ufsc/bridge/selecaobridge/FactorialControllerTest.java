package br.ufsc.bridge.selecaobridge;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // need this in Spring Boot test
public class FactorialControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFactorialFive() {
		try {
			mockMvc.perform(get("/factorial/5")).andExpect(status().isOk()).andExpect(content().string("120"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void factorialZero() {
		try {
			mockMvc.perform(get("/factorial/0")).andExpect(status().isOk()).andExpect(content().string("1"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void factorialOne() {
		try {
			mockMvc.perform(get("/factorial/1")).andExpect(status().isOk()).andExpect(content().string("1"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void factorialNegative() {
		try {
			mockMvc.perform(get("/factorial/-1")).andExpect(status().isBadRequest()).andExpect(result -> result
					.getResolvedException().getMessage().equals("Impossível calcular fatorial de número negativo"));
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}