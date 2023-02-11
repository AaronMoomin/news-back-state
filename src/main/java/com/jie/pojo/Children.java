package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Children {

    private int id;
    private String title;
    private int rightId;
    private String key;
    private int grade;
    private int pagepermission;
}
