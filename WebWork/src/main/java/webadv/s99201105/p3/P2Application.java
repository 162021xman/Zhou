package webadv.s99201105.p3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fan.entity.OwnerRepo;
import com.fan.entity.RentingRepo;
@SpringBootApplication
@ComponentScan(basePackages= {"example","webadv.s99201105.p3","domain","repository",
		"com.fan.entity","Controllers","Services"})
@MapperScan("com.fan.entity")
public class P2Application {
	public static void main(String[] args) {
		SpringApplication.run(P2Application.class, args);
	}

}
