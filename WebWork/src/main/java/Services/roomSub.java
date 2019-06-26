package Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fan.entity.RoomRepo;
import domain.*;
@Service
public class roomSub {
@Autowired
private RoomRepo room;
public boolean InsertRoom(String rid,String rooms, String space, String owner_id,String pid,String wuyeid) {
	if(room.InsertRoom(rid, rooms, space, owner_id,pid,wuyeid)>0)
		return true;
	return false;
}
public room getRoom(String rid) {
	return room.getRoom(rid);
}
public boolean UpdateRoomwuye(String pid,String wuyeid) {
	if(room.UpdateRoomwuye(pid, wuyeid)>0)
		return true;
	return false;
}
public List<room> getRoomOwnerid(String owner_id){
	return room.getRoomOwnerid(owner_id);
}
public List<room> getAllRoom(){
	return room.getAllRoom();
}
public List<room> getRoomwuyeid(String wuyeid){
	return room.getRoomOwnerWuyeid(wuyeid);
}
}
