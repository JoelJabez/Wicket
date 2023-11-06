package com.example;

import java.io.Serializable;

public record Address(
		String street,
		String city,
		String state,
		String zipcode
) implements Serializable {}