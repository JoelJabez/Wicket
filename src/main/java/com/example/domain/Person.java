package com.example.domain;

import java.io.Serializable;

public record Person(String name, int age) implements Serializable {}
