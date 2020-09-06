package com.example.billgeneratorproject.enums;

public enum CONSTANTS {
	ONE(1);
	
	private final int value;

	CONSTANTS(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
