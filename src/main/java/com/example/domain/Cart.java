package com.example.domain;

import manifold.ext.props.rt.api.var;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;
    @var
    List<Phone> phones = new ArrayList<>();
}
