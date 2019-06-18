package com.fan.entity;

import java.util.Date;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import domain.renting;
@Mapper()
@Component
public interface RentingRepo {
	@Results(id="RentingMap", value={ 
		    @Result(property = "rid", column = "rid"), 
		    @Result(property = "ownerid", column = "ownerid"),
		    @Result(property = "rentmoney", column = "rentmoney",jdbcType=JdbcType.FLOAT),
		    @Result(property = "renttime", column = "renttime",jdbcType=JdbcType.DATETIMEOFFSET)
			})
	@Select("select * from lab.renting")
	public List<renting> getAllrenting();
	
	@Select("select * from lab.renting where rid like #{rid} and ownerid like #{ownerid};")
	@ResultMap(value="RentingMap")
	public renting getRenting(@Param("rid")String rid,@Param("ownerid")String ownerid);
	
	@Insert("insert into lab.renting(rid,ownerid,rentmoney,renttime) values(#{rid}"
			+ ",#{ownerid},#{rentmoney},#{renttime})")
	@ResultMap("RentingMap")
	public int InsertRenting(@Param("rid")String rid,@Param("ownerid")String ownerid
			,@Param("rentmoney")float rentmoney,@Param("renttime")Date renttime );
	
	@Update("update lab.renting set rid=#{rid},ownerid=#{ownerid},rentmoney=#{rentmoney},"
			+ "renttime=#{renttime}")
	@ResultMap("RentingMap")
	public int UpdateRenting(@Param("rid")String rid,@Param("ownerid")String ownerid
			,@Param("rentmoney")float rentmoney,@Param("renttime")Date renttime);
}
