package com.backend.vse.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "experiment_submit")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExperimentSubmit {
    @JsonSerialize(using= ToStringSerializer.class)
    Long reportId;
    @JsonSerialize(using= ToStringSerializer.class)
    Long id;
    @JsonSerialize(using= ToStringSerializer.class)
    Long experimentId;
    @JsonSerialize(using= ToStringSerializer.class)
    Long courseId;
    String content;
    Date time;
}
