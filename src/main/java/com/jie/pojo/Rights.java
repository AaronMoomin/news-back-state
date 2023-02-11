package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rights {

    private int id;
    private String title;
    private String key;
    private int pagepermission;
    private int grade;
}
