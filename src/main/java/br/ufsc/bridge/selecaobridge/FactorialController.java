package br.ufsc.bridge.selecaobridge;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/")
public class FactorialController {
	
	@Autowired
	private FactorialCalculator factorialCalculator;
	
	@GetMapping("/")
	public String viewHome() {
        return "index";
    }
	
	@GetMapping("/factorial/{number}")
	@ResponseBody
	public BigInteger factorial(@PathVariable int number) throws Exception {
		if (number < 0)
			throw new Exception("Impossível calcular fatorial de número negativo");
		
		return factorialCalculator.factorial(number);
	}
}