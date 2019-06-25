package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.Bean.Teacher;

@Mapper
public interface TeacherRepository {
	@Results(id="teacherMap", value={ 
		    @Result(property = "id", column = "teacher_id",  jdbcType=JdbcType.INTEGER), 
		    @Result(property = "account", column = "teacher_account"),
		    @Result(property = "name", column = "teacher_name")
			})

			@Select("select * from t_teacher") 
			public List<Teacher> findAll();
			
			
}
