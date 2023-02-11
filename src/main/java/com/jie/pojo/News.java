package com.jie.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    private int id;
    private String title;
    private int categoryId;
    private String content;
    private String region;
    private String author;
    private int roleId;
    private int auditState;
    private int publishState;
    private String createTime;
    private int star;
    private int view;
    private String publishTime;
}
