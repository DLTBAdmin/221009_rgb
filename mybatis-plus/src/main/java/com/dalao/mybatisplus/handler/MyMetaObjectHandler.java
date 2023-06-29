package com.dalao.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insert 自动填充。。。。");
        this.strictInsertFill(metaObject,"createTime", LocalDateTime.class,LocalDateTime.now());
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());

        //判断当前对象的自动填充属性是否已经进行填充
        Object age = this.getFieldValByName("age", metaObject);
        if (age == null){
            log.info("insert age 属性");
            this.strictInsertFill(metaObject,"age",Integer.class,3);
        }

        //判断当前的自动填充是否已经包含当前属性
        boolean hasAuthor = metaObject.hasSetter("author");
        if (hasAuthor){
            log.info("insert author 属性");
            this.strictInsertFill(metaObject,"author", String.class,"qwewqe");
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
    }
}
