package com.vm.mha.rk.utils;

public class BodyFatCalculator {

	public static double getFatPercentage(String gender, double waist, double wrist, double hip, double forearm,
			double bodyWeight) {
		double bodyFatPercent = 0;
		double bodyFat = 0;
		System.out.println("Enter body weight (in pounds): ");
		System.out.println("Enter wrist measurement at fullest point (in inches): ");
		System.out.println("Enter waist measurement at the navel (in inches): ");
		System.out.println("Enter hip measurement at fullest point (in inches): ");
		System.out.println("Enter forearm measurement at fullest point (in inches): ");
		if (GenderConstants.FEMALE.equalsIgnoreCase(gender)) {
			bodyFat = bodyWeight - (((bodyWeight * 0.732) + 8.987) + (wrist / 3.140) - (waist * 0.157) - (hip * 0.249)
					+ (forearm * 0.434));
			bodyFatPercent = bodyFat * 100 / bodyWeight;

			System.out.println("Body fat: " + bodyFat);
			System.out.println("Body fat percentage: " + bodyFatPercent);
		} else if (GenderConstants.MALE.equalsIgnoreCase(gender)) {

			bodyFat = bodyWeight - (((bodyWeight * 1.082) + 94.42) - (waist * 4.15));
			bodyFatPercent = bodyFat * 100 / bodyWeight;

			System.out.println("Body fat: " + bodyFat);
			System.out.println("Body fat percentage: " + bodyFatPercent);
		} else {
			System.out.println("Invalid gender code.");
		}
		return MathUtils.round(bodyFatPercent, MathUtilConstants.ROUND_TWO_DECIMALS);
	}
	
	public static void main(String[] args) {
		System.out.println(BodyFatCalculator.getFatPercentage(GenderConstants.MALE, 37, 11, 39, 11, UnitConvertor.convertKgToLbs(77)));
	}
}
