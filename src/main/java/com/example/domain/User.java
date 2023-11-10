package com.example.domain;

import manifold.ext.props.rt.api.var;

import java.io.Serializable;

public class User implements Serializable {
    @var
    String firstName;
    @var
    String lastName;
}
