package com.fan.entity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import domain.policy;

public interface PolicyRepo {
	@Results(id="OwnerMap", value={ 
		    @Result(property = "policyid", column = "id"), 
		    @Result(property = "rid", column = "rid"),
		    @Result(property = "startime", column = "startime",jdbcType=JdbcType.DATE),
		    @Result(property = "ms", column = "ms"),
		    @Result(property="days",column="days",jdbcType=JdbcType.INTEGER)
			})
	@Select("select * from lab.policy")
	public List<policy> getAllpolicy();
	
	@Insert("insert into lab.policy(policyid,rid,startime,ms,days) values(#{policyid},#{rid},#{startime},#{ms},#{days})")
	public int InsertPolicy(@Param("policyid")String id,@Param("rid")String rid,
			@Param("startime")Date startime,@Param("ms")String ms,@Param("days")int days);
	
	@Select("select MAX(id) from lab.fix")
	public String getMaxPk();
}
