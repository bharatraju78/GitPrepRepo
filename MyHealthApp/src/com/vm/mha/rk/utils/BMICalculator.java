package com.vm.mha.rk.utils;

public class BMICalculator {

	public static double getBMI(double weight, String weightScale, double height, String heightScale){
		
		/**
		 * Convert Weight In Pounds To Kilograms
		 */
		if(UnitScaleConstants.POUNDS.equalsIgnoreCase(weightScale)){
			weight = UnitConvertor.convertLbsToKg(weight);
		}
		
		/**
		 * Convert Height In Centimeters and inches to meters
		 */
		if(UnitScaleConstants.CENTIMETERS.equalsIgnoreCase(heightScale)){
			height = UnitConvertor.convertCmsToMeter(height);
		}else if(UnitScaleConstants.INCHES.equalsIgnoreCase(heightScale)){
			height = UnitConvertor.convertInchesToMeter(height);
		}
		return getBMI(weight, height);
	}
	
	
	
	public static double getBMI(double weight, double height){
		return MathUtils.round((weight)/ Math.pow(height, 2), MathUtilConstants.ROUND_TWO_DECIMALS);
	}
	
	public static String getStatus(double bmi){
		if (bmi < 18.5) {
			return BMIConstants.UNDERWEIGHT;
		} else if (bmi >= 18.5 && bmi < 25) {
			return BMIConstants.NORMAL;
		} else if (bmi >= 25 && bmi < 30) {
			return BMIConstants.OVERWEIGHT;
		} else {
			return BMIConstants.OBESE;
		}
	}
	
	public static void main(String[] args) {
		double bmi = BMICalculator.getBMI(171.961, UnitScaleConstants.POUNDS, 175, UnitScaleConstants.CENTIMETERS);
		System.out.println("BMI is : "+bmi);
		String bmiStatus = BMICalculator.getStatus(bmi);
		System.out.println("BMI Status is : "+bmiStatus);
		
	}
}
