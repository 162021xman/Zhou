package com.fan.entity;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import domain.fix;
import tool.DaoMs;
@Mapper()
public interface FixRepo{
	@Results(id="FixMap", value={ 
		    @Result(property = "fixid", column = "fixid"), 
		    @Result(property = "fixms", column = "fixms"),
		    @Result(property = "fixtype", column = "fixtype"),
		    @Result(property = "rid", column = "rid"),
		    @Result(property="time",column="time")
			})
	@Select("select * from lab.fix;")
	public List<fix> getAllfix();
	
	@Insert("insert into  lab.fix(fixid,fixms,fixtype,rid,time) values (#{fixid},#{fixms},#{fixtype},"
			+ "#{rid},#{time})")
	@ResultMap("FixMap")
	public int InsertFix(@Param("fixid")String fixid,@Param("fixms")String fixms,
			@Param("fixtype")String fixtype,@Param("rid")String rid,@Param("time")Date time);
	
	@Delete("delete from lab.fix where fixid=#{fixid};")
	@ResultMap("FixMap")
	public int DelOwner(@Param("fixid")String fixid);
	
	@Update("update lab.fix set fixid=#{fixid}, fixms=#{fixms},fixtype=#{fixtype},rid=#{rid} ")
	@ResultMap("FixMap")
	public int UpdateFix(@Param("fixid")String fixid,@Param("fixms")String fixms,
			@Param("fixtype")String fixtype,@Param("rid")String rid);
	
	@Results(value= {
			@Result(property="fixid",column="MAX(fixid)")
	})
	@Select("select MAX(fixid) from lab.fix")
	public String getMaxPk();
	
	@Delete("delete from lab.fix where rid=#{rid}")
	@ResultMap("FixMap")
	public int DelFixInRid(@Param("rid")String rid);
}
