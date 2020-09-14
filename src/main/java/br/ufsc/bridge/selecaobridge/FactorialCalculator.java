package br.ufsc.bridge.selecaobridge;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import com.google.common.math.BigIntegerMath;

@Service
public class FactorialCalculator {
	public BigInteger factorial(int n) {
		return BigIntegerMath.factorial(n);
		/*
		 * Código antigo.
		int result = 1;

        for (int factor = 2; factor <= n; factor++) {
            result *= factor;
        }

        return result;
        */
	}
}