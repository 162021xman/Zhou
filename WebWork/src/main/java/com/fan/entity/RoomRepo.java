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
		    @Result(property = "owner_id", column = "owner_id"),
		    @Result(property = "pid", column = "pid"),
		    @Result(property = "wuyeid", column = "wuyeid")
			})
	@Select("select * from lab.room")
	public List<room> getAllRoom();
	
	@Select("select * from lab.room where owner_id=#{owner_id}")
	@ResultMap(value="RoomMap")
	public List<room> getRoomOwnerid(@Param("owner_id")String owner_id);
	
	@Select("select * from lab.room where wuyeid=#{wuyeid}")
	@ResultMap(value="RoomMap")
	public List<room> getRoomOwnerWuyeid(@Param("wuyeid")String wuyeid);
	
	@Select("select * from lab.room where rid=#{rid}")
	@ResultMap(value="RoomMap")
	public room getRoom(@Param("rid")String rid);
	
	@Select("select * from lab.room where pid=#{pid}")
	@ResultMap(value="RoomMap")
	public List<room> getRoomBypo(@Param("pid")String pid);
	
	@Insert("insert into lab.room(rid,rooms,space,owner_id,pid,wuyeid) values(#{rid},#{rooms},#{space},#{owner_id},#{pid},#{wuyeid})")
	@ResultMap("RoomMap")
	public int InsertRoom(@Param("rid")String rid,@Param("rooms")String rooms,
			@Param("space")String space,@Param("owner_id")String owner_id,@Param("pid")String pid,@Param("wuyeid")String wuyeid);
	
	@Delete("delete from lab.room where rid=#{rid};")
	@ResultMap(value="RoomMap")
	public int DelOwner(@Param("rid")String rid);
	
	@Update("update lab.room set rooms=#{rooms},space=#{space},owner_id=#{owner_id} where rid=#{rid}")
	@ResultMap("RoomMap")
	public int UpdateRoom(@Param("rid")String rid,@Param("rooms")String rooms,
			@Param("space")String space,@Param("owner_id")String owner_id);
	
	@Update("update lab.room set pid=#{pid} where wuyeid=#{wuyeid}")
	@ResultMap("RoomMap")
	public int UpdateRoomwuye(@Param("pid")String pid,@Param("wuyeid")String wuyeid);
}
