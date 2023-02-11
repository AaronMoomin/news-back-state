package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {

    private int id;
    private String roleName;
    private int roleType;
    private String rights;
}
