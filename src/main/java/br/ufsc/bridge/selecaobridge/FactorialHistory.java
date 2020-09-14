package br.ufsc.bridge.selecaobridge;

import java.math.BigInteger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FactorialHistory {
	private int number;
	private BigInteger factorial;
}