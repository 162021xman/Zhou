package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import com.example.demo.Bean.inform;

@Mapper
public interface informmatinRepository {
     @Results(id="informMap",value= {
    		@Result(property="zid" ,column="zid", jdbcType=JdbcType.INTEGER),
    		@Result(property="zconten",column="zconten")
    		 
     })
     
     @Select("select * from investinf")
     public List<inform> findAll();
     
     
     @Delete("delete from investinf where zid=#{zid};")
     @ResultMap(value="informMap")
     public int Delinform(@Param("zid")String zid);
}
