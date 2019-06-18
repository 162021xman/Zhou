package Services;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.INTERFACES)
public interface DataService {
 Class<?> select(String sql);
 Class<?>[] selects(String... sql);
 int delect(String sql);
 int update(String sql);
 int insert(String sql);
}
