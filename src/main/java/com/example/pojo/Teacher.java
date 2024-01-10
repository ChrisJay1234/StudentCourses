package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private Integer teamId;
    private String info;
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
