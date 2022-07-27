package com.company.recipe.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    
    @NotNull
    @Column(name = "is_veg")
    private boolean isVeg;
    
    @NotNull
    @Column(name = "serving_count")
    private int servingCount;
    
    @Column(name = "is_igredients_include")
    private boolean isIgredientsInclude;

    @Column(name = "ingredients")
    private String ingredients;
    
    @Column(name = "discription")
    private String discription;

    
}
