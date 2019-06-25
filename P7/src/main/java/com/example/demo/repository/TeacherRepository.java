package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import com.example.demo.Bean.Teacher;

@Mapper
public interface TeacherRepository {
	@Results(id = "teacherMap", value = { @Result(property = "id", column = "id", jdbcType = JdbcType.INTEGER),
			@Result(property = "name", column = "name"), @Result(property = "phone", column = "phone") })

	@Select("select * from wuye")
	public List<Teacher> findAll();
	
	@Update("update wuye set name=#{name}, phone=#{phone} where id=#{id}")
	public int update(Teacher t);
}
