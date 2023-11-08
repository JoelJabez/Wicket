package com.example.domain;

import manifold.ext.props.rt.api.var;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    @var
    List<Apple> apples = new ArrayList<>();
}
