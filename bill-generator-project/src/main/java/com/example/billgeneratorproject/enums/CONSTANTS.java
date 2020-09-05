package com.example.billgeneratorproject.enums;

public enum CONSTANTS {
	ONE(0);
	
	private final int value;

	CONSTANTS(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
