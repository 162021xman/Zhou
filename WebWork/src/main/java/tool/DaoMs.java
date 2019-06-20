package tool;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
@Component
@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode=ScopedProxyMode.INTERFACES)
public class DaoMs {
public static  String getClassMs(Object o) throws IllegalArgumentException, IllegalAccessException {
	
	Method[] ms=o.getClass().getDeclaredMethods();
	StringBuffer stu=new StringBuffer();
	Field[] fs=o.getClass().getDeclaredFields();
	for(int i=0;i<ms.length;i++) {
		stu.append(ms[i].getName()+"/");
	}
	stu.append("\n");
	for(int i=0;i<fs.length;i++) {
		fs[i].setAccessible(true);
		stu.append(fs[i].getName());
		stu.append("/");
	}
	return o.getClass().getName()+":"+stu.toString();
}
}
