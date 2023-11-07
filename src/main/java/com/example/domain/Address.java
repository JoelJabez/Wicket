package com.example.domain;

import manifold.ext.props.rt.api.var;

import java.io.Serializable;

public class Address implements Serializable {
	@var
	String street;
	@var
	String city;
	@var
	String state;
	@var
	String zipcode;
}