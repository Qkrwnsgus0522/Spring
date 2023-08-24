package day59;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ss")
public class SamsungTV implements TV {

	@Autowired
	private Remote remote;
	// 1. 의존관계 발생
	// 2. 의존 주입(DI)
	//  1) 생성자 주입
	//  2) setter 주입
	// 3. 설정(.xml)
	//  : POJO -> 스프링 컨테이너한테 설정을 해야하므로 applicationContext.xml
	//  만약에 not POJO(서블릿)였다면 서블릿 컨테이너(톰캣)한테 설정을 해야하므로 web.xml
	
	@Override
	public void funcA() {
		remote.funcA();
		System.out.println("SamsungTV 전원 ON/OFF");
	}

	@Override
	public void funcB() {
		remote.funcB();
		System.out.println("SamsungTV 채널변경");
	}

}
