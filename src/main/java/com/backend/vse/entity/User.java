package com.backend.vse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    @JsonSerialize(using= ToStringSerializer.class)
    Long index;
    String id;
    String name;
    String password;
    Integer age;
    String gender;
    String email;
    String school;
    Byte role;
    Byte status;
    String avatar;
}
