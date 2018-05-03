package com.musala.kb.numeric.calc.imp;

import com.musala.kb.numeric.calc.UnvInterfaceNumCalc;

public class ContextNumericSystems {

	private UnvInterfaceNumCalc unvInterface;
	
	public void setUnvInterfaceNumCalc(UnvInterfaceNumCalc unvInterface) {
		this.unvInterface = unvInterface;
	}
	
	public int toDecimal(String inputString) {
		return unvInterface.toDecimal(inputString);
	}
	
	public String fromDecimal(String inputValue) {
		return unvInterface.fromDecimal(inputValue);
	}
	
}
