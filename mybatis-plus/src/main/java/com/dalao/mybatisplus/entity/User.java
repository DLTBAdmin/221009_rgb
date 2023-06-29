package com.dalao.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("t_user")
public class User {

//    @TableId(type = IdType.ASSIGN_ID)
    @TableId(value = "uid")
    private Long id;
    @TableField(value = "username")
    private String name;
    @TableField(fill = FieldFill.INSERT)
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

//    private Boolean deleted;
    @TableLogic
    @TableField(value = "is_deleted")
    private Integer deleted;

}
