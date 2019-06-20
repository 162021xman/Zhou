package com.fan.entity;

import java.util.List;

import org.apache.ibatis.annotations.*;
import domain.wuye;
@Mapper()
public interface wuyeRepo {
	@Results(id="wuyeMap", value={ 
		    @Result(property = "id", column = "id"), 
		    @Result(property = "ms", column = "ms"),
		    @Result(property = "password", column = "password")
		})
	@Select("select * from lab.wuye")
	public List<wuye> getAllwuye();
	
	@Select("select * from lab.wuye where id like #{id} and ms like #{ms}")
	@ResultMap("wuyeMap")
	public List<wuye> getwuye(@Param("id")String id,@Param("ms")String ms);
	@Select("@Select * from lab.wuye where  wuyeid=#{wuyeid} and password=md5(#{password})")
	public wuye getLoginwuye(@Param("id")String id,@Param("password") String password);
	
	@Insert("insert into lab.wuye(id,password,ms) values(#{id},md5(#{password}),#{ms})")
	@ResultMap("wuyeMap")
	public int Inserttwuye(@Param("id")String id,@Param("ms")String ms,@Param("password") String password);
	
	@Update("update lab.wuye set password=md5(#{password}) where id like #{id})")
	@ResultMap("wuyeMap")
	public int Updatetwuye(@Param("id")String id,@Param("password")String password);
	
	@Delete("delete from lab.wuye where id like #{id}")
	@ResultMap("wuyeMap")
	public int Deletetwuye(@Param("id")String id);
}
