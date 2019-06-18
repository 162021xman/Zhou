package Services;

import java.util.HashMap;
import java.util.Map;

public class error {
private static Map array;
private String s1="操作失败";
public error() {
	initarray();
}
  public static void initarray() {
	  array=new HashMap();
	  array.put("owner","业主");
	  array.put("room","楼室");
	  array.put("fix","物业");
	  array.put("policy","优惠政策");
	  
  }
public static Map getArray() {
	return array;
}
public static void setArray(Map array) {
	error.array = array;
}
public String getS1() {
	return s1;
}
public void setS1(String s1) {
	this.s1 = s1;
}
}

