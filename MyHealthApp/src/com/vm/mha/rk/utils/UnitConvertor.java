package com.vm.mha.rk.utils;

public class UnitConvertor {

	public static double convertKgToLbs(double value){
		return value * 2.20462;
	}
	
	public static double convertLbsToKg(double value){
		return value * 0.453592;
	}
	
	public static double convertCmsToInches(double value){
		return value * 0.393701;
	}
	
	public static double convertCmsToMeter(double value){
		return value * 0.01;
	}
	
	public static double convertInchesToMeter(double value){
		return value * 0.0254;
	}
}
