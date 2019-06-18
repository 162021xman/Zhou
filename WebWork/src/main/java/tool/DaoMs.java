package tool;

import java.lang.reflect.Method;

public class DaoMs {
public static  String getClassMs(Object o) {
	
	Method[] ms=o.getClass().getDeclaredMethods();
	StringBuffer stu=new StringBuffer();
	for(int i=0;i<ms.length;i++) {
		stu.append(ms[i].getName()+"/");
	}
	return o.getClass().getName()+":"+stu.toString();
}
}
