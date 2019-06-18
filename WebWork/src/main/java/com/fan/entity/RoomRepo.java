package com.fan.entity;

import java.util.List;

import org.apache.ibatis.annotations.*;
import domain.room;
@Mapper()
public interface RoomRepo {
	@Results(id="RoomMap", value={ 
		    @Result(property = "rid", column = "rid"), 
		    @Result(property = "rooms", column = "rooms"),
		    @Result(property = "space", column = "space"),
		    @Result(property = "owner_id", column = "owner_id")
			})
	@Select("select * from lab.room")
	public List<room> getAllRoom();
	
	@Select("select * from lab.room where rid=#{rid};")
	@ResultMap(value="RoomMap")
	public room getRoom(@Param("rid")String rid);
	
	@Insert("insert into lab.room(rid,rooms,space,owner_id) values(#{rid},#{rooms},#{space},#{owner_id})")
	@ResultMap("RoomMap")
	public int InsertRoom(@Param("rid")String rid,@Param("rooms")String rooms,
			@Param("space")String space,@Param("owner_id")String owner_id);
	
	@Delete("delete from lab.room where rid=#{rid};")
	@ResultMap(value="RoomMap")
	public int DelOwner(@Param("rid")String rid);
	
	@Update("update lab.room set rid=#{rid},rooms=#{rooms},space=#{space},owner_id=#{owner_id}")
	@ResultMap("RoomMap")
	public int UpdateRoom(@Param("rid")String rid,@Param("rooms")String rooms,
			@Param("space")String space,@Param("owner_id")String owner_id);
}
