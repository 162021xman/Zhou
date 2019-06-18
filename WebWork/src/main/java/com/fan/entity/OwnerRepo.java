package com.fan.entity;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import domain.owner;
//
@Component
@Mapper()
public interface OwnerRepo {
	@Results(id="OwnerMap", value={ 
		    @Result(property = "ownerid", column = "ownerid"), 
		    @Result(property = "ownername", column = "ownername"),
		    @Result(property = "ownertel", column = "ownertel"),
		    @Result(property = "password", column = "password"),
		    @Result(property="NewMs",column="NewMs",jdbcType=JdbcType.INTEGER),
		    @Result(property="wuyeid",column="wuyeid")
			})
	@Select("select * from lab.owner")
	public List<owner> getAllOwner();
	
	@Select("select * from lab.owner where ownerid=#{ownerid};")
	@ResultMap(value="OwnerMap")
	public owner getOwner(@Param("ownerid")String ownerid);
	
	//@Delete("delete from lab.owner where ownerid in ")
	//@ResultMap(value="OwnerMap")
	//public int batchdelOwner();
	@Select("select * from lab.owner where ownerid=#{ownerid} and password=md5(#{password});")
	@ResultMap(value="OwnerMap")
	@Autowired
	public owner getLogin(@Param("ownerid")String ownerid,@Param("password")String password);
	
	@Select("select * from lab.owner where ownerid like #{ownerid} and ownername like #{ownername} and "
			+ "ownertel like #{ownertel} and ownertel like #{ownertel} and wuyeid like #{wuyeid}; ")
	@ResultMap(value="OwnerMap")
	public List<owner> getOwnerInParam(@Param("ownerid")String ownerid,
			@Param("ownername")String ownername ,@Param("ownertel")String ownertel,@Param("wuyeid") String wuyeid);
	
	
	
	@Insert("insert into lab.owner (ownerid,password,ownername,ownertel,NewMs) values(#{ownerid},"
			+ "md5(#{password}),#{ownername},#{ownertel},#{NewMs});")
	@ResultMap(value="OwnerMap")
	public int InsertOwner(@Param("ownerid")String ownerid,@Param("password")String password,
			@Param("ownername")String ownername ,@Param("ownertel")String ownertel);
	
	@Delete("delete from lab.owner where ownerid=#{ownerid};")
	@ResultMap(value="OwnerMap")
	public int DelOwner(@Param("ownerid")String ownerid);
	
	@Update("update lab.owner set " +"password=md5(#{password}),ownername=#{ownername},ownertel=#{ownertel} "
			+ "where ownerid=#{ownerid};")
	@ResultMap(value="OwnerMap")
	public int UpdateOwner(@Param("ownerid")String ownerid,@Param("password")String password,
			@Param("ownername")String ownername ,@Param("ownertel")String ownertel);
}
