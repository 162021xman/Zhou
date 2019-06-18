package com.fan.entity;

import java.util.List;

import org.apache.ibatis.annotations.*;
import domain.wuye;
@Mapper()
public interface wuyeRepo {
	@Results(id="wuyeMap", value={ 
		    @Result(property = "id", column = "id"), 
		    @Result(property = "ms", column = "ms")
		})
	@Select("select * from lab.wuye")
	public List<wuye> getAllwuye();
	
	@Select("select * from lab.wuye where id like #{id} and ms like #{ms}")
	@ResultMap("wuyeMap")
	public List<wuye> getwuye(@Param("id")String id,@Param("ms")String ms);
	
	@Insert("insert into lab.wuye(id,ms) values(#{id},#{ms})")
	@ResultMap("wuyeMap")
	public int Inserttwuye(@Param("id")String id,@Param("ms")String ms);
	
	@Update("update lab.wuye set ms=#{ms} where id like #{id})")
	@ResultMap("wuyeMap")
	public int Updatetwuye(@Param("id")String id,@Param("ms")String ms);
	
	@Delete("delete from lab.wuye where id like #{id}")
	@ResultMap("wuyeMap")
	public int Deletetwuye(@Param("id")String id);
}
