package com.backend.vse.mapper;

import com.backend.vse.dto.StudentInfoDto;
import com.backend.vse.dto.StudentSimpleDto;
import com.backend.vse.entity.CourseExperiment;
import com.backend.vse.entity.StudentAttendCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface StudentAttendCourseMapper extends BaseMapper<StudentAttendCourse> {
    @Insert("INSERT INTO student_attend_course(`index`,`course_id`) VALUES (#{index},#{courseId})")
    int insert(@Param("index") Long index, @Param("courseId") Long courseId);

    @Insert("DELETE FROM student_attend_course WHERE `index` = #{index} AND course_id = #{courseId}")
    int delete(@Param("index") Long index, @Param("courseId") Long courseId);
    @Select("SELECT user.id AS stuId, user.name AS name, user.school, user.gender, user.email " +
            "FROM user " +
            "JOIN student_attend_course sac ON user.`index` = sac.`index` " +
            "WHERE user.role = 0 AND sac.course_id = #{courseId};")
    ArrayList<StudentInfoDto> getCourseStudents(@Param("courseId") Long courseId);

    @Select("SELECT u.id stuId, u.name name, u.school , u.gender , u.email " +
            "FROM vse.user u " +
            "LEFT JOIN vse.student_attend_course sac ON u.`index` = sac.`index` " +
            "WHERE sac.course_id != #{course_id} OR sac.course_id IS NULL;")
    ArrayList<StudentInfoDto> getCourseFreeStudents(long courseId);
    @Select("SELECT *" +
            "FROM student_attend_course " +
            "INNER JOIN course_experiment " +
            "ON student_attend_course.course_id = course_experiment.course_id " +
            "WHERE student_attend_course.index = #{index};")
    ArrayList<CourseExperiment> getExperimentByIndex(long index);
}
